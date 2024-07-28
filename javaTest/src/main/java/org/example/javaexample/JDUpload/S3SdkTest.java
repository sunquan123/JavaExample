package org.example.javaexample.JDUpload;

import com.amazonaws.*;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.model.*;
import com.google.gson.Gson;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class S3SdkTest {
    public static void main(String[] args) {
        final String accessKey = "JDC_1F473A47E2B3F396DE48920C80F2";
        final String secretKey = "6B6659987AC9110DCF4666F439BAD4A0";
        final String endpoint = "https://s3.cn-north-1.jdcloud-oss.com";
        ClientConfiguration config = new ClientConfiguration();

        AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration(endpoint, "<REGION>");

        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AmazonS3 s3 = AmazonS3Client.builder().withEndpointConfiguration(endpointConfig).withClientConfiguration(config).withCredentials(awsCredentialsProvider).disableChunkedEncoding().build();

        // 初始化分片上传
        String bucket_name = "sunbeijing";
        String file_path = "D:\\projects\\aliyun\\aliyun_m_system.raw";
        String key = Paths.get(file_path).getFileName().toString();
        File file = new File(file_path);
        long contentLength = file.length();
        long partSize = 5 * 1024 * 1024; // 设置每个分片大小为5MB.

        try {
            // 创建对象的Etag列表，并取回每个分片的Etag。
            List<PartETag> partETags = new ArrayList<PartETag>();
            // 初始化分片上传
            InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucket_name, key);
            InitiateMultipartUploadResult initResponse = s3.initiateMultipartUpload(initRequest);
            Gson gson = new Gson();
            System.out.println("initResponse:" + gson.toJson(initResponse));
            // 上传分片
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                partSize = Math.min(partSize, (contentLength - filePosition));
                UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(bucket_name).withKey(key).withUploadId(initResponse.getUploadId()).withPartNumber(i).withFileOffset(filePosition).withFile(file).withPartSize(partSize);
                // 上传分片并将返回的Etag加入列表中
                UploadPartResult uploadResult = s3.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());
                filePosition += partSize;
                System.out.println("uploaded filePosition:{" + filePosition + "}, need upload:{" + (contentLength - filePosition) + "}");
            }

            // 完成分片上传
            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucket_name, key, initResponse.getUploadId(), partETags);
            s3.completeMultipartUpload(compRequest);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }
}

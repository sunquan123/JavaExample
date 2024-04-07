package org.example.JavaGuide.downloadfile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class downloadMain {
  public static File downloadFile(String urlPath, String downloadDir) {
    File file = null;
    try {
      // 统一资源
      URL url = new URL(urlPath);
      // 连接类的父类，抽象类
      URLConnection urlConnection = url.openConnection();
      // http的连接类
      HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
      // 设定请求的方法，默认是GET
      httpURLConnection.setRequestMethod("GET");
      // 设置字符编码
      httpURLConnection.setRequestProperty("Charset", "UTF-8");
      // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
      httpURLConnection.connect();

      // 文件大小
      int fileLength = httpURLConnection.getContentLength();

      // 文件名
      String filePathUrl = httpURLConnection.getURL().getFile();
      String fileFullName = "aa.pdf";

      System.out.println("file length---->" + fileLength);

      URLConnection con = url.openConnection();

      BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());

      String path = downloadDir + File.separatorChar + fileFullName;
      file = new File(path);
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      OutputStream out = new FileOutputStream(file);
      int size = 0;
      int len = 0;
      byte[] buf = new byte[1024];
      while ((size = bin.read(buf)) != -1) {
        len += size;
        out.write(buf, 0, size);
        // 打印下载百分比
        // System.out.println("下载了-------> " + len * 100 / fileLength +
        // "%\n");
      }
      bin.close();
      out.close();
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      return file;
    }
  }

  public static void main(String[] args) {

    // 下载文件测试
    downloadFile(
        "http://192.168.56.100:8089/cache/files/conv_abef979e37114b08a75212505bd9f82a_pdf/output.pdf/%E5%A6%82%E4%BD%95%E6%8F%90%E9%AB%98%E8%87%AA%E5%B7%B1%E9%9D%A2%E8%AF%95%E8%83%BD%E5%8A%9B.pdf?md5=OA5Hy5Tj8xLHcMY7w-YHig&expires=1692607711&filename=%E5%A6%82%E4%BD%95%E6%8F%90%E9%AB%98%E8%87%AA%E5%B7%B1%E9%9D%A2%E8%AF%95%E8%83%BD%E5%8A%9B.pdf",
        "D:\\ruoyi\\");
  }
}

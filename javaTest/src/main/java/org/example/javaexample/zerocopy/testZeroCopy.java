package org.example.javaexample.zerocopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class testZeroCopy {
  public static void main(String[] args) throws IOException {
    testSendFile();
    testMmap();
  }

  public static void testSendFile() throws IOException {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.connect(new InetSocketAddress("localhost", 8088));
    String fileName = "test.txt";
    // 得到一个文件channel
    FileChannel fileChannel = new FileInputStream(fileName).getChannel();
    /** 在linux下的一个transferTo方法即可完成传输 在windows下一次transferTo调用只能发送8M，大文件需要分段传输文件 transferTo底层使用零拷贝 */
    long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
    // 关闭
    fileChannel.close();
  }

  public static void testMmap() throws IOException {
    File file = new File("test.txt");
    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
    // 获取对应的通道
    FileChannel channel = randomAccessFile.getChannel();
    // mmap
    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
  }
}

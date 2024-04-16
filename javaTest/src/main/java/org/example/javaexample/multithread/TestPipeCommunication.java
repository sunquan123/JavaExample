package org.example.javaexample.multithread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class TestPipeCommunication {
  public static void main(String[] args) throws IOException {
    System.out.println("main-thread start");
    PipedReader pipedReader = new PipedReader();
    PipedWriter pipedWriter = new PipedWriter();
    pipedWriter.connect(pipedReader);
    Thread thread = new Thread(new PrintRunnable(pipedReader), "print-thread");
    thread.start();
    try {
      Scanner sc = new Scanner(System.in);
      while (true) {
        String s = sc.nextLine();
        pipedWriter.write(s);
        pipedWriter.flush();
      }
    } finally {
      System.out.println("main-thread end");
      pipedWriter.close();
    }
  }

  static class PrintRunnable implements Runnable {
    PipedReader pipedReader;

    public PrintRunnable(PipedReader pipedReader) {
      this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " start");
      int total = 0;

      try {
        while (true) {
          char[] buf = new char[1024];
          int length;
          StringBuilder sb = new StringBuilder();
          do {
            length = pipedReader.read(buf);
            sb = new StringBuilder();
            total += length;
            sb.append(buf);
            if (sb.indexOf(".") > 0) {
              break;
            }
          } while (pipedReader.ready());

          if (!"".equals(sb.toString())) {
            System.out.println("print-thread msg:" + sb);
          }
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      } finally {
        try {
          System.out.println("receive msg total length:" + total);
          System.out.println("print-thread end");
          pipedReader.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}

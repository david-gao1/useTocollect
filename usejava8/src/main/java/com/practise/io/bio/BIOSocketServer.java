package com.practise.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class BIOSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接。。。");
            //监听来自客户端的连接
            Socket clientsocket = serverSocket.accept();
            System.out.println("有客户连接了");

            //可以使用多线程或线程池来解决并发问题，但是依然存在堵塞问题。
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(clientsocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。。");
        //接受客户端的数据，为阻塞方法，没有数据可读时，就等待，形成阻塞。
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read 完毕");
        if (read != -1) {
            System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
        }
    }
}

package com.practise.io.nio;

import com.sun.codemodel.internal.util.UnicodeEscapeWriter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 一个线程就可以处理多个连接
 * <p>
 * redis单线程处理高并发的思路和这个类似
 *
 * @Author lianggao
 * @Date 2021/12/17 上午10:18
 * @Version 1.0
 */
public class NIOSocketServer {

    static List<SocketChannel> channelList = new ArrayList();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(true);//设置为非堵塞。
        System.out.println("服务启动成功");

        while (true) {
            /**
             * 与客户端建立连接：
             * 非阻塞式：如果没有客户端，accept方法不会堵塞会继续向前走
             * 阻塞式：如果没有客户端，accept方法会阻塞，等待客户端建立
             */
            SocketChannel socketChannel = serverSocket.accept();

            if (socketChannel != null) {
                System.out.println("连接成功");
                //读数据的时候也不堵塞
                socketChannel.configureBlocking(false);
                //保存客户端连接在list中
                channelList.add(socketChannel);
            }

            //遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if (len > 0) {
                    System.out.println("接收到消息： " + new String(byteBuffer.array()));
                } else if (len == -1) {
                    iterator.remove();
                    System.out.println("客户端断开连接");//？？？并没有断开
                }
            }
        }
    }


}

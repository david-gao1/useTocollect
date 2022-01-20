package com.practise.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description nio与epoll模型
 * @Author lianggao
 * @Date 2021/12/17 下午7:29
 * @Version 1.0
 */
public class NIOSelectorServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);


        /**
         *  epoll模型：优化读写。
         *  假如有10万个连接，每次遍历查找有读写的连接时，不需要遍历所有连接，
         *  通过selector实例可以监听到有读写操作的连接。
         *
         *
         */
        //打开selector处理channel，即（通过linux底层实现）epoll实例模型，
        Selector selector = Selector.open();
        //把serversocketchannel注册到selector上，并且selector对客户端accept（建立连接）连接操作感兴趣
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            //阻塞等待直到事件发生
            selector.select();

            //获取selector中注册的全部事件的selectionKey实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //用serverSocketChannel1建立连接？？？？
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();  //会调用到linux系统函数accept,来接收客户端连接
                    socketChannel.configureBlocking(false);
                    //这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                    SelectionKey selectionKey1 = socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");

                    //用socketChannel去消费数据？？？
                } else if (key.isReadable()) { //如果是OP_READ事件，则进行读取和打印
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int read = socketChannel.read(byteBuffer);
                    if (read > 0) {
                        System.out.println("接收到消息：" + new String(byteBuffer.array()));
                    } else if (read == -1) {
                        socketChannel.close();
                        System.out.println("客户端断开连接");
                    }
                }
                //从事件集合里删除本次处理的key，防止下次select重复处理
                iterator.remove();
            }
        }
    }
}

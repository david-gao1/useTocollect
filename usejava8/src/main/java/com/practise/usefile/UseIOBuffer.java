package com.practise.usefile;

import java.io.*;

public class UseIOBuffer {
    public static void main(String[] args) throws IOException {
        BufferWrite();
        return;
    }

    private static void BufferWrite() throws IOException {
        //in
        final File file = new File("C:\\Users\\v_liangggao\\Desktop\\stu.txt");
        final FileInputStream fis = new FileInputStream(file);
        final BufferedInputStream bis = new BufferedInputStream(fis);
        //out
        final File file1 = new File("C:\\Users\\v_liangggao\\Desktop\\stu1.txt");
        final FileOutputStream fos = new FileOutputStream(file1);
        final BufferedOutputStream bos = new BufferedOutputStream(fos);

        //write
        int tmp;
        while ((tmp = bis.read()) != -1) {
            bos.write(tmp);//写到一定长度会自动将缓冲区的内容写到文件中
        }
        bos.flush();
        //流关闭
    }

}

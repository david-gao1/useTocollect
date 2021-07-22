package com.practise.java8.usefile;

import java.io.*;

public class UseIO {
    public static void main(String[] args) {
        final Stu stu = new Stu("xiaoxiao", 12, "baseball");
        final File file = new File("C:\\Users\\v_liangggao\\Desktop\\stu.txt");
        //序列化
        serializeObject(stu, file);
        //反序列化
        getObject(file);
        //关闭流
    }

    private static void serializeObject(Stu stu, File file) {
        try (final FileOutputStream fos = new FileOutputStream(file);
             final ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(stu);
            System.out.println("序列化成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getObject(File file) {
        try (final FileInputStream fs = new FileInputStream(file);
             final ObjectInputStream ois = new ObjectInputStream(fs)) {
            final Stu stu1 = (Stu) ois.readObject();
            System.out.println(stu1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

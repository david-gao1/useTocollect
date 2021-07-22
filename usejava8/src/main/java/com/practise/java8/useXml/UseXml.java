package com.practise.java8.useXml;

import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class UseXml {



    public static void main(String[] args) throws Exception {
        //创建doc
        Document doc = createDocument();
        //写文件到本地
        writeXmlToLocal(doc);

        //读取文件到doc
        getDocFile();

        //转为字符串
        final String xmlFileString = getXmlFileString(doc);
        final File file = new File("C:\\Users\\v_liangggao\\Desktop\\1.txt");
        System.out.println(file.length());


    }

    private static void getDocFile() throws Exception {
        final File file = new File("C:\\Users\\v_liangggao\\Desktop\\1.txt");
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document getDocumentFromLocal = builder.parse(file);
        final String xmlFileString1 = getXmlFileLength(getDocumentFromLocal);
        System.out.println(xmlFileString1);
    }

    private static Document createDocument() throws ParserConfigurationException {
        // 初始化一个XML解析工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        // 创建一个DocumentBuilder实例
        DocumentBuilder builder = factory.newDocumentBuilder();

        // 构建一个Document实例
        Document doc = builder.newDocument();
        //doc.setXmlStandalone(true);
        // standalone用来表示该文件是否呼叫其它外部的文件。若值是 ”yes” 表示没有呼叫外部文件

        // 创建一个根节点
        // 说明: doc.createElement("元素名")、element.setAttribute("属性名","属性值")、element.setTextContent("标签间内容")
        Element element = doc.createElement("root");
        element.setAttribute("attr", "root");


        // 创建根节点第一个子节点
        Element elementChildOne = doc.createElement("person");
        elementChildOne.setAttribute("attr", "personOne");
        element.appendChild(elementChildOne);

        // 第一个子节点的第一个子节点
        Element childOneOne = doc.createElement("people");
        childOneOne.setAttribute("attr", "peopleOne");
        childOneOne.setTextContent("attr peopleOne");
        elementChildOne.appendChild(childOneOne);

        // 第一个子节点的第二个子节点
        Element childOneTwo = doc.createElement("people");
        childOneTwo.setAttribute("attr", "peopleTwo");
        childOneTwo.setTextContent("attr peopleTwo");
        elementChildOne.appendChild(childOneTwo);

        // 创建根节点第二个子节点
        Element elementChildTwo = doc.createElement("person");
        elementChildTwo.setAttribute("attr", "personTwo");
        element.appendChild(elementChildTwo);

        // 第二个子节点的第一个子节点
        Element childTwoOne = doc.createElement("people");
        childTwoOne.setAttribute("attr", "peopleOne");
        childTwoOne.setTextContent("attr peopleOne");
        elementChildTwo.appendChild(childTwoOne);

        // 第二个子节点的第二个子节点
        Element childTwoTwo = doc.createElement("people");
        childTwoTwo.setAttribute("attr", "peopleTwo");
        childTwoTwo.setTextContent("attr peopleTwo");
        elementChildTwo.appendChild(childTwoTwo);
        // 添加根节点
        doc.appendChild(element);
        return doc;
    }

    private static void writeXmlToLocal(Document doc) throws TransformerException {
        // 把构造的XML结构，写入到具体的文件中
        TransformerFactory formerFactory = TransformerFactory.newInstance();
        Transformer transformer = formerFactory.newTransformer();
        // 换行
        transformer.setOutputProperty(OutputKeys.INDENT, "YES");
        //设置缩进
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        // 文档字符编码
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        // 可随意指定文件的后缀,效果一样,但xml比较好解析,比如: E:\\person.txt等
        transformer.transform(new DOMSource(doc), new StreamResult("C:\\Users\\v_liangggao\\Desktop\\1.txt"));
    }

    private static String getXmlFileLength(Document doc) throws Exception {
        TransformerFactory formerFactory = TransformerFactory.newInstance();
        Transformer transformer = formerFactory.newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "YES");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        transformer.transform(new DOMSource(doc), new StreamResult(bos));
        String docString = bos.toString();
        return docString;
    }


    private static String getXmlFileString(Document doc) {
        DOMReader domReader = new DOMReader();
        org.dom4j.Document document = domReader.read(doc);
        final String docString = document.asXML();
        return docString;
    }

}

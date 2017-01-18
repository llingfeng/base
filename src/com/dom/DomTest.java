package com.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by admin on 2016/12/4.
 */
public class DomTest {

    public static void main(String[] args) throws Exception {
//        parserXml();
        createXml();
    }

    /**
     * 解析xml文件
     *
     * @throws Exception
     */
    public static void parserXml() throws Exception {
        //创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder对象
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        //通过documentBuilder的parer()方法加载book.xml文件到当前路径下
        Document document = documentBuilder.parse("src/book.xml");
        //获取所有book节点集合
        NodeList bookList = document.getElementsByTagName("book");
        System.out.println("一共" + bookList.getLength() + "本书");
        //遍历每一个book元素
        for (int i = 0; i < bookList.getLength(); i++) {
            //通过item(i)方法获得book节点，nodeList的索引值从0开始
            Node book = bookList.item(i);
            //获取book节点的所有属性集合
            NamedNodeMap bookAttributes = book.getAttributes();
            System.out.println("第" + (i + 1) + "本书共有" + bookAttributes.getLength() + "个属性");
            for (int j = 0; j < bookAttributes.getLength(); j++) {
                //通过item(j)方法获取book节点的某一个属性
                Node item = bookAttributes.item(j);
                //获取属性名
                String nodeName = item.getNodeName();
                //获取属性值
                String nodeValue = item.getNodeValue();
                System.out.println("属性名" + nodeName + "\t属性值" + nodeValue);
            }
//            //前提：已经知道book节点有且仅有一个id属性
//            Element books = (Element) bookList.item(i);
//            String id = books.getAttribute("id");
//            System.out.println("id的属性值为："+id);
            NodeList childNodes = book.getChildNodes();
            System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");
            for (int k = 0; k < childNodes.getLength(); k++) {
                Node item = childNodes.item(k);
                //区分text类型的node和element类型的node
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    //获取element类型节点的节点名
                    System.out.println(item.getNodeName());
                    //获取element类型节点的节点值
                    System.out.println(item.getFirstChild().getNodeValue());
                    System.out.println(item.getTextContent());
                }
            }
        }
    }

    /**
     * 创建xml文件
     */
    public static void createXml() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        document.setXmlStandalone(true);//dtd,schema格式相关，true表示不需要相关的格式
        //创建节点
        Element bookstore = document.createElement("bookstore");
        Element book = document.createElement("book");
        book.setAttribute("id","1");
        Element name = document.createElement("name");
        name.setTextContent("冰与火之歌");
        Element author = document.createElement("author");
        author.setTextContent("乔治马丁");
        Element year = document.createElement("year");
        year.setTextContent("2012");
        Element price = document.createElement("price");
        price.setTextContent("23.00");
        //组装节点
        book.appendChild(name);
        book.appendChild(author);
        book.appendChild(year);
        book.appendChild(price);
        bookstore.appendChild(book);
        document.appendChild(bookstore);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");//设置换行
        transformer.transform(new DOMSource(document),new StreamResult(new File("src//book2.xml")));//转化
    }
}

package com.dom;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2016/12/5.
 */
public class Dom4jTest {

    public static void main(String args[]) throws Exception{
        createXml();
    }

    /**
     * 解析xml文件
     * @throws Exception
     */
    public static void parserXml() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/book.xml"));
        Element rootElement = document.getRootElement();
        Iterator it = rootElement.elementIterator();
        while (it.hasNext()){
            System.out.println("开始遍历某一本书");
            Element element = (Element) it.next();
            List<Attribute> attributes = element.attributes();
            for (Attribute attribute : attributes) {
                System.out.println("属性："+attribute.getName()+"\t值："+attribute.getStringValue());
            }
            Iterator itt = element.elementIterator();
            while (itt.hasNext()){
                Element bookChild = (Element) itt.next();
                System.out.println("属性："+bookChild.getName()+"\t值："+bookChild.getStringValue());
            }
            System.out.println("结束遍历某一本书");
        }
    }

    /**
     * 创建xml文件
     * @throws Exception
     */
    public static void createXml() throws Exception{
        //创建document，代表整个xml文档
        Document document = DocumentHelper.createDocument();
        //创建根节点
        Element element = document.addElement("rss");
        element.addAttribute("version","2.0");
        Element channel = element.addElement("channel");
        Element title = channel.addElement("title");
        title.setText("国内最新新闻");
        OutputFormat format = OutputFormat.createPrettyPrint();
        File file = new File("src/book4.xml");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
        writer.setEscapeText(false);//转义字符的处理方法
        writer.write(document);
        writer.close();
    }
}

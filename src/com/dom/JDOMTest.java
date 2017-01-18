package com.dom;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by admin on 2016/12/5.
 */
public class JDOMTest {

    public static void main(String[] args) throws Exception {
        createXml();
        parserXml();
    }

    /**
     * 解析xml文件
     * @throws Exception
     */
    public static void parserXml() throws Exception{
        //1.创建一个SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        //2.创建一个输入流，将xml文件加载到输入流
        FileInputStream in = new FileInputStream("src/book5.xml");
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        //3.通过.build()方法将输入流加载到saxBuilder中
        Document document = saxBuilder.build(isr);
        //4.获得xml文件的根节点
        Element rootElement = document.getRootElement();
        //5.获得根节点子节点
        List<Element> elementList = rootElement.getChildren();
        for (Element book : elementList) {
            /*String val = book.getAttributeValue("id");
            System.out.println(val);*/
            System.out.println("开始解析第" + (elementList.indexOf(book) + 1) + "本书");
            List<Attribute> attributeList = book.getAttributes();
            for (Attribute attribute : attributeList) {
                System.out.println("属性：" + attribute.getName() + "\t值：" + attribute.getValue());
            }
            List<Element> childrenList = book.getChildren();
            for (Element element : childrenList) {
                System.out.println("属性:"+element.getName()+"\t值："+element.getValue());
            }
            System.out.println("结束解析第" + (elementList.indexOf(book) + 1) + "本书");
        }
    }

    /**
     * 创建xml文件
     * @throws Exception
     */
    public static void createXml() throws Exception{
        //生产根节点
        Element rss = new Element("rss");
        //添加节点属性
        rss.setAttribute("version","2.0");
        //生产一个document对象
        Document document = new Document(rss);
        Element channel = new Element("channel");
        Element title = new Element("title");
        CDATA content = new CDATA("<!上海移动互联网产业促进中心正式揭牌>");//解析转义字符
        title.addContent(content);
        channel.addContent(title);
        rss.addContent(channel);
        //创建XMLOutputter对象
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        //利用XMLOutputter对象将document转化为xml文件
        xmlOutputter.output(document,new FileOutputStream(new File("src//book5.xml")));
    }


}

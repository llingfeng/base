package com.dom;

import com.dom.entity.Book;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by admin on 2016/12/5.
 */
public class SaxTest {

    public static void main(String args[]) throws Exception {
        createXml();
    }

    /**
     * 解析xml文件
     * @return
     * @throws Exception
     */
    public static List<Book> parserXml() throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        DefaultHandlerParse handlerParse = new DefaultHandlerParse();
        saxParser.parse("src/book.xml",handlerParse);
        List<Book> bookList = handlerParse.getBookList();
        for (Book book : bookList) {
            System.out.println(book);
        }
        return bookList;
    }

    /**
     * 创建xml文件
     * @throws Exception
     */
    public static void createXml() throws Exception{
        List<Book> bookList = parserXml();
        //创建saxTransformerFactory对象
        SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        //通过saxTransformerFactory对象创建transformerHandler
        TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
        //通过transformerHandler对象创建transformer
        Transformer transformer = transformerHandler.getTransformer();
        //设置xml文件的编码
        transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
        //设置换行
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        File file = new File("src/book3.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        //创建result并使之与transformerHandler相关
        Result result = new StreamResult(new FileOutputStream(file));
        transformerHandler.setResult(result);
        //利用transformerHandler对象进行xml文件内容的编写
        //打开document
        transformerHandler.startDocument();
        AttributesImpl attrs = new AttributesImpl();
        transformerHandler.startElement("","","bookstore",attrs);
        attrs.clear();
        if(bookList != null && bookList.size()>0){
            for (Book book : bookList) {
                attrs.addAttribute("","", "id","", String.valueOf(book.getId()));
                transformerHandler.startElement("","","book",attrs);
                if(book.getName() != null && !"".equals(book.getName().trim())){
                    attrs.clear();
                    transformerHandler.startElement("","","name",attrs);
                    transformerHandler.characters(book.getName().toCharArray(),0,book.getName().length());
                    transformerHandler.endElement("","","name");
                }
                if(book.getAuthor() != null && !"".equals(book.getAuthor().trim())){
                    attrs.clear();
                    transformerHandler.startElement("","","author",attrs);
                    transformerHandler.characters(book.getAuthor().toCharArray(),0,book.getAuthor().length());
                    transformerHandler.endElement("","","author");
                }
                if(book.getYear() != null){
                    attrs.clear();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
                    String year = sdf.format(book.getYear());
                    transformerHandler.startElement("","","year",attrs);
                    transformerHandler.characters(year.toCharArray(),0,year.length());
                    transformerHandler.endElement("","","year");
                }
                if(book.getPrice() != null && !"".equals(book.getPrice().trim())){
                    attrs.clear();
                    transformerHandler.startElement("","","price",attrs);
                    transformerHandler.characters(book.getPrice().toCharArray(),0,book.getPrice().length());
                    transformerHandler.endElement("","","price");
                }
                transformerHandler.endElement("","","book");
            }
        }
        transformerHandler.endElement("","","bookstore");
        //关闭document
        transformerHandler.endDocument();
    }
}

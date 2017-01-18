package com.dom;

import com.dom.entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/12/5.
 */
public class DefaultHandlerParse extends DefaultHandler {
    private String value = null;
    private Book book = null;
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * 用来标识解析开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素
        if("book".equals(qName)){
            book = new Book();//初始化一本书
            /*String value = attributes.getValue("id");
            System.out.println("id的属性值"+value);*/
            System.out.println("开始遍历某一本书的属性");
            for(int i=0;i<attributes.getLength();i++){
                String attName = attributes.getQName(i);
                String value = attributes.getValue(i);
                System.out.println("第"+(i+1)+"元素的属性："+attName+"\t值："+value);
                if("id".equals(attName)){
                    book.setId(Integer.parseInt(value));
                }
            }
        }else if(!"bookstore".equals(qName)){
            System.out.print(qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("book".equals(qName)){
            System.out.println("结束某一本书的遍历");
            bookList.add(book);
        }else if("name".equals(qName)){
            book.setName(value);
        }else if("author".equals(qName)){
            book.setAuthor(value);
        }else if("year".equals(qName)){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM");
            try {
                Date year = dateFormat.parse(value);
                book.setYear(year);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if("price".equals(qName)){
            book.setPrice(value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String val =  new String(ch,start,length);
        if(!"".equals(val.trim())){
            System.out.println(val);
            value = val;
        }
    }
}

package com.app;import java.io.UnsupportedEncodingException;

// 一、编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
// 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"，6，
// 应该输出为"我ABC"而不是"我ABC+汉的半个"。
public class StrSubstring {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "我ABC汉DEF";
        String newStr = subStr(str, 6, "gbk");
        System.out.println(newStr);
    }

    /**
     * 截取字符串长度
     * @param str 指定字符串
     * @param byteLength 指定字节长度
     * @param encoding 指定字符集
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String subStr(String str, int byteLength, String encoding) throws UnsupportedEncodingException {
        if (str == null || "".equals(str)) {
            return "";
        } else {
            String tempStr = str.substring(0, byteLength > str.length() ? str.length() : byteLength);
            int tempByteLength = tempStr.getBytes(encoding).length;//临时字符串字节长度
            int tempNum = byteLength;
            //如果截取的临时字符串字节长度大于指定字节长度则表示字符串中含有中文，如果相等表示全部为英文
            while (tempByteLength > byteLength) {
                //由于字符串中含有中文字符，以subString(0,byteLength)方法获取字符串的长度肯定大于按byteLength字节数获取的长度
                //可以通过逐级递减获取指定字节长度
                int tempLength = --tempNum;
                tempStr = str.substring(0, tempLength > str.length() ? str.length() : tempLength);
                tempByteLength = tempStr.getBytes(encoding).length;
            }
            return tempStr;
        }
    }
}

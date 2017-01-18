package com.io;

import java.io.*;

/**
 * Created by admin on 2016/12/3.
 */
public class IOUtil {

    /**
     * 读取指定文件的内容，按照16进制打印在控制台
     * 每十个换行
     * 单字节读取不是较大的文件
     *
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHexByteByte(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buff = new byte[3];
        int b, k = 1;
        //in.read(buff,0,buff.length）   buff:存放数据的目标数组，0：目标数组从0开始存入，buff.length:in里要读入到目标数组的长度。
        //返回值是buff里目标数组读入的长度
        while ((b = in.read(buff, 0, buff.length)) != -1) {
            for (int i = 0; i < b; i++) {
                System.out.print(Integer.toHexString(buff[i] & 0xff) + " ");
                if (k++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 读取文件
     *
     * @param srcFile
     * @param destFile
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buff = new byte[1024];
        int b;
        while ((b = in.read(buff, 0, buff.length)) != -1) {
            out.write(buff, 0, b);
            out.flush();
        }
        out.close();
        in.close();
    }

    /**
     * 带缓存读取文件
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
            bos.flush();
        }
        bos.close();
        bis.close();
    }

    /**
     * 单字节读取文件
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(destFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        out.close();
        in.close();
    }

    /**
     * 字符读取文件
     *
     * @param srcFile
     * @param desFile
     */
    public static void copyByChar(File srcFile, File desFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(desFile), "utf-8");
        char[] buff = new char[4 * 1024];
//        int c;
//        while ((c=isr.read()) != -1){
//            System.out.print((char) c);
//        }
        int b;
        while ((b = isr.read(buff, 0, buff.length)) != -1) {
            osw.write(buff, 0, b);
            osw.flush();
        }
        osw.close();
        isr.close();
    }

    /**
     * 字符读取文件扩展
     * 注：不能处理编码问题
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByChar2(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(destFile);
        char[] buff = new char[4 * 1024];
        int b;
        while ((b = fr.read(buff, 0, buff.length)) != -1) {
            fw.write(buff, 0, b);
            fw.flush();
        }
        fw.close();
        fr.close();
    }

    /**
     * 读取一行
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByString(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException(srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
//        BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
        PrintWriter pw = new PrintWriter(destFile);
        String line;
        while ((line = br.readLine()) != null) {//一次读取一行，不能识别换行
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
            pw.println(line);
            pw.flush();
        }
//        bw.close();
        pw.close();
        br.close();
    }
}

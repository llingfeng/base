package com.qrcode.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 创建二维码
 * Created by admin on 2016/12/17.
 */
public class CreateQRCode {

    public static void main(String[] args) {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//纠错等级
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表A-Z,B代表其他字符
        qrcode.setQrcodeVersion(7);//版本号

        String QRData = "这是中文";
        int width = 67 + 12 * (7 - 1);//公式版本号减1，避免二维码集中在左上角
        int height = 67 + 12 * (7 - 1);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.setBackground(Color.white);
        g.setColor(Color.black);
        g.clearRect(0, 0, width, height);

        int off = 2;//偏移量，避免格式出现错误
        try {
            byte[] bytes = QRData.getBytes("utf-8");
            if (bytes.length > 0 && bytes.length < 120) {
                boolean[][] s = qrcode.calQrcode(bytes);
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < s.length; j++) {
                        if (s[j][i]) {
                            g.fillRect(j * 3 + off, i * 3 + off, 3, 3);
                        }
                    }
                }
            }
            g.dispose();
            bufferedImage.flush();
            ImageIO.write(bufferedImage, "png", new File("e://qr//qr.png"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

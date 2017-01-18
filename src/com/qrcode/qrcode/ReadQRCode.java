package com.qrcode.qrcode;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 解析二维码
 * Created by admin on 2016/12/17.
 */
public class ReadQRCode {

    public static void main(String[] args){
        File file = new File("e://qr//qr.png");
        try {
            BufferedImage read = ImageIO.read(file);
            QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();

            String result = new String(qrCodeDecoder.decode(new MyQRCodeImage(read)), "utf-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

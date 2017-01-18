package com.qrcode.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 解析二维码
 * Created by admin on 2016/12/17.
 */
public class ReadQRCode {

    public static void main(String[] args){
        MultiFormatReader formatReader = new MultiFormatReader();

        File file = new File("e://qr//下载.png");
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("解析结果："+result.toString());
            System.out.println("二维码格式："+result.getBarcodeFormat());
            System.out.println("二维码文本内容："+result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.qrcode.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * Created by admin on 2016/12/17.
 */
public class MyQRCodeImage implements QRCodeImage {
    private BufferedImage bufferedImage;

    public MyQRCodeImage(BufferedImage bufferedImage){
        this.bufferedImage = bufferedImage;
    }
    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public int getPixel(int arg1, int arg2) {
        return bufferedImage.getRGB(arg1,arg2);
    }
}

package com.hosuke.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Author Hosuke
 * 验证码相关
 */
public class VerificationCode {
    private BufferedImage buffImg = null;

    /**
     * 生成随机字符串
     *
     * @param stringSize 随即字符串个数
     */
    public String RandomString(Integer stringSize) {
        char[] string = "01234ABCDEFGHIJKLMNOPQRSTUVWXYZ56789".toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < stringSize; i++) {
            stringBuffer.append(string[new Random().nextInt(string.length)]);
        }
        return stringBuffer.toString();
    }


    /**
     * 生成一张验证码图片
     *
     * @param width    宽度
     * @param height   高度
     * @param str      验证码字符串
     * @param lineSize 验证码干扰线个数
     */
    public void CreateImg(Integer width, Integer height, String str, Integer lineSize) {

        Random random = new Random();
        int x = 0, fontHeight = 0, codeY = 0;
        int r = 0, g = 0, b = 0;//rgb

        x = width / (str.length() + 1);//每个字符的宽度
        fontHeight = height - 2;//字体的高度
        codeY = height - 4;

        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = buffImg.createGraphics();
        Font font = new Font("Arial",Font.PLAIN + Font.BOLD, fontHeight);
        graphics.setFont(font);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        //随机生成 干扰线段
        for (int i = 0; i < lineSize; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);
            graphics.setColor(new Color(r, g, b));
            graphics.drawLine(xs, ys, xe, ye);
        }
        //随机生成 字体颜色
        for (int i = 0; i < str.toString().length(); i++) {
            String string = Character.toString(str.charAt(i));
            r = random.nextInt(255);
            g = random.nextInt(255);
            b = random.nextInt(255);

            graphics.setColor(new Color(r,g,b));
            graphics.drawString(string,i * x,codeY);
        }
    }
    /**
     * 输出图像到OutputStream
     * 通过HttpServletRespone
     * */
    public void write(OutputStream os) throws IOException{
        ImageIO.write(buffImg,"png",os);
        os.close();
    }
}

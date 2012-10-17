package org.gajaba.demo.converter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlackAndWhiteConverter implements ImageConverter {
    @Override
    public BufferedImage convert(BufferedImage image) {
        BufferedImage result = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = result.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return result;
    }
}

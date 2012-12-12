package org.gajaba.demo.converter;


import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BlurConverter implements ImageConverter {
    @Override
    public BufferedImage convert(BufferedImage img) {

        float[] floats = new float[81];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = 1f/81f;
        }

        Kernel kernel = new Kernel(9, 9,floats);
        BufferedImageOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage result = img;
        for (int i = 0; i < 100; i++) {
             result = op.filter(result, null);
        }
        return result;
    }

}

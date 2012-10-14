
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yasitha
 */
public class ImageConverter {
   

    public static BufferedImage toBinaryImage(final BufferedImage img) {
        
       int width = img.getWidth(); // Dimensions of the image
       int height = img.getHeight();
        BufferedImage bimg = new BufferedImage((int)width, (int)height,
                                                                                  BufferedImage.TYPE_BYTE_GRAY);
                             Graphics2D gg = bimg.createGraphics();
                             gg.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
                             return bimg;
    }
    
    public static void main(String[] args) throws IOException {
        
        Image image = ImageIO.read(new File("/home/yasitha/gajaba.jpg"));
        BufferedImage buffered = (BufferedImage) image;
        BufferedImage bi = ImageConverter.toBinaryImage(buffered);
        System.out.println(bi);
        ImageIO.write(bi, "JPEG", new File("/home/yasitha/blckwhite.jpg"));
    }
}

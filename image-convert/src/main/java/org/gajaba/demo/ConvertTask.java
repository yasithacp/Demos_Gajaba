package org.gajaba.demo;

import net.coobird.thumbnailator.Thumbnails;
import org.gajaba.demo.converter.BlackAndWhiteConverter;
import org.gajaba.demo.converter.ImageConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConvertTask implements Runnable {

    private static final Map<String, ImageConverter> converters = new HashMap<String, ImageConverter>();

    public static final String FORMAT_NAME_JPEG = "JPEG";
    public static final String FILE_EXT = "jpg";
    public static final String THUMB_BEFORE_PREFIX = "TH_";
    public static final String THUMB_AFTER_PREFIX = "TH_CO_";
    public static final String AFTER_PREFIX = "CO_";

    static {
        converters.put("bw", new BlackAndWhiteConverter());
    }

    private String action;
    private File destinationDir;
    private String name;

    public ConvertTask(File destinationDir, String name, String action) {
        this.destinationDir = destinationDir;
        this.name = name;
        this.action = action;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);

            File file = new File(destinationDir, name);
            Image image = ImageIO.read(file);
            BufferedImage buffered = (BufferedImage) image;
            Thumbnails.of(buffered)
                    .size(40, 40)
                    .outputFormat("jpg")
                    .toFile(new File(destinationDir, THUMB_BEFORE_PREFIX + name));

            ContextListener.addProcessing(file);

            ImageConverter converter = converters.get(action);
            if (converter != null) {
                BufferedImage converted = converter.convert(buffered);
                ImageIO.write(converted, FORMAT_NAME_JPEG, new File(destinationDir, AFTER_PREFIX + name));
                Thumbnails.of(converted)
                        .size(40, 40)
                        .outputFormat(FILE_EXT)
                        .toFile(new File(destinationDir, THUMB_AFTER_PREFIX + name));
            }

            ContextListener.removeProcessing(file);
            ContextListener.addDone(file);
        } catch (Exception e) {
        }
    }
}

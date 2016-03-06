package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class ImageUtil {

    private static ImageUtil instance;

    public static ImageUtil getInstance(){

        if (instance == null)
            instance = new ImageUtil();

        return instance;

    }

    public BufferedImage loadImage(String path){

        try{

            return ImageIO.read(getClass().getResource(path));

        } catch (Exception ignored){}

        return null;

    }

}

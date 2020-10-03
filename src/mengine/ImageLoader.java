package mengine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Milan Savickij
 * @date 7th September 2020
 * 
 * <p> Last updated on 3rd October 2020
 */
public class ImageLoader {
    /**
     * <p> Loads image from local package
     * @param path Path of the image in local package <strong>Usage:</strong> projectPackage/packageOfTheImage/image.imageType
     * @return The loaded image
     */
    @SuppressWarnings("unused")
	public BufferedImage loadImage(String path)
    {
        URL url = ImageLoader.class.getResource(path);
        ImageIcon ii = new ImageIcon(url);
        BufferedImage image = new BufferedImage(
        ii.getIconWidth(), ii.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.createGraphics();
        ii.paintIcon(null, g, 0, 0);
        g.dispose();
        
        if(image != null){
        return image;
        }
		return null;
    }
}

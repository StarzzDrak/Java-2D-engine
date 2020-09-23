package mengine;

import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.net.URL;
//import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Milan Savickij
 *
 * <p>
 * This class is used to display scenes on screen
 *
 * @since 27th August 2020
 * <p>
 * Last updated on 7th September 2020
 * @see Scene
 */
public class Display extends JPanel {

    Scene scene;

    public Display() {
    }

    public void loadScene(Scene _scene) {
        this.scene = _scene;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 10, 200);

        if (scene.toRender.size() > 0) {
            for (int i = 0; i < scene.toRender.size(); i++) {
                RenderObject obj = scene.toRender.get(i);
                Transform t = (Transform) obj.getComponent(new Transform());
                switch (scene.toRender.get(i).getObjectType()) {
                    case SPRITE:
                        //g2d.drawImage(obj.image, t.position.x, t.position.y, t.size.x, t.size.y, this);
                        g2d.drawImage(obj.image, t.position.x, t.position.y, this);
                        break;
                    case TEXT:
                        g2d.drawString(obj.description, t.position.x, t.position.y);
                        break;

                }
            }
        }
    }
}

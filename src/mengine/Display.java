package mengine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;
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
public class Display extends JPanel implements LoopEvent{

    Scene scene;
    public int width = 0;
    public int height = 0;

    public Display() {
    }

    public void loadScene(Scene _scene) {
        scene = _scene;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        if (scene.toRender.size() > 0) {
            for (int i = 0; i < scene.toRender.size(); i++) {
                RenderObject obj = scene.toRender.get(i);
                Transform t = (Transform) obj.getComponent(new Transform());
                switch (scene.toRender.get(i).getObjectType()) {
                    case SPRITE:
                        if(t.size.x == 0 || t.size.y == 0) 
                        {
                        	g2d.drawImage(obj.image, obj.transform.position.x, obj.transform.position.y, this);
                        } else 
                        {
                        	g2d.drawImage(obj.image, obj.transform.position.x, obj.transform.position.y, obj.transform.size.x, obj.transform.size.y, this);
                        }
                        break;
                    case TEXT:
                            g2d.drawString(obj.description, obj.transform.position.x, obj.transform.position.y);
                        break;

                }
            }
        }
    }

	@Override
	public void update() {
		repaint();
		
	}
}

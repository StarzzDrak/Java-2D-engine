package mengine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 * Last updated on 3rd October 2020
 * @see Scene
 */
public class Display extends JPanel{
	
	Scene scene;
    public int width = 0;
    public int height = 0;


    public Display() {
    }
    /**
     * <p> Loads scene into display's memory and renders it on screen 
     * @param scene Scene to be loaded
     */
    public void loadScene(Scene scene) {
        this.scene = scene;
    }
    
    public void render() 
    {
    	repaint();
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
                
                if(t.position.x > width || t.position.x + t.size.x < 0 || t.position.y + t.size.y < 0 || t.position.y > height) 
                {
                	//System.out.println("Not rendering this");
                	return;
                }
                
                switch (scene.toRender.get(i).getObjectType()) {
                    case SPRITE:
                    		if(t.size.x == 0 || t.size.y == 0) 
                    		{
                    			g2d.drawImage(obj.image, t.position.x, t.position.y, this);
                    		} else 
                    		{
                    			g2d.drawImage(obj.image, t.position.x, t.position.y, t.size.x, t.size.y, this);
                    		}
                        break;
                    case TEXT:
                            g2d.drawString(obj.description, t.position.x, t.position.y);
                        break;
				default:
					break;

                }
            }
        }
    }
    
}

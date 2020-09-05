package mengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 * 
 * @author Milan Savickij
 * 
 * <p> This class is used to display scenes on screen
 * 
 * @since 27th August 2020 
 * <p> Last updated on 5th September 2020
 * @see Scene
 */
public class Display extends JPanel{
    
    Scene scene;
    
    public Display()
    {
        repaint();
    }
    
    public void loadScene(Scene _scene)
    {
        this.scene = _scene;
    }
    
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 1, 200);
        
        System.out.println(scene.toRender.size());
        if(scene.toRender.size() > 0){
        for(int i = 0; i < scene.toRender.size(); i++)
        {
            switch(scene.toRender.get(i).getObjectType())
            {
                case SPRITE:
                    break;
                case TEXT:
                    //Transform t = (Transform) obj.getComponent(Transform.class);
                    System.out.println(scene.toRender.get(i).description);
                    //g2d.drawChars(scene.toRender.get(i).description.toCharArray(), 10, 10, 100, 20);
                    g2d.drawString("hey", 0, 0);
                    break;

            }
        }
        }
    }
}

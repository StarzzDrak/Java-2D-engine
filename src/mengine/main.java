package mengine;


import mengine.Physics.BoxCollider;
import mengine.Physics.GravityComponent;
import mengine.Physics.PhysicsManager;
import mengine.Physics.Rigidbody;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class main {
    
    public static void main(String[] args) {
        
        Display display;
        
        //Initializing mengine
        Mengine.initialize();
        display = Mengine.getDisplay();
        ImageLoader loader = new ImageLoader();
        SceneManager sceneManager = Mengine.getSceneManager();
        
        //Setting up new scene
        Scene scene = SceneManager.createNewScene("main");
        
        //Creating new object in the scene
        BufferedImage img = loader.loadImage("/Images/example.png");
        Transform t = new Transform(100,100,0,250,250);
        RenderObject obj = new RenderObject(ObjectType.SPRITE, "Image", "Text",img,t);
        obj.addComponent(t);
        //obj.addComponent(new GravityComponent(10.0));
        obj.addComponent(new Rigidbody(true));
        PhysicsManager.setGravityConstant(-0.1f);
        
        t = new Transform(500, 0, 0, 10, 500);
        RenderObject obj2 = new RenderObject(ObjectType.COLOR, "Platform", "Collision test", Color.RED);
        obj2.addComponent(t);
        obj2.addComponent(new BoxCollider(true));

        scene.addObject(obj);
        scene.addObject(obj2);
        
        ChangeSize cs = new ChangeSize();
        cs.start();
        Mengine.addLoopEventListener(cs);
        
        display.loadScene(scene);
        
        JFrame frame = new JFrame("test");
        frame.setSize(640, 480);
        display.width = 640;
        display.height = 480;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.setResizable(false);
        frame.setVisible(true);
        
        Mengine.startEngineLoop(60.0);
    }
    
}

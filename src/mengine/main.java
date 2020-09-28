package mengine;


import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class main {
    
    public static void main(String[] args) {
        
        Display display;
        
        //Initializing mengine
        Mengine mengine = new Mengine();
        mengine.initialize();
        display = mengine.getDisplay();
        ImageLoader loader = new ImageLoader();
        
        //Setting up new scene
        SceneManager sceneManager = new SceneManager();
        Scene scene = sceneManager.createNewScene("main");
        
        //Creating new object in the scene
        BufferedImage img = loader.loadImage("/Images/example.png");
        Transform t = new Transform(100,100,0,10,10);
        RenderObject obj = new RenderObject(ObjectType.SPRITE, "Image", "Text", img, t);
        obj.addComponent(t);

        t = new Transform(100,50,0,100,50);
        RenderObject obj2 = new RenderObject(ObjectType.TEXT, "Text", "Text", t);

        scene.addObject(obj2);
        scene.addObject(obj);

        ChangeSize cs = new ChangeSize();
        mengine.addLoopEventListener(cs);
        
        display.loadScene(scene);
        
        JFrame frame = new JFrame("test");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.setResizable(false);
        frame.setVisible(true);

        mengine.addLoopEventListener(new LoopEventListener());
        mengine.startEngineLoop(10.0);
    }
    
}

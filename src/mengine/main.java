package mengine;

import javax.swing.JFrame;

public class main {
    
    public static void main(String[] args) {
        
        Display display;
        
        //Initializing mengine
        Mengine mengine = new Mengine();
        mengine.initialize();
        display = mengine.getDisplay();
        
        //Setting up new scene
        SceneManager sceneManager = new SceneManager();
        Scene scene = sceneManager.createNewScene("main");
        
        //Creating new object in the scene
        RenderObject obj = new RenderObject(ObjectType.TEXT, "Text", "Text");
        Transform t = new Transform(100,100,0,100,20);
        obj.addComponent(t);
        scene.addObject(obj);
        
        display.loadScene(scene);
        
        JFrame frame = new JFrame("test");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.setResizable(false);
        frame.setVisible(true);
        
        //loop.start(60.0);
    }
    
}

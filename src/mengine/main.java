package mengine;

import javax.swing.JFrame;

public class main {
    
    public static void main(String[] args) {
        
        Display display;
        Mengine mengine = new Mengine();
        mengine.initialize();
        SceneManager sceneManager = mengine.getSceneManager();
        display = mengine.getDisplay();
        sceneManager.setDisplay(display);
        
        RenderObject obj = new RenderObject(ObjectType.TEXT,"yeet","yeet");
        obj.addComponent(new Transform(10,10,0,10,10));
        
        Scene scene = sceneManager.createNewScene("mainScene");
        scene.addObject(obj);
        System.out.println("Scene size: " + scene.toRender.size());
        sceneManager.loadScene(scene);
        System.out.println(sceneManager.scenes.get(0).name);
        
        
        JFrame frame = new JFrame("test");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mengine.getDisplay());
        frame.setResizable(false);
        frame.setVisible(true);
        
        display.repaint();
    }
    
}

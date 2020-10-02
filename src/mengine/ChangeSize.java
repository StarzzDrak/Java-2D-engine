package mengine;

import mengine.*;

public class ChangeSize implements LoopEvent{

    private RenderObject renderObject;
    private Scene scene;
    private SceneManager sceneManager;
    private Transform t;

    public void start()
    {
        System.out.println("hey");
        scene = sceneManager.getScene(0);
        System.out.println(scene.name);
        renderObject = scene.FindObject("Image");
        System.out.println("name " + renderObject.name);
        //t = (Transform) renderObject.getComponent(new Transform());
    }

    @Override
    public void update() {
        //System.out.println("update " + t.position.x);
        renderObject.transform.position.x += 5;
        System.out.println(renderObject.transform.position.x);
    }
}

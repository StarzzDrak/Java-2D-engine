package mengine;

import mengine.*;

public class ChangeSize implements LoopEvent{

    private RenderObject renderObject;
    private Scene scene;
    private SceneManager sceneManager;
    private Transform t;

    public void start()
    {
        scene = sceneManager.getScene(0);
        System.out.println(scene.name);
        renderObject = scene.FindObject("Image");
        System.out.println(renderObject.name);
        t = (Transform) renderObject.getComponent(new Transform());
    }

    @Override
    public void update() {
        t.position.x += 5;
    }
}

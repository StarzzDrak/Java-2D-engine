package mengine;

import mengine.Physics.Rigidbody;

public class ChangeSize implements LoopEvent{

    private RenderObject renderObject;
    private Scene scene;
    private Rigidbody t;

    public void start()
    {
        scene = SceneManager.getScene(0);
        renderObject = scene.FindObject("Image");
        t = (Rigidbody) renderObject.getComponent(new Rigidbody());
    }

    @Override
    public void update(double deltaTime) {
    	Vector2 v2 = new Vector2(new float[]{1,0});
        t.move(v2);
    }
}

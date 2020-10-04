package mengine;

public class ChangeSize implements LoopEvent{

    private RenderObject renderObject;
    private Scene scene;
    private Transform t;

    public void start()
    {
        scene = SceneManager.getScene(0);
        renderObject = scene.FindObject("Image");
        t = (Transform) renderObject.getComponent(new Transform());
    }

    @Override
    public void update(double deltaTime) {
        //System.out.println("update " + t.position.x);
        //renderObject.transform.position.x += 5*deltaTime;
    	//t.position.x -= 10*deltaTime;
        //System.out.println(renderObject.transform.position.x);
        //time += deltaTime;
        //System.out.println(deltaTime);
    }
}

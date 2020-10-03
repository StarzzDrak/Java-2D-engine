package mengine;

public class ChangeSize implements LoopEvent{

    private RenderObject renderObject;
    private Scene scene;
    private Transform t;

    public void start()
    {
        System.out.println("hey");
        scene = SceneManager.getScene(0);
        System.out.println(scene.name);
        renderObject = scene.FindObject("Image");
        System.out.println("name " + renderObject.name);
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

package mengine;
/**
 * 
 * @author Milan Savickij
 * 
 * <p> Main class of this engine
 * 
 * @since 27th August 2020
 * <p> Last updated on 5th September 2020
 */
public class Mengine {
    
    private Display display;
    private SceneManager sceneManager;
    private RenderLoop renderLoop;

    /**
     * <p> initializes everything needed to work
     */
    public void initialize()
    {
        display = new Display();
        sceneManager = new SceneManager();
        sceneManager.setDisplay(display);
        renderLoop = new RenderLoop();
        renderLoop.addLoopEventListeners(display);
    }
    /**
     * <p> Getter for Display
     * @return Display that was initialized
     */
    public Display getDisplay()
    {
        return display;
    }
    /**
     * <p> Getter for SceneManager
     * @return SceneManager that was initialized
     */
    public SceneManager getSceneManager()
    {
        return sceneManager;
    }
    /**
     * <p> Getter for SceneManager
     * @return RenderLoop that was initialized
     */
    public RenderLoop getRenderLoop()
    {
        return renderLoop;
    }
    /**
     * <p> Shows capabilities of this engine
     */
    public void demo()
    {
    
    }

    /**
     * <p> Adds LoopEvent listener
     * @param listener LoopEven listener that should be added
     */
    public void addLoopEventListener(LoopEvent listener)
    {
        renderLoop.addLoopEventListeners(listener);
    }

    public void startEngineLoop(double fps)
    {
        if(fps == 0) {
            fps = 60.0;
        }
        renderLoop.start(fps);
    }
}

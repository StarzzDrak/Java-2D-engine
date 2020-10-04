package mengine;

import mengine.Physics.CollisionsManager;
import mengine.Physics.PhysicsEvent;

/**
 * 
 * @author Milan Savickij
 * 
 * <p> Main class of this engine
 * 
 * @since 27th August 2020
 * <p> Last updated on 3rd October 2020
 */
public class Mengine {
    
    private static Display display;
    private static SceneManager sceneManager;
    private static RenderLoop renderLoop;
    private static CollisionsManager collisionsManager;

    /**
     * <p> initializes everything needed to work
     */
    public static final void initialize()
    {
        display = new Display();
        sceneManager = new SceneManager();
        collisionsManager = new CollisionsManager();
        sceneManager.setDisplay(display);
        renderLoop = new RenderLoop();
        renderLoop.display = display;
    }
    /**
     * <p> Getter for Display
     * @return Display that was initialized
     */
    public static final Display getDisplay()
    {
        return display;
    }
    /**
     * <p> Getter for SceneManager
     * @return SceneManager that was initialized
     */
    public static final SceneManager getSceneManager()
    {
        return sceneManager;
    }
    /**
     * <p> Getter for SceneManager
     * @return RenderLoop that was initialized
     */
    public static final RenderLoop getRenderLoop()
    {
        return renderLoop;
    }
    /**
     * <p> Getter for CollisionsManager
     * @return CollisionsManager that was initialized
     */
    public static final CollisionsManager getCollisionsManager() 
    {
    	return collisionsManager;
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
    public static final void addLoopEventListener(LoopEvent listener)
    {
        RenderLoop.addLoopEventListeners(listener);
    }
    
    public static final void addPhysicsEventListener(PhysicsEvent listener)
    {
    	RenderLoop.addPhysicsEventListeners(listener);
    }

    public static final void startEngineLoop(double fps)
    {
        if(fps == 0) {
            fps = 60.0;
        }
        renderLoop.start(fps);
    }
}

package mengine;

import mengine.Physics.PhysicsEvent;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Milan Savickij
 * @since 30th September 2020
 * <p> Last update on 3rd October 2020
 */
public class RenderLoop implements Runnable{

    public static List<LoopEvent> listeners;
    public static List<PhysicsEvent> phListeners;

    private static Thread thread;
    
    public Display display;
    
    static boolean running = false;
    static double UPDATE_CAP;

    public RenderLoop()
    {
        listeners = new ArrayList<>();
        phListeners = new ArrayList<>();
    }

    public void start(double fps)
    {
        //System.out.println("Start");
        UPDATE_CAP = 1.0/fps;
        for(LoopEvent l : listeners) 
        {
        	l.start();
        }
        thread = new Thread(this);
        thread.run();
    }
    
    public void stop()
    {
    
    }
    
    public void run()
    {
        //System.out.println("Run");
        running = true;
        
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / (10*Math.pow(10, 8));
        double passedTime = 0;
        double unprocessedTime = 0;
        
        double frameTime = 0;
        int frames = 0;
        int physicsFrames = 0;
        int fps = 0;
        
        while(running)
        {
            //System.out.println("Yeet");
            render = false;
            firstTime = System.nanoTime() / (10*Math.pow(10, 8));
            passedTime = firstTime-lastTime;
            lastTime = firstTime;
            
            unprocessedTime += passedTime;
            frameTime += passedTime;
            
            while(unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                //TODO: update all stuff
                physicsFrames++;
                update(Math.sqrt(passedTime)*10);
                
                if(frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    //System.out.println("Fps: " + fps);
                }
                
                if (physicsFrames > 2) 
                {
                	physicsUpdate(Math.sqrt((passedTime*2)*10));
                	physicsFrames = 0;
                }
                
            }
            
            if(render)
            {
                render();
                frames++;
            } else 
            {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        dispose();
    }
    
    public void dispose()
    {
    
    }
    /**
     * <p> This function forces updates in all scripts implementing this class and having update function
     */
    private static void update(double deltaTime)
    {
        //System.out.println("update");
        for(LoopEvent listener : listeners)
        {
            listener.update(deltaTime);
        }
    }
    
    private static void physicsUpdate(double physicsDeltaTime) 
    {
    	for(PhysicsEvent listener : phListeners) 
    	{
    		listener.physicsUpdate(physicsDeltaTime);
    	}
    }
    
    private void render()
    {
    	display.render();
    }

    public static void addLoopEventListeners(LoopEvent listener)
    {
        listeners.add(listener);
    }
    
    public static void addPhysicsEventListeners(PhysicsEvent listener) 
    {
    	phListeners.add(listener);
    }
}

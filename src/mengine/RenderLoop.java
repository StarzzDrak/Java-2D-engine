package mengine;

interface Loop
{
    public void update();
}

/**
 *
 * @author Milan
 */
public class RenderLoop implements Runnable{
    
    private Thread thread;
    
    boolean running = false;
    final double UPDATE_CAP = 1.0/60;
    
    public void start()
    {
        thread = new Thread(this);
        thread.run();
    }
    
    public void stop()
    {
    
    }
    
    public void run()
    {
        running = true;
        
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / (10*Math.pow(10, 8));
        double passedTime = 0;
        double unprocessedTime = 0;
        
        double frameTime = 0;
        int frames = 0;
        int fps = 0;
        
        while(running)
        {
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
                //System.out.println("UPDATE");
                //TODO: update all stuff
                update();
                
                if(frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("Fps: " + fps);
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
    public void update()
    {
    }
    
    public void render()
    {
    }
}

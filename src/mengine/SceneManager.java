package mengine;

import java.util.ArrayList;
/**
 * @author Milan Savickij
 * 
 * <p> Scene manager is used to manage scenes
 * 
 * @since 27th August 2020
 */
public class SceneManager {

    private static Display display;
    static ArrayList<Scene> scenes = new ArrayList<>();
    /**
     * <p>Creates new scene with new index through which you can access it
     * 
     * @param name Name of newly created scene
     * @return returns created scene
     */
    public Scene createNewScene(String name)
    {
        Scene scene = new Scene(name);
        scene.index = scenes.size();
        scenes.add(scenes.size(), scene);
        return scene;
    }
    
    public void loadScene(int index)
    {
        display.loadScene(scenes.get(index));
    }
    
    public void loadScene(Scene scene)
    {
        display.loadScene(scene);
    }
    
    public void setDisplay(Display d)
    {
        display = d;
    }

    public static Scene getScene(String name)
    {
        for(Scene sc : scenes)
        {
            if(sc.name == name)
            {
                return sc;
            }
        }
        return null;
    }

    public static Scene getScene(int id)
    {
        for(Scene sc : scenes)
        {
            if(sc.index == id)
            {
                return sc;
            }
        }
        return null;
    }
    
}

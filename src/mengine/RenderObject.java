package mengine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * @author Milan Savickij
 * 
 * <p> Object with which you can manipulate or which can be rendered on screen
 * 
 * @since 27th August 2020
 * <p> Last updated on 3rd October 2020
 */
public class RenderObject{
    /**
     * type of the object, 
     * <p><strong>SPRITE</strong> for renderable object
     * 
     * <p><strong>TEXT</strong> for displaying text
     * 
     * <p><strong> EMPTY </strong> for "colliders"
     * 
     */
    private ObjectType type;
    /**
     *  <p> Name of this object
     */
    public String name;
    /**
     * <p>Description of an object, if ObjectType is TEXT, then the description is going to be the text that is displayed
     */
    public String description;

    /**
     * <p> List containing all of components on this object
     */
    public ArrayList<Component> components = new ArrayList<>(); //TODO: after testing change to private
    /**
     * <p> In case ObjectType is <strong>SPRITE</strong>, this image will be rendered to its x and y position.
     * For this Transform component is needed, make sure it is added to an object
     * 
     * @see Transform
     */
    public BufferedImage image;
    /**
     * <p> Basic constructor for RenderObject
     * @param type Type of RenderObject
     * @param name Name
     * @param description Description/text 
     */
    public RenderObject(ObjectType type, String name, String description)
    {
        this.type = type;
        this.name = name;
        this.description = description;
    }
    /**
     * <p> Advanced constructor for RenderObject
     * @param type Type of RednerObject
     * @param name Name
     * @param description Description/text
     * @param components List of components that will be added
     */
    public RenderObject(ObjectType type, String name, String description, ArrayList<Component> components)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.components = components;
    }
    
    /**
     * <p> Basic constructor for RenderObject
     * @param type Type of RednerObject
     * @param name Name
     * @param image Sprite of the object
     */
    public RenderObject(ObjectType type, String name, BufferedImage image)
    {
        this.type = type;
        this.name = name;
        this.image = image;
    }
    /**
     * <p> Basic constructor for RenderObject
     * @param type Type of RednerObject
     * @param name Name
     * @param description Description/text
     * @param image Sprite of the object
     */
    public RenderObject(ObjectType type, String name, String description, BufferedImage image)
    {
    this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    /**
     * <p> Advanced constructor for RenderObject
     * @param type Type of RednerObject
     * @param name Name
     * @param description Description/text
     * @param image Sprite of the object
     * @param components List of components that will be added
     */
    public RenderObject(ObjectType type, String name, String description, BufferedImage image, ArrayList<Component> components)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
        this.components = components;
    }

    public RenderObject(ObjectType type, String name, String description, BufferedImage image, Component com)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
        components.add(com);
    }

    public RenderObject(ObjectType type, String name, String description, Component comp)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        components.add(comp);
    }
    
    /**
     * <p> Adds component to list of components on an object
     * @param comp Component that will be added to components list
     */
    public void addComponent(Component comp)
    {
        components.add(comp);
    }
    
    /**
     * <p> Removes component from list of components on an object
     * @param comp Component that will be removed from components list
     */
    public void removeComponent(Component comp)
    {
       components.remove(comp);
    }
    
    /**
     * <p> Returns requested component
     * @param c Input class of component that you want to get
     * @return Component object through which the subclass can be accessed
     */
    public Component getComponent(Object c)
    {
        
        for(int i = 0; i < components.size(); i++)
        {
            if(components.get(i).getClass().isInstance(c)){
                //System.out.println("return the component");
                return components.get(i);
            }
        }
        return null;
    }
    /**
     * getter for ObjectType 
     * @return type of this object
     */
    public ObjectType getObjectType()
    {
        return type;
    }
}
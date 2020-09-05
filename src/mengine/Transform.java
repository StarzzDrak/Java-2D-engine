package mengine;
/**
 * @author Milan Savickij
 * 
 * <p> This component controls and saves the position and size of an object
 * @since 27th August 2020
 * <p> Last updated on 5th September 2020
 */
public class Transform extends Component{
    public Position position;
    public Size size;
    /**
     * <p>Creates new transform component and assigns all the parameters
     * 
     * @param posx - x position on screen space 
     * @param posy - y position on screen space
     * @param posz - z position on screen space
     * @param sizex - width
     * @param sizey - height
     */
    public Transform(int posx, int posy, int posz, int sizex, int sizey)
    {
        position = new Position(posx, posy, posz);
        size = new Size(sizex, sizey);
    }
    /**
     * <p> Updates location of and object
     * @param x - amount of pixels to move on a x axis
     * @param y - amount of pixels to move on a y axis
     * @param z - amount of pixels to move on a z axis
     */
    public void move(int x, int y, int z)
    {
        position.x += x;
        position.y += y;
        position.z += z;
    }
    /**
     * <p>Changes objects location
     * @param x - position on x axis in screen space
     * @param y - position on y axis in screen space
     * @param z - position on z axis in screen space
     */
    /*public void setPosition(int x, int y, int z)
    {
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }*/
    /**
     *
     * @param axis - requested axis
     * @return returns the position on requested axis, if axis isn't entered in allowed format returns 0
     */
    /*public int getPosition(String axis)
    {
        switch(axis)
        {
            case "x":
                return posX;
            case "y":
                return posY;
            case "z":
                return posZ;
            case "X":
                return posX;
            case "Y":
                return posY;
            case "Z":
                return posZ;
        }
        return 0;
    }*/
    
    /**
     *
     * @param axis - requested axis
     * @return returns the size on requested axis, if axis isn't entered in allowed format returns 0
     */
    /*public int getSize(String axis)
    {
        switch(axis)
        {
            case "x":
                return sizeX;
            case "y":
                return sizeY;
            case "X":
                return sizeX;
            case "Y":
                return sizeY;
        }
        
        return 0;
    }*/
    /**
     * <p> Used to access position of an object in screen space
     */
    public class Position
    {
        
        int x,y,z;
        /**
         * <p> Sets x coordinates of an object
         * @param x 
         */
        public Position(int x)
        {
            this.x = x;
        }
        /**
         * <p> Sets x and y coordinates of an object
         * @param x
         * @param y
         */
        public Position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        /**
         * <p> Sets x,y and z coordinates of an object
         * @param x 
         * @param y
         * @param z
         */
        public Position(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public class Size
    {
        int x, y;
        
        public Size(int x)
        {
            this.x = x;
        }
        
        public Size(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}

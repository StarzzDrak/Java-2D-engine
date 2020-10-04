package mengine;
/**
 * @author Milan Savickij
 * 
 * <p> This component controls and saves the position and size of an object
 * @since 27th August 2020
 * <p> Last updated on 4th October 2020
 */
public class Transform extends Component{
	
    public Position position;
    public Size size;
    public boolean isStatic;
    /**
     * <p>Creates new transform component and assigns all the parameters
     * 
     * @param posx - x position on screen space 
     * @param posy - y position on screen space
     * @param posz - z position on screen space
     * @param sizex - width (0 to use image width)
     * @param sizey - height (0 to use image height)
     */
    public Transform(int posx, int posy, int posz, int sizex, int sizey)
    {
        position = new Position(posx, posy, posz);
        size = new Size(sizex, sizey);
    }

    Transform() {
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
     * <p> Used to access position of an object in screen space
     */
    public class Position
    {
        
        public int x,y,z;
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
    /**
     * <p> Used to access size of an object
     */    
    public class Size
    {
        public int x, y;

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
    /**
     * <p> This function gets called when a component is added to a RenderObject
     */
	@Override
	public void append(RenderObject obj) {
		// TODO Auto-generated method stub
		
	}
}

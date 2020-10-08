package mengine.Physics;

import mengine.Component;
import mengine.RenderObject;
import mengine.*;

public class BoxCollider extends Component {

	protected Transform transform;
	protected Bounds bounds;
	public boolean isStatic;
	
	public BoxCollider() {}
	
	public BoxCollider(boolean isStatic)
	{
		this.bounds = new Bounds(0,0, 250, 250);
		this.isStatic = isStatic;
		CollisionsManager.addCollider(this);
	}
	
	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		
	}
	
	public class Bounds
	{
		int x,y;
		int maxX,maxY;
		//int mx,my;
		
		public Bounds(int x, int y, int width, int height) 
		{
			this.x = x;
			this.y = y;
			this.maxX = width;
			this.maxY = height;
		}
	}

}

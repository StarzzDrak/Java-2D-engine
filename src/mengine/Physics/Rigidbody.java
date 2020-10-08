package mengine.Physics;

import mengine.Component;
import mengine.RenderObject;
import mengine.Transform;
import mengine.Vector2;

public class Rigidbody extends Component {

	public boolean isDynamic;
	public float canMove;
	private Transform transform;
	private BoxCollider col;
	
	public Rigidbody() 
	{
		
	}
	
	public Rigidbody(boolean isDynamic) 
	{
		this.isDynamic = isDynamic;
	}
	
	public void move(Vector2 direction)
	{
		//TODO? check if you dont collide with anything
		canMove = CollisionsManager.checkForCollisions(direction, this.col);
		
		if(canMove > 0f) {
		transform.position.x += direction.direction[0]*canMove;
		transform.position.y += direction.direction[1]*canMove;
		transform.position.z += direction.direction[2]*canMove;
		}
	}
	
	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		col = (BoxCollider)obj.getComponent(new BoxCollider());
		
	}

}

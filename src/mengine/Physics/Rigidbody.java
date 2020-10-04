package mengine.Physics;

import mengine.Component;
import mengine.RenderObject;
import mengine.Transform;

public class Rigidbody extends Component {

	public boolean isDynamic;
	public boolean canMove;
	private Transform transform;
	
	public Rigidbody(boolean isDynamic) 
	{
		this.isDynamic = isDynamic;
	}
	
	public void move(float[] direction)
	{
		if(canMove) {
		transform.position.x += direction[0];
		transform.position.y += direction[1];
		transform.position.z += direction[2];
		}
	}
	
	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		
	}

}

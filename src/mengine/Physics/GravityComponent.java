package mengine.Physics;

import mengine.*;

/**
 * 
 * @author Milan Savickij
 * @since 4th October 2020
 * 
 * <p> Last update on 4th October 2020
 *
 */
//TODO: move gravityComponent into rigidbody, use gravity if object is dynamic
public class GravityComponent extends Component implements PhysicsEvent {

	public float gravityConstant;
	public double mass;
	private Transform transform;
	private float yVelocity = 0;
	public boolean enabled = true;
	
	public GravityComponent(double mass) 
	{
		gravityConstant = PhysicsManager.gravityConstant;
		PhysicsManager.addGravityComponent(this);
		if(mass == 0)
		{
			System.err.println("Mass can't be equal to 0!");
		}
	}
	
	@Override
	public void physicsUpdate(double physicsDeltaTime) {
		//System.out.println("Physics update");
		if(enabled) {
		yVelocity += gravityConstant * physicsDeltaTime;
		
		transform.position.y -= yVelocity;
		}
	}

	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		Mengine.addPhysicsEventListener(this);
	}

}

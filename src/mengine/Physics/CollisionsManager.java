package mengine.Physics;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Milan Savickij
 * @since 3rd October 2020
 * <p> Last updated on 3rd October 2020
 *
 */
public class CollisionsManager implements PhysicsEvent {

	private static List<BoxCollider> colliders;
	
	public CollisionsManager() 
	{
		colliders = new ArrayList<>();
	}
	
	public static void addCollider(BoxCollider col)
	{
		colliders.add(col);
	}

	//Check if new position is intersecting and object, if true dont move

	@Override
	public void physicsUpdate(double physicsDeltaTime) {
		// TODO Auto-generated method stub
		boolean finished = false;
		BoxCollider dynamicCol;
		int i = 0;
		while(!finished) 
		{
			if(colliders.get(i).isStatic == false) 
			{
				dynamicCol = colliders.get(i);
			}
			
			for(BoxCollider col : colliders)
			{
				if(colliders.get(i).isStatic) 
				{
					
				}
			}
		}
	}

}

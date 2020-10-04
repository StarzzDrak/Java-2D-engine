package mengine;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Milan Savickij
 * @since 3rd October 2020
 * <p> Last updated on 3rd October 2020
 *
 */
public class CollisionsManager implements PhysicsEvent{

	private static List<Collider> colliders;
	
	public CollisionsManager() 
	{
		colliders = new ArrayList<>();
	}
	
	public static void addCollider(Collider col) 
	{
		colliders.add(col);
	}
	
	@Override
	public void physicsUpdate(double physicsDeltaTime) {
		// TODO Auto-generated method stub
		boolean finished = false;
		Collider dynamicCol;
		int i = 0;
		while(!finished) 
		{
			if(colliders.get(i).isStatic == false) 
			{
				dynamicCol = colliders.get(i);
			}
			
			for(Collider col : colliders) 
			{
				if(colliders.get(i).isStatic) 
				{
					
				}
			}
		}
	}

}

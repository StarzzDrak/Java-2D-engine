package mengine.Physics;

import java.util.List;

import mengine.Vector2;

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
	public static float checkForCollisions(Vector2 direction, BoxCollider orig) 
	{
		//Our object sizes
		int x = orig.transform.position.x + orig.bounds.x;
		int y = orig.transform.position.y + orig.bounds.y;
		int maxX = x + orig.bounds.maxX;
		int maxY = y + orig.bounds.maxY;
		
		for(BoxCollider col : colliders) 
		{
			int x1 = col.transform.position.x + orig.bounds.x;
			int y1 = col.transform.position.y + orig.bounds.y;
			int maxX1 = x1 + orig.bounds.maxX;
			int maxY1 = y1 + orig.bounds.maxY;
			//Check Left and Right direction
			if(/*Right direction*/maxX + (int)direction.direction[0] > x1-maxX) 
			{
				float d = x1-maxX;
				return d;
			} else if(/*Left direction*/ x - Math.abs((int)direction.direction[0]) < x1-x) 
			{
				
			}
			//if() {}
		}
		
		return 0f;
	}
	@Override
	public void physicsUpdate(double physicsDeltaTime) {
		// TODO Auto-generated method stub
		boolean finished = false;
		BoxCollider dynamicCol;
	}

}

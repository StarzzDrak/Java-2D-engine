package mengine.Physics;

import java.util.ArrayList;
import java.util.List;

public class PhysicsManager {
	
	private static List<GravityComponent> gComponents = new ArrayList<>();
	protected static float gravityConstant = -9.81f;
	
	public static void addGravityComponent(GravityComponent component) 
	{
		gComponents.add(component);
	}
	
	public static void setGravityConstant(float gravityConstant) 
	{
		PhysicsManager.gravityConstant = gravityConstant;
		
		for(GravityComponent comp : gComponents) 
		{
			comp.gravityConstant = gravityConstant;
		}
	}
}

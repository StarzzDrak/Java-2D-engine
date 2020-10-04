package mengine.Physics;

import mengine.Component;
import mengine.RenderObject;
import mengine.*;

public class BoxCollider extends Component {

	protected Transform transform;
	public boolean isStatic;
	
	public BoxCollider(boolean isStatic)
	{
		this.isStatic = isStatic;
		CollisionsManager.addCollider(this);
	}
	
	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		
	}

}

package mengine;

public class Collider extends Component{

	protected Transform transform;
	public boolean isStatic;
	
	public Collider(boolean isStatic) 
	{
		this.isStatic = isStatic;
		CollisionsManager.addCollider(this);
	}
	
	@Override
	public void append(RenderObject obj) {
		transform = (Transform)obj.getComponent(new Transform());
		
	}

}

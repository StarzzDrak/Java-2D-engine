package mengine.Physics;

public interface PhysicsEvent {
	public static double physicsDeltaTime = 0;
	void physicsUpdate(double physicsDeltaTime);
}

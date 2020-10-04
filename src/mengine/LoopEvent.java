package mengine;

public interface LoopEvent {
	public static double deltaTime = 0;
    public void update(double deltaTime);
    public void start();
}

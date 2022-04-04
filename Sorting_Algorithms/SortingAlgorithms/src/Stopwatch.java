
public class Stopwatch {
	
	private final long START;
	
	public Stopwatch()
	{
		START = System.currentTimeMillis();
	}
	
	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now - START) / 1000.0;
	}

}

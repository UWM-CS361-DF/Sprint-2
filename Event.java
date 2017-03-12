import java.util.ArrayDeque;
import java.util.Deque;

public interface Event{
	Deque<Competitor> startQueue = new ArrayDeque<Competitor>();
	Deque<Competitor> finishQueue = new ArrayDeque<Competitor>();
	Deque<Competitor> completed = new ArrayDeque<Competitor>();
	public void start();
	public void finish();
	public void dnf();
	public void cancel();
	public String getEventType();
}

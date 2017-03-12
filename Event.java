import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public interface Event{
	public Deque<Competitor> startQueue = new ArrayDeque<Competitor>();
	public Deque<Competitor> finishQueue = new ArrayDeque<Competitor>();
	public Deque<Competitor> completed = new ArrayDeque<Competitor>();
	public boolean add(int competitorNo);
	public void start();
	public void finish();
	public void dnf();
	public void cancel();
	public String getEventType();
	public Deque getCompleted();
}

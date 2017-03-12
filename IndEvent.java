import java.util.ArrayDeque;
import java.util.Deque;

/*
 The IndEvent class :) 
 This class defines the Individual Event object 🎎🤡
 
 */

public class IndEvent implements Event{//extends ChronoInterface implements Event{
	Deque<Competitor> startQueue;// = new ArrayDeque<Competitor>();
	Deque<Competitor> finishQueue;// = new ArrayDeque<Competitor>();
	Deque<Competitor> completed;// = new ArrayDeque<Competitor>();
	public IndEvent(){
		startQueue = new ArrayDeque<Competitor>();
		finishQueue = new ArrayDeque<Competitor>();
		completed = new ArrayDeque<Competitor>();
	}
	Competitor temp;
	
	// if the start queue of the race is not empty
	// take out the head of the start queue
	// set the start time of the competitor
	// put the competitor to the finish queue
	@Override
	public void start() {
		if(!startQueue.isEmpty()){
			System.out.println(x);
			temp=startQueue.remove();
			temp.setStartTime(Time.systemTime.getRunningTime());
			finishQueue.add(temp);
		}
	} 
	// if the finish queue is not empty
	// take out the head of the start queue
	// set the finish time of the competitor
	// put the competitor to the completed queue 
	@Override
	public void finish() {
		if(!finishQueue.isEmpty()){
			temp=finishQueue.remove();
			temp.setFinishTime(Time.systemTime.getRunningTime());
			completed.add(temp);
		}
	}
	@Override
	public void dnf(){
		Competitor temp;
		temp=finishQueue.remove();
		temp.dnf=true;
		completed.add(temp);
	}
	@Override
	public void cancel(){
		startQueue.addFirst(finishQueue.removeLast());
	}
	@Override
	public String getEventType(){
		return "IND";
	}
}

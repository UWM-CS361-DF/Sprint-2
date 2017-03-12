import java.util.ArrayDeque;
import java.util.Deque;

/*
 The IndEvent class :) 
 This class defines the Individual Event object 🎎🤡
 
 */

public class IndEvent implements Event{//extends ChronoInterface implements Event{
	public Deque<Competitor> startQueue;// = new ArrayDeque<Competitor>();
	public Deque<Competitor> finishQueue;// = new ArrayDeque<Competitor>();
	public Deque<Competitor> completed;// = new ArrayDeque<Competitor>();
	
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
	public boolean add(int competitorNo){
		if(startQueue.contains(temp)||finishQueue.contains(temp)||completed.contains(temp))
			return false;
		startQueue.add(new Competitor(competitorNo));
		return true;
	}
	@Override
	public void start() {
		System.out.println("here");
		if(!startQueue.isEmpty()){
			System.out.println("here2");
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
	@Override
	public Deque getCompleted(){
		return completed;
	}
}

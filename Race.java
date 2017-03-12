import java.util.ArrayDeque;
import java.util.Deque;

/**
 
 The Race class.
 
 */
public class Race {
	String eventType;
	boolean runInProgress=true;
	int runNum=1;
	Event event = new IndEvent();
	
    // make a new IND event
	public Event setEvent(String type){
		switch (type) {
		case "IND":
			event = new IndEvent();
		case "PARIND":
			event = new ParIndEvent();
		case "GRP":
			//break;
		case "PARGRP":
			//break;
		return event;
		}
		return null;
	}
    
    //
	public boolean newRun(){
        // if there is not a run in progress, clear every queue, increment the number of runs, and set runInProgress true
		if(!runInProgress){
			event.startQueue.clear();
			event.finishQueue.clear();
			event.completed.clear();
			runNum++;
			runInProgress=true;
			return runInProgress;
		}
        // otherwise, return false
        /*
         * is it !runInProgress instead of false on purpose?
         */
		return !runInProgress;
	}
    // set runInProgress false
	public void endRun(){
		runInProgress=false;
	}
    // print the race
	public void print(){
		System.out.println("Run " +runNum+" "+event.getEventType()+" Results");
		System.out.println("NUM\tTime");
		Deque<Competitor> temp = event.getCompleted();
		for(Competitor competitor:temp){
			System.out.print(competitor.getCompetitorNumber() + "\t");
			System.out.println(competitor.dnf ? "DNF" : String.format("%.2f", competitor.getRaceTime()));
		}
	}
    // todo
	public void export(String run){
		
	}
    
	public boolean setNum(int competitorNo){
		return event.add(competitorNo);
	}
    
    //todo
	public void clear(int competitorNo){
		
	}
    
    // todo
	public void swap(){
		
	}
    
    // take the current competitor from the finish queue and turn dnf true, and put the competitor to the completed queue
	public void dnf(){
		event.dnf();
	}
    // take the current competitor from the finsh queue and put it to the start queue 
	public void cancel(){
		event.cancel();
	}
}

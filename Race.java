import java.util.ArrayDeque;
import java.util.Deque;

/**
 
 The Race class.
 
 */
public class Race {
	// type of the race
	String type;
    // if the run is in progress
	boolean runInProgress=true;
    // the number of runs
	int runNum=1;
    // start queue
	Deque<Competitor> startQueue = new ArrayDeque<Competitor>();
    // finish queue
	Deque<Competitor> finishQueue = new ArrayDeque<Competitor>();
    // complet queue
	Deque<Competitor> completed = new ArrayDeque<Competitor>();
	
    // make a new IND event
	public Event setEvent(String type){
		switch (type) {
		case "IND":
			return new IndEvent();
		case "PARIND":
			break;
		case "GRP":
			break;
		case "PARGRP":
			break;
		}
		return null;
	}
    
    //
	public boolean newRun(){
        // if there is not a run in progress, clear every queue, increment the number of runs, and set runInProgress true
		if(!runInProgress){
			startQueue.clear();
			finishQueue.clear();
			completed.clear();
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
		System.out.println("Run " +runNum+" Results");
		System.out.println("NUM\tTime");
		for(Competitor competitor:completed){
			System.out.print(competitor.getCompetitorNumber() + "\t");
			System.out.println(competitor.dnf ? "DNF" : String.format("%.2f", competitor.getRaceTime()));
		}
	}
    // todo
	public void export(String run){
		
	}
    
	public boolean setNum(int competitorNo){
		return startQueue.add(new Competitor(competitorNo));
	}
    
    //todo
	public void clear(int competitorNo){
		
	}
    
    // todo
	public void swap(){
		
	}
    
    // take the current competitor from the finish queue and turn dnf true, and put the competitor to the completed queue
	public void dnf(){
		Competitor temp;
		temp=finishQueue.remove();
		temp.dnf=true;
		completed.add(temp);
	}
    // take the current competitor from the finsh queue and put it to the start queue 
	public void cancel(){
		startQueue.addFirst(finishQueue.removeLast());
	}
}

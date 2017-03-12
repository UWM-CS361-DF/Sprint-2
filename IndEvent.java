/*
 The IndEvent class :) 
 This class difines the Indivisual Event object 🎎🤡
 
 */

public class IndEvent implements Event{//extends ChronoInterface implements Event{
    
	public IndEvent(){
		
	}
	Competitor temp;
	@Override
	public void start() {
        // if the start queue of the race is empty
		if(!ChronoInterface.chronoTimer.race.startQueue.isEmpty()){
            // take out the head of the start queue
			temp=ChronoInterface.chronoTimer.race.startQueue.remove();
            // set the start time of the competitor
			temp.setStartTime(Time.systemTime.getRunningTime());
            // put the competitor to the finish queue
			ChronoInterface.chronoTimer.race.finishQueue.add(temp);
		}
	}

	@Override
	public void finish() {
        // if the finish queue is empty
		if(!ChronoInterface.chronoTimer.race.finishQueue.isEmpty()){
            // take out the head of the start queue
			temp=ChronoInterface.chronoTimer.race.finishQueue.remove();
            // set the finish time of the competitor
			temp.setFinishTime(Time.systemTime.getRunningTime());
            // put the competitor to the completed queue 
			ChronoInterface.chronoTimer.race.completed.add(temp);
		}
	}	
}

import java.util.ArrayList;
import java.util.List;

//******************************************************
// The ChronoInterface class acts as a literal interface
// for the ChronoTimer. This has all of the methods that
// could be directly related to the interface buttons to 
// generate a command.(i.e the tog "button" is pressed
// it relates to tog() method. The chronoInterface then 
// determines what to do with the information provided
//******************************************************

public class ChronoInterface {
	public static ChronoInterface chronoTimer = new ChronoInterface();
	List<Channel> channels = new ArrayList<Channel>(9);//0 will be an empty channel location for ease of assigning
	Power power = new Power();
	Race race = new Race();
	//Event event = new IndEvent();
	
	public ChronoInterface(){
		channels.add(0,null);
		for(int i=1;i<9;i++){
			channels.add(i,new Channel(i));
		}
		Time.systemTime.setTime();
	}
	public void power(){
		System.out.println(power.power() ? "Power On" : "Power Off");		
	}
	public void time(String time){
		if(power.powerStatus){
			Time.systemTime.setTime(Time.systemTime.toSeconds(time));
			System.out.println("Set Time to "+ Time.systemTime.toString(Time.systemTime.getRunningTime()));
		}
	}
	public void dnf(){
		if(power.powerStatus)
			race.dnf();
	}
	public void cancel(){
		if(power.powerStatus)
			race.cancel();
	}
	public void tog(String channel){
		if(power.powerStatus)
			System.out.println(channels.get(Integer.parseInt(channel)).tog() ? "Channel "+channel+" is Armed" : "Channel "+channel+" is not Armed");
	}
	public void trig(String channel){
		if(power.powerStatus)
			if(channels.get(Integer.parseInt(channel)).trig()){
				System.out.println("Triggered Channel "+channel);
				if(Integer.parseInt(channel)%2==0)
					race.event.finish();
				else
					race.event.start();
			}
			else
				System.out.println("Unable to Trigger Channel "+channel);		
	}
	public void start(){
		if(power.powerStatus)
			trig("1");
	}
	public void finish(){
		if(power.powerStatus)
			trig("2");
	}
	public void conn(String sensor, String channel){
		if(power.powerStatus)
			channels.get(Integer.parseInt(channel)).conn(sensor);
	}
	public void disc(String channel){
		if(power.powerStatus)
			channels.get(Integer.parseInt(channel)).disc(Integer.parseInt(channel));
	}
	public void event(String type){
		if(power.powerStatus)
			System.out.println(race.setEvent(type)!=null ? "Created "+type+" event": "Failed to create "+type+" event");
	}
	public void newrun(){
		if(power.powerStatus)
			System.out.println(race.newRun()? "Created Run "+race.runNum : "Run "+race.runNum+" Still In Progress");
	}
	public void endrun(){
		if(power.powerStatus){
			race.endRun();
			System.out.println("Ended Run "+(race.runNum));
		}
	}
	public void print(){
		if(power.powerStatus)
			race.print();
	}
	public void export(String run){
		if(power.powerStatus)
			race.export("");
	}
	public void num(String number){
		if(power.powerStatus)
			System.out.println(race.setNum(Integer.parseInt(number)) ? "Added "+number+" to Race queue": "Failed to add "+number+" to Race queue");
	}
	public void clr(String number){
		if(power.powerStatus)
			race.clear(Integer.parseInt(number));
	}
	public void swap(){
		if(power.powerStatus)
			race.swap();
	}
}

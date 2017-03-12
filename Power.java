
public class Power {
	
	boolean powerStatus=false;
	
	public boolean power(){
		powerStatus=!powerStatus;//switch on when poweroff and vice versa
		return powerStatus;
	}
}

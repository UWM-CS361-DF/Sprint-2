import java.io.BufferedWriter;
import java.io.FileWriter;
import com.google.gson.Gson;

public class Export {
	Gson g = new Gson();
	String json;
	
	public Export(Event run) throws Exception{
		FileWriter file = new FileWriter("run"+ChronoInterface.chronoTimer.runNum+".txt");
		BufferedWriter buffer = new BufferedWriter(file);
		json = g.toJson(run);
		buffer.write(json);
		buffer.flush();
		buffer.close();
	}
}

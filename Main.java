package dbscan;

import java.io.IOException;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		SpeedDemon demon = new SpeedDemon("5.in");
		int ans = demon.run();
		System.out.println(ans);
		
		
	}
	
}

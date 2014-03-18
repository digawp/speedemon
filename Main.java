package dbscan;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		SpeedDemon demon = new SpeedDemon("8.in");
		StopWatch sw = new StopWatch();
		sw.start();
		int ans = demon.run();
		sw.stop();
		System.out.println(ans);
		System.out.println(sw.getTime());
	}
	
}

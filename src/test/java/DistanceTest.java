import static org.junit.Assert.*;

import org.junit.Test;

import com.bawei.util.GPSUtil;

public class DistanceTest {

	@Test
	public void test() {
		double distance = GPSUtil.getDistance("113.05614162895964", "36.056462770513164", "121.72319670215607", "30.86647676226209");
		
		System.out.println(distance+"km");
	}

}

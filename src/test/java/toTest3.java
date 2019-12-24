import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bawei.util.CSVUtils;
import com.bawei.util.GPSUtil;
import com.bawei.util.NumberUtil;
import com.bawei.util.StringUtils;
import com.bawei.util.WeekUtil;
import com.szt.bean.CarDomain;
import com.szt.service.CService;

public class toTest3 {

	@Test
	public void test() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
				CService bean = (CService) context.getBean("serviceImpl");
			List<String> csv = CSVUtils.importCsv(new File("C:\\Users\\Zetao\\Desktop\\car.csv"));
			Double tamJD = 116.39746999999998;
			Double tamWD = 39.90958013090996;
			
			for (String string : csv) {
				String[] split = string.split(",");
				CarDomain carDomain = new CarDomain(split[0], split[1], Double.valueOf(split[2]), Double.valueOf(split[3]), split[4], split[5], split[6], "没有违反任何规则", 0, "");
				String firstCar = split[0];
				String Addr = firstCar.substring(0, 1);
				String carType = split[1];
				if(Addr.equals("京")&&carType.equals("C")) {
					String endChar = firstCar.substring(firstCar.length()-1);
					if(StringUtils.isNumber(endChar)) {
						Boolean oddNumber = NumberUtil.isOddNumber(Integer.valueOf(endChar));
						boolean dateTime = WeekUtil.isOddDayOfWeekFromDateTime(split[4]);
						if(oddNumber==dateTime) {
							
							
							
						}else {
							carDomain.setIsodd(1);
							carDomain.setLawMessage("违反单双号限行");
							bean.toAdd(carDomain);
						}
						
						
					}
					
					
				}else if(!firstCar.equals("京")&&carType.equals("C")) {
					String jd = split[2];
					String wd = split[3];
					double distance = GPSUtil.getDistance(tamJD.toString(),tamWD.toString(), jd, wd);
					if(distance<60) {
						carDomain.setLawAddr("5");
						carDomain.setLawMessage("违法进入了五环");
						bean.toAdd(carDomain);
					}
					
					
				}else if(firstCar.equals("京")&&carType.equals("B")) {
					String jd = split[2];
					String wd = split[3];
					double distance = GPSUtil.getDistance(tamJD.toString(),tamWD.toString(), jd, wd);
					if(distance<40) {
						carDomain.setLawAddr("4");
						carDomain.setLawMessage("违法进入了4环");
						bean.toAdd(carDomain);
					}
					
					
				}
				else if(firstCar.equals("京")&&carType.equals("A")) {
					String jd = split[2];
					String wd = split[3];
					double distance = GPSUtil.getDistance(tamJD.toString(),tamWD.toString(), jd, wd);
					if(distance<40) {
						carDomain.setLawAddr("2");
						carDomain.setLawMessage("违法进入了2环");
						bean.toAdd(carDomain);
					}
					
					
				}else {
					bean.toAdd(carDomain);
				}
				
				
			}
		
	}

}

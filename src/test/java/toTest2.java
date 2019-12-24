import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bawei.util.CSVUtils;
import com.bawei.util.DateUtils;
import com.bawei.util.GPSUtil;
import com.bawei.util.NumberUtil;
import com.bawei.util.StringUtils;
import com.bawei.util.WeekUtil;
import com.szt.bean.CarDomain;
import com.szt.service.CService;

public class toTest2 {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CService bean = (CService) context.getBean("serviceImpl");
		Double tamJD = 116.39746999999998;
		Double tamWD = 39.90958013090996;
		File file = new File("C:\\Users\\Zetao\\Desktop\\car.csv");
		
		List<CarDomain> arrayList = new ArrayList<CarDomain>();
		List<String> list = CSVUtils.importCsv(file);
		for (String string : list) {
			String[] split = string.split(",");
			String carNumber = split[0];
			String firstCar = carNumber.substring(0, 1);
			String carType = split[1];
			if(firstCar.equals("京")&&carType.equals("C")) {
				
				String endChar = carNumber.substring(carNumber.length()-1);
				if(StringUtils.isNumber(endChar)) {
					Boolean oddNumber = NumberUtil.isOddNumber(Integer.valueOf(endChar));
					boolean weekIsOdd = WeekUtil.isOddDayOfWeekFromDateTime(split[4]);
					if(oddNumber==weekIsOdd) {
						CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"没有违反",0,"");
						bean.toAdd(carDomain);
						
					}else {
						CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"违反单双号限行",1,"");
						arrayList.add(carDomain);
						bean.toAdd(carDomain);
						System.out.println("违反单双号限行");
					}
				}
				
			}else if(!firstCar.equals("京")&&carType.equals("C")) {
				String jd=split[2];
				String wd=split[3];
				double distance = GPSUtil.getDistance(tamJD.toString(), tamWD.toString(), jd, wd);
				
				System.out.println("非京牌距离"+distance);
				if(distance<60) {
					
					CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"违反进入五环",0,"5");
					bean.toAdd(carDomain);
					arrayList.add(carDomain);
					
				}else {
					CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"没有违反",0,"");
					bean.toAdd(carDomain);
					
				}
			}else if(firstCar.equals("京")&&carType.equals("B")) {
				String jd=split[2];
				String wd=split[3];
				double distance = GPSUtil.getDistance(tamJD.toString(), tamWD.toString(), jd, wd);
				System.out.println("京牌B距离"+distance);
				if(distance<40) {
	CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"违反进入四环",0,"4");
	bean.toAdd(carDomain);
					arrayList.add(carDomain);
					
				}else {
					
					CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"没有违反",0,"");
					bean.toAdd(carDomain);
				}
			}else if(firstCar.equals("京")&&carType.equals("A")) {
				String jd=split[2];
				String wd=split[3];
				double distance = GPSUtil.getDistance(tamJD.toString(), tamWD.toString(), jd, wd);
				System.out.println("京牌A距离"+distance);
				if(distance<40) {
	CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"违反进入二环",0,"2");
	bean.toAdd(carDomain);
					arrayList.add(carDomain);
					
				}else {
					CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"没有违反",0,"");
					bean.toAdd(carDomain);
				}
				
			}else {
				
				CarDomain carDomain = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),split[4],split[5],split[6],"没有违反",0,"");
				bean.toAdd(carDomain);
			}
			
		}
		
		
	}

}

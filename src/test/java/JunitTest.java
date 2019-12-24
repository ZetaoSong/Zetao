

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.util.CSVUtils;
import com.bawei.util.DateUtils;
import com.bawei.util.DistanceUtils;
import com.bawei.util.GPSUtil;
import com.bawei.util.NumberUtil;
import com.bawei.util.StringUtil;
import com.bawei.util.WeekUtil;
import com.lipeng.cms.domin.Car;
import com.lipeng.cms.service.CarService;
import com.szt.bean.CarDomain;
import com.szt.service.CService;


public class JunitTest {
/***
 *
 * 距离参照点未天安门:39.90958013090996 116.39746999999998 测试数据导入 京牌 C
 * :抓拍时间的星期几的尾数与车牌号的尾数奇偶数是否相同 京BPG232:2 4 6 京牌 A :可以进入二环 <15公里 京牌 B
 * :可以进入四环不可以进入二环 >15公里 <40公里 非京牌 C :不可以进入五环 >60KM
 * 
 * @author Administrator
 *
 *
 */
	@Autowired
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CService bean = (CService) context.getBean("serviceImpl");
		List<String> importCsv = CSVUtils.importCsv(new File("C:\\\\Users\\\\Zetao\\\\Desktop\\\\car.csv"));
		//天安门经纬度
		S tamjd=116.39746999999998;
		Double tamwd=39.9095801309996;
		for(int i=1;i<importCsv.size();i++){
			String string = importCsv.get(i);
			String[] split = string.split(",");
			Date stringToDatetime = DateUtils.stringToDatetime(split[4]);
			CarDomain car = new CarDomain(split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),stringToDatetime,split[5],split[6]);
			//得到牌照
			String firstnumber = car.getCarNumber().substring(0, 1);
			//得到类型
			String carType = car.getCarType();
			//本地牌照
			if(firstnumber.equals("京") && carType.equals("小轿车")){
				//牌照尾号
				String substring = car.getCarNumber().substring(car.getCarNumber().length()-1);
				if(StringUtil.isNumber(substring)){
					//日期
					String dateToString = DateUtils.dateToString(car.getRegdate());
					//判断牌照尾号是否为奇数
					Boolean oddNumber = NumberUtil.isOddNumber(Integer.parseInt(substring));
					boolean date = WeekUtil.isOddDayOfWeekFromDate(dateToString);
					if(date==oddNumber){
						//没有违反单双号限行
						car.setLawMessage("未违反");
						car.setIsodd(0);
						 bean.toAdd(car);
					}else{
						//违反单双号限行
						car.setLawMessage("违反单双限行");
						car.setIsodd(1);
						 bean.toAdd(car);
					}
				}
				
			}else if(firstnumber.equals("京") && carType.equals("摩托车A")){
				double wd = car.getWd();
				double jd = car.getJd();
				double distance = GPSUtil.getDistance(tamjd, tamwd, wd, jd);
				if(distance<15){
					//违法未进入2环
					car.setWfmessage("违法进入2环");
					car.setHx(2);
					car.setWf(1);
					int queryadd = service.queryadds(car);
				}else{
					car.setCarNumber("未违法");
					car.setWf(0);
					int queryadd = service.queryadds(car);
					//未违法
				}
			}else if(firstnumber.equals("京") && carType.equals("摩托车B")){
				double wd = car.getWd();
				double jd = car.getJd();
				double distance = DistanceUtils.getDistance(jd, wd, tamjd, tamwd);
				if(distance<40){
					//违法未进入4环
					car.setWfmessage("违法进入4环");
					car.setHx(4);
					car.setWf(1);
					int queryadd = service.queryadds(car);
				}else{
					car.setCarNumber("未违法");
					car.setWf(0);
					int queryadd = 	service.queryadds(car);
					//未违法
				}
			}else if(!firstnumber.equals("京") && carType.equals("小轿车")){
				double wd = car.getWd();
				double jd = car.getJd();
				double distance = DistanceUtils.getDistance(jd, wd, tamjd, tamwd);
				if(distance<60){
					//违法未进入5环
					car.setWfmessage("违法进入5环");
					car.setHx(5);
					car.setWf(1);
					int queryadd = 	service.queryadds(car);
				}else{
					car.setCarNumber("未违法");
					car.setWf(0);
					int queryadd = service.queryadds(car);
					//未违法
				}
			}
		}
	}
}

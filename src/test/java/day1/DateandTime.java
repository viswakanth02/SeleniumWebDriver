package day1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateandTime {

	public static void main(String[] args) {
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date= new Date();
		String currentDateandTimeStamp =dateFormate.format(date);
		System.out.println(currentDateandTimeStamp);
	}

}

package ptp.function;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTimeDate {
	
	public static void main(String[] args) {
		/*Date d = new Date();
		FormatTimeDate f = new FormatTimeDate();
		String s = f.format(d, 0);
		System.out.println(s);*/
	}
	
	public String format(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = format.format(d);
		return s;
	}
	
	public String format(Date d, int y) {
		String s;
		switch (y) {
		case 0: s = "MM/dd/yy HH:mm:ss"; break;
		case 1: s = "yyyy年MM月dd日 HH时mm分ss秒"; break;
		
		default: s = "yyyy-MM-dd HH:mm:ss"; break;
		}
		SimpleDateFormat format = new SimpleDateFormat(s);
		s = format.format(d);
		return s;
	}
}

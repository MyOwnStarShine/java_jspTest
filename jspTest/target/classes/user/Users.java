package ptp.user;

import java.util.Date;
import ptp.function.FormatTimeDate;

public class Users {

	private int id = 0;
	private String username = "";
	
	public int register(String username, String passwd, String truename, String nickname, String ssex)
	{
		if(username == null || username.length()<3 || passwd == null || passwd.length()<6) return 0;
		int sex  = Integer.parseInt(ssex);
		System.out.println(sex);
		return 0;
	}

}

package co.bucketstargram.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrimaryKey {
	public static String create() {
		Date now = new Date(); 
		String PrimaryKey = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(now);
		
		return PrimaryKey;
<<<<<<< HEAD
	} //d
=======
	}
>>>>>>> branch 'master' of https://github.com/flaj5477/MiniProject.git
}

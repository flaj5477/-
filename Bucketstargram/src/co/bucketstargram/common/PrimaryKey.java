package co.bucketstargram.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrimaryKey {
	public static String create() {
		Date now = new Date(); 
		String PrimaryKey = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(now);
		
		return PrimaryKey;
	} //d
}

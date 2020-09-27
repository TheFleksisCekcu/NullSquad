package gq.catchthels.nullhepler.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {
	public static String time() {
		Calendar calendar = Calendar.getInstance();
		return new SimpleDateFormat("HH:mm:ss").format(calendar.getTime());
	}

}

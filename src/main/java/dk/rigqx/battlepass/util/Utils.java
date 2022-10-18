package dk.rigqx.battlepass.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static String getFormattedTime(int n, boolean withSeconds){
		if(n > 0){
			int days, hours, minutes, seconds = 0;

			days = (int) Math.floor( n / 86400 );
			hours = (int) Math.floor( (n / 3600) - (days * 24) );
			minutes = (int) Math.floor( (n / 60)-((hours + (days * 24) ) * 60) );
			seconds = (int) Math.floor(n - ((days * 86400) + (hours * 3600) + (minutes * 60)));
			StringBuilder sb = new StringBuilder();
			List<String> stringList = new ArrayList<String>();
			if(days > 0) {
				stringList.add(days + ((days == 1) ? " d" : " d"));
			}
			if(hours > 0){
				stringList.add(hours + ((hours == 1) ? " t" : " t"));
			}
			if(minutes > 0){
				stringList.add(minutes + ((minutes == 1) ? " m" : " m"));
			}
			if(withSeconds){
				if(seconds > 0){
					stringList.add(seconds + ((seconds == 1) ? " s" : " s"));
				}
			}else{
				if(days <= 0 && hours <= 0 && minutes <= 0){
					if(seconds > 0){
						stringList.add(seconds + ((seconds == 1) ? " s" : " s"));
					}
				}
			}

			for (int i = 0; i < stringList.size(); i++) {
				if (i != 0) {
					sb.append(i == stringList.size() - 1 ? " & " : ", ");
				}
				sb.append(stringList.get(i));
			}

			return sb.toString();
		}
		else{
			return "0 Sekunder";
		}
	}
}

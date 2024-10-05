package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		 StringBuilder cleanedString = new StringBuilder();
		 String cleanedTime= null;
		for(int i= 0; i<timestr.length();i++) {
			char sym = timestr.charAt(i);
			if(sym!='Z'&& sym!=':'&& sym!='-'&&sym!='.') {
				 cleanedString.append(sym);
			}
			 cleanedTime = cleanedString.toString();
			 
		}
		int time = Integer.parseInt(cleanedTime.substring(10,15));
		hr = time / 10000;
		min = (time / 100) % 100;
		sec = time % 100;
		
		
		return secs = (hr * 3600) + (min * 60) + sec;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		 
		int tid = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		GPSPoint gpspoint = new GPSPoint(tid, latitude, longitude, elevation);
		return gpspoint;
	}
	
}

package no.hvl.dat100ptc.oppgave2;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
public class GPSDataConverter {

	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String s) {
		String tid = s.substring(11);
		int h = Integer.parseInt(tid.substring(0, 2));
		int min = Integer.parseInt(tid.substring(3, 5));;
		int sek = Integer.parseInt(tid.substring(6, 8));
		int secs = (h*60*60) + (min*60) + sek;
		return secs;
	}
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		System.out.println(toSeconds(timeStr));
		int a = toSeconds(timeStr);
		double b = Double.parseDouble(latitudeStr);
		double c = Double.parseDouble(longitudeStr);
		double d = Double.parseDouble(elevationStr);
		GPSPoint gpspoint = new GPSPoint(a, b, c, d);
		return gpspoint;
	}
	
}

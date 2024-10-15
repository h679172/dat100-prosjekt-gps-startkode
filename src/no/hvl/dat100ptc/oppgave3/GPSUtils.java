package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		min = da[0];
		
		for (double d : da) {
			if (d<min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] latitudes = new double[gpspoints.length];
		for(int i = 0; i<gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		
		double[] longitudes = new double[gpspoints.length];
		for(int i = 0; i<gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
		

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = toRadians( gpspoint1.getLatitude()) ;
		latitude2 = toRadians( gpspoint2.getLatitude()) ;
		longitude1 = toRadians( gpspoint1.getLongitude()) ;
		longitude2 = toRadians( gpspoint2.getLongitude()) ;
		double deltaphi = latitude2 - latitude1;
		double deltadelta = longitude2 - longitude1;
		double a = compute_a(latitude1, latitude2, latitude1, latitude2, deltaphi, deltadelta);
	    
		double c = compute_c(a);
		return d = R * c;
		
	}
	
	private static double compute_a(double latitude1, double latitude2, double phi1, double phi2, double deltaphi, double deltadelta) {
	
		double a = (pow(sin(deltaphi/2),2) + cos(latitude1) * cos(latitude2) * pow(sin(deltadelta/2) ,2)) ;
		return a;

	}

	private static double compute_c(double a) {

		
		double c = 2 * atan2(sqrt(a),sqrt(1-a)) ;
		
				
		return c;
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		double punkt1tid = gpspoint1.getTime();
		double punkt2tid = gpspoint2.getTime();
		double dist = distance(gpspoint1 , gpspoint2);
		
		secs = (int) (punkt2tid - punkt1tid);
		
		return speed = dist / secs;
		
	}

	public static String formatTime(int secs) {

		String timestr = "";
		String TIMESEP = ":";

		int hour = secs / 3600;
		int min = (secs/60) % 60;
		int sec = secs % 60;
		
		String timestrv = String.format("%02d"+TIMESEP+"%02d"+TIMESEP+"%02d",hour,min,sec );
		boolean leng = false;
		while (leng == false) {
		if(timestrv.length()<10) {
			String add = " ";
			timestrv = add + timestrv;
			}
		else {
			timestr = timestrv ;
			leng = true;
			}
		}
		timestr = timestrv;
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		String timestrv = String.format("%.2f",d);
		 timestrv = timestrv.replace(',', '.');
		boolean leng = false;
		while (leng == false) {
		if(timestrv.length()<10) {
			String add = " ";
			timestrv = add + timestrv;
			}
		else {
			str = timestrv ;
			leng = true;
			}
		}
		str = timestrv;
		return str;
	}
	
	
	}


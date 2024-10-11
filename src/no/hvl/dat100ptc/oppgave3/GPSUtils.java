package no.hvl.dat100ptc.oppgave3;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
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
		double min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		double d;
		double latitude1, longitude1, latitude2, longitude2;
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		double deltaphi = latitude2 - latitude1;
		double deltadelta = longitude2 - longitude1;
		double sinDP = (Math.sin(deltaphi/2)) * (Math.sin(deltaphi/2));
		double sinDD = (Math.sin(deltadelta/2)) * (Math.sin(deltadelta/2));
		double a = compute_a(latitude1, latitude2, sinDP, sinDD);
		double c = compute_c(a);
		d = R*c;
		System.out.println(d);
		return d;
	}
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		double compute;
		phi1 = Math.cos(phi1);
		phi2 = Math.cos(phi2);
		compute = deltaphi + phi1 * phi2 * deltadelta;
		return compute;
	}

	private static double compute_c(double a) {
		double compute;
		compute = 2 * (Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
		return compute;
	}
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		int secs;
		double speed;
		double distance = distance(gpspoint1, gpspoint2);
		secs = (gpspoint1.getTime() + gpspoint1.getTime() / 1000);
		speed = distance/secs;
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		int hours = secs / 3600;
		int min = secs / 60;
		String TIMESEP = ":";
		timestr = hours + TIMESEP + min + TIMESEP + secs;
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO
		
	}
}

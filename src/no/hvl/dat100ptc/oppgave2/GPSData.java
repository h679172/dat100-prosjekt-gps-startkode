package no.hvl.dat100ptc.oppgave2;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {
	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		gpspoints = new GPSPoint[antall];
	}
	public GPSPoint[] getGPSPoints() {
		GPSPoint[] p = new GPSPoint[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			p[i] = gpspoints[i];
		}
		return p;
	}
	protected boolean insertGPS(GPSPoint gpspoint) {
		boolean inserted = false;
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		} else { inserted = false; }
		return inserted;
	
	}
	public boolean insert(String time, String latitude, String longitude, String elevation) {
		GPSPoint gpspoint = new GPSPoint(GPSDataConverter.toSeconds(time), Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(elevation));
		boolean sattInn = insertGPS(gpspoint);
		return sattInn;
	}
	public void print() {
		for (int i = 0; i < gpspoints.length; i++) {
			int time = gpspoints[i].getTime();
			double latitude = gpspoints[i].getLatitude();
			double longitude = gpspoints[i].getLongitude();
			double elevation = gpspoints[i].getElevation();
			System.out.println(time + " " + latitude + " " + longitude + " " + elevation);
		}
	}
}

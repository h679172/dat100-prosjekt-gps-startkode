package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {
	 private GPSPoint[] gpspoints;
	
	public static void main(String[] args) {
		GPSPoint gpspoint1 = new GPSPoint(5,12.0,4.0,9.0); 
		GPSPoint gpspoint2 = new GPSPoint(2,23.0,6.0,2.0);
	
		GPSData gpsData = new GPSData(2);
		
		gpsData.insertGPS(gpspoint1);
        gpsData.insertGPS(gpspoint2);

        gpsData.print();
        gpsData.print();
	}
	 public void GPSinserter(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		 
	 }
	
}

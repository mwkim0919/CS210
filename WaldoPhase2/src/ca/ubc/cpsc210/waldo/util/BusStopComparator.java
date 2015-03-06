package ca.ubc.cpsc210.waldo.util;

import java.util.Comparator;

import ca.ubc.cpsc210.waldo.model.BusStop;

/**
 * Comparator class for sorting a set of Bus Stops by distance from a given LatLon.
 * 
 * Used by the static Collections.sort(Collection, Comparator) method. Calculates the distance between
 * the LatLon coordinates of a particular LatLon and one of the BusStop in the set of interest. 
 * Provides methods for comparing two BusStops by their respective distance from the LatLon of interest.
 * @author Jagdeep Gill
 * 
 */
public class BusStopComparator implements Comparator<BusStop>{

	private LatLon latLonToCompareTo;
	
	/**
	 * Constructor
	 * @author Jagdeep Gill
	 * @param latLonToCompareTo The LatLon from which distances of particular BusStops in the set are calculated.
	 */
	public BusStopComparator(LatLon latLonToCompareTo) {
		super();
		this.latLonToCompareTo = latLonToCompareTo;
	}

	/**
	 * Compares two BusStop by distance from a LatLon of interest.
	 * @author Jagdeep Gill
	 * @param stop1 A bus stop object
	 * @param stop2 A bus stop object
	 * @return Returns a boolean from comparing the distances of each BusStop from the LatLon of interest.
	 * 			Returns -1 when the stop1 is closer than stop2; returns 1 when stop1 is farther than stop2;
	 * 			returns 0 when the stop1 and stop2 are equidistant.
	 */
	@Override
	public int compare(BusStop stop1, BusStop stop2) {
		Double distance1 = LatLon.distanceBetweenTwoLatLon(latLonToCompareTo, stop1.getLatLon());
		Double distance2 = LatLon.distanceBetweenTwoLatLon(latLonToCompareTo, stop2.getLatLon());
		Integer comparison = this.compare(distance1, distance2);
		return comparison;
	}
	
	/**
	 * Compares two double inputs for relative magnitude.
	 * @author Jagdeep Gill
	 * @param a A double input
	 * @param b A double input
	 * @return a boolean for the comparison. -1 if a < b. 1 if a > b and 0 otherwise.
	 */
	private static int compare(Double a, Double b) {
	    return a < b ? -1
	         : a > b ? 1
	         : 0;
	  }
	
}

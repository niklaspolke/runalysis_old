package de.npo.runalysis.common.tcx;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.npo.runalysis.common.Trackpoint;

/**
 * Copyright (C) 2015 Niklas Polke<br/>
 * <br/>
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.<br/>
 * <br/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * @author Niklas Polke
 */
public class TcxTrackpoint implements Trackpoint {

	public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	public static final String DEGREES_FORMAT = "##0.0000000";

	private final DateFormat DATE_TIME_FORMATTER = new SimpleDateFormat(DATE_TIME_FORMAT);
	private final DecimalFormat DEGREES_FORMATTER = new DecimalFormat(DEGREES_FORMAT);

	private final Date time;
	private final double longitudeDegrees;
	private final double latitudeDegrees;
	private final int altitudeMeters;
	private final double distanceMeters;

	public TcxTrackpoint(final Date time, final double longitudeDegrees, final double latitudeDegrees, final int altitudeMeters,
			final double distanceMeters) {
		if (time != null) {
			this.time = (Date) time.clone();
		} else {
			this.time = null;
		}
		this.longitudeDegrees = longitudeDegrees;
		this.latitudeDegrees = latitudeDegrees;
		this.altitudeMeters = altitudeMeters;
		this.distanceMeters = distanceMeters;
	}

	@Override
	public Date getTime() {
		return time;
	}

	@Override
	public double getLongitudeDegrees() {
		return longitudeDegrees;
	}

	@Override
	public double getLatitudeDegrees() {
		return latitudeDegrees;
	}

	@Override
	public int getAltitudeMeters() {
		return altitudeMeters;
	}

	public double getDistanceMeters() {
		return distanceMeters;
	}

	@Override
	public String toString() {
		return DATE_TIME_FORMATTER.format(time) + " ( " + DEGREES_FORMATTER.format(longitudeDegrees) + " , "
				+ DEGREES_FORMATTER.format(latitudeDegrees) + " , " + altitudeMeters + " , " + distanceMeters + " )";
	}

	@Override
	public int compareTo(Trackpoint other) {
		if (other == null) {
			throw new NullPointerException("Trackpoint.compareTo(null)");
		} else {
			if (getTime() == null && other.getTime() == null) {
				return 0;
			} else if (getTime() == null) {
				return -1;
			} else if (other.getTime() == null) {
				return 1;
			} else {
				return getTime().compareTo(other.getTime());
			}
		}
	}
}
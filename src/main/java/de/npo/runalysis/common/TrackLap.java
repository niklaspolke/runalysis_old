package de.npo.runalysis.common;

import java.util.Date;

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
public class TrackLap implements Comparable<TrackLap> {

	private Date startTime;

	private double durationInSeconds;

	private double distanceInMeters;

	public TrackLap() {
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(final Date startTime) {
		if (startTime != null) {
			this.startTime = (Date) startTime.clone();
		} else {
			this.startTime = null;
		}
	}

	public double getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(final double durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public double getDistanceInMeters() {
		return distanceInMeters;
	}

	public void setDistanceInMeters(final double distanceInMeters) {
		this.distanceInMeters = distanceInMeters;
	}

	@Override
	public int compareTo(TrackLap other) {
		if (other == null) {
			throw new NullPointerException("Lap.compareTo(null)");
		} else {
			if (getStartTime() == null && other.getStartTime() == null) {
				return 0;
			} else if (getStartTime() == null) {
				return -1;
			} else if (other.getStartTime() == null) {
				return 1;
			} else {
				return getStartTime().compareTo(other.getStartTime());
			}
		}
	}
}
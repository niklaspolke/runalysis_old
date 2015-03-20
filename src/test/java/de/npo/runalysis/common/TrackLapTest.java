package de.npo.runalysis.common;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
public class TrackLapTest {

	private static final double DELTA_ACCEPTED = 0.001;

	private static final Date TEST1_DATE = new Date();
	private static final double TEST1_DURATION = 123.4;
	private static final double TEST1_DISTANCE = 34.5;

	// not equals TEST1_DATE, see setupClass
	private static final Date TEST2_DATE = new Date();
	private static final double TEST2_DURATION = 654.4;
	private static final double TEST2_DISTANCE = 88.5;

	private TrackLap test1Lap;

	@BeforeClass
	public static void setupClass() {
		TEST2_DATE.setTime(TEST1_DATE.getTime() + 8000);
	}

	@Before
	public void setup() {
		test1Lap = new TrackLap();
		test1Lap.setStartTime(TEST1_DATE);
		test1Lap.setDurationInSeconds(TEST1_DURATION);
		test1Lap.setDistanceInMeters(TEST1_DISTANCE);
	}

	@Test
	public void startTime() {
		assertEquals(TEST1_DATE, test1Lap.getStartTime());

		test1Lap.setStartTime(TEST2_DATE);
		assertEquals(TEST2_DATE, test1Lap.getStartTime());
	}

	@Test
	public void durationInSeconds() {
		assertEquals(TEST1_DURATION, test1Lap.getDurationInSeconds(), DELTA_ACCEPTED);

		test1Lap.setDurationInSeconds(TEST2_DURATION);
		assertEquals(TEST2_DURATION, test1Lap.getDurationInSeconds(), DELTA_ACCEPTED);
	}

	@Test
	public void distanceInMeters() {
		assertEquals(TEST1_DISTANCE, test1Lap.getDistanceInMeters(), DELTA_ACCEPTED);

		test1Lap.setDistanceInMeters(TEST2_DISTANCE);
		assertEquals(TEST2_DISTANCE, test1Lap.getDistanceInMeters(), DELTA_ACCEPTED);
	}

	@Test(expected = NullPointerException.class)
	public void compareTo_nullPointsInFront() {
		TrackLap nullLap = null;
		test1Lap.compareTo(nullLap);
		fail();
	}

	@Test
	public void compareTo_nullTimesInFront() {
		TrackLap lapNoStartTime = new TrackLap();
		lapNoStartTime.setStartTime(null);
		assertTrue(test1Lap.compareTo(lapNoStartTime) > 0);
		assertTrue(lapNoStartTime.compareTo(test1Lap) < 0);
	}

	@Test
	public void compareTo_equalTimes() {
		TrackLap lapEqualStartTime = new TrackLap();
		lapEqualStartTime.setStartTime(TEST1_DATE);
		assertTrue(test1Lap.compareTo(lapEqualStartTime) == 0);
		assertTrue(lapEqualStartTime.compareTo(test1Lap) == 0);
	}

	@Test
	public void compareTo_differentTimes() {
		TrackLap lapLaterStartTime = new TrackLap();
		lapLaterStartTime.setStartTime(TEST2_DATE);
		assertTrue(test1Lap.compareTo(lapLaterStartTime) < 0);
		assertTrue(lapLaterStartTime.compareTo(test1Lap) > 0);
	}
}
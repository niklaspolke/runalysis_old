package de.npo.runalysis.common.tcx;

import static org.junit.Assert.*;

import java.util.Date;

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
public class TcxTrackpointTest {

	private static final double DELTA_ACCEPTED = 0.001;

	private static final Date TEST1_DATE = new Date();
	private static final double TEST1_LONGITUDE = 123.0;
	private static final double TEST1_LATITUDE = 432.0;
	private static final int TEST1_ALTITUDE = 18;
	private static final double TEST1_DISTANCE = 34.5;

	private static TcxTrackpoint test1TcxTrackpoint;

	@BeforeClass
	public static void setup() {
		test1TcxTrackpoint = new TcxTrackpoint(TEST1_DATE, TEST1_LONGITUDE, TEST1_LATITUDE, TEST1_ALTITUDE, TEST1_DISTANCE);
	}

	@Test
	public void time() {
		assertEquals(TEST1_DATE, test1TcxTrackpoint.getTime());
		assertNotSame(TEST1_DATE, test1TcxTrackpoint.getTime());
	}

	@Test
	public void timeNull() {
		TcxTrackpoint testNullTime = new TcxTrackpoint(null, TEST1_LONGITUDE, TEST1_LATITUDE, TEST1_ALTITUDE, TEST1_DISTANCE);
		assertNull(testNullTime.getTime());
		assertEquals(TEST1_LONGITUDE, testNullTime.getLongitudeDegrees(), DELTA_ACCEPTED);
		assertEquals(TEST1_LATITUDE, testNullTime.getLatitudeDegrees(), DELTA_ACCEPTED);
		assertEquals(TEST1_ALTITUDE, testNullTime.getAltitudeMeters());
		assertEquals(TEST1_DISTANCE, testNullTime.getDistanceMeters(), DELTA_ACCEPTED);
	}

	@Test
	public void longitude() {
		assertEquals(TEST1_LONGITUDE, test1TcxTrackpoint.getLongitudeDegrees(), DELTA_ACCEPTED);
	}

	@Test
	public void latitude() {
		assertEquals(TEST1_LATITUDE, test1TcxTrackpoint.getLatitudeDegrees(), DELTA_ACCEPTED);
	}

	@Test
	public void altitude() {
		assertEquals(TEST1_ALTITUDE, test1TcxTrackpoint.getAltitudeMeters());
	}

	@Test
	public void distance() {
		assertEquals(TEST1_DISTANCE, test1TcxTrackpoint.getDistanceMeters(), DELTA_ACCEPTED);
	}

	@Test(expected = NullPointerException.class)
	public void compareTo_nullPointsInFront() {
		TcxTrackpoint nullPoint = null;
		test1TcxTrackpoint.compareTo(nullPoint);
		fail();
	}

	@Test
	public void compareTo_nullTimesInFront() {
		TcxTrackpoint pointNoTime = new TcxTrackpoint(null, TEST1_LONGITUDE, TEST1_LATITUDE, TEST1_ALTITUDE, TEST1_DISTANCE);
		assertTrue(test1TcxTrackpoint.compareTo(pointNoTime) > 0);
		assertTrue(pointNoTime.compareTo(test1TcxTrackpoint) < 0);
	}

	@Test
	public void compareTo_equalTimes() {
		TcxTrackpoint pointEqualTime = new TcxTrackpoint(TEST1_DATE, TEST1_LONGITUDE, TEST1_LATITUDE, TEST1_ALTITUDE, TEST1_DISTANCE);
		assertTrue(test1TcxTrackpoint.compareTo(pointEqualTime) == 0);
		assertTrue(pointEqualTime.compareTo(test1TcxTrackpoint) == 0);
	}

	@Test
	public void compareTo_differentTimes() {
		TcxTrackpoint pointEarlierTime = new TcxTrackpoint(new Date(TEST1_DATE.getTime() - 1000), TEST1_LONGITUDE, TEST1_LATITUDE,
				TEST1_ALTITUDE, TEST1_DISTANCE);
		assertTrue(test1TcxTrackpoint.compareTo(pointEarlierTime) > 0);
		assertTrue(pointEarlierTime.compareTo(test1TcxTrackpoint) < 0);
	}
}
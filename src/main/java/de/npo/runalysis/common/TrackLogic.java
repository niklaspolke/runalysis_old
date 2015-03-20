package de.npo.runalysis.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
public interface TrackLogic {

	void handleNewTrackpoint(TrackPoint trackPoint);

	Map<Date, Double> calcPaces(double timeInterval);

	List<TrackLap> calcAutolaps(double lapLength);
}
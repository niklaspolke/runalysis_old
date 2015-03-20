package de.npo.runalysis.common.tcx;

import java.util.List;

import de.npo.runalysis.common.TrackLap;
import de.npo.runalysis.common.TrackLogic;

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
public interface TcxTrackLogic extends TrackLogic {

	void handleLap(TrackLap trackLap);

	List<TrackLap> getLaps();
}
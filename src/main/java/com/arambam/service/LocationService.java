package com.arambam.service;

import com.arambam.dto.AddLocationRequest;
import org.wololo.geojson.Point;

public interface LocationService {
	void saveLocation(AddLocationRequest request);

	boolean isLocationWithinArea(String areaCode, Point point);
}

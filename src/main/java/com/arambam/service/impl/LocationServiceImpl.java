package com.arambam.service.impl;

import com.arambam.dto.AddLocationRequest;
import com.arambam.model.Location;
import com.arambam.model.dao.LocationDao;
import com.arambam.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.wololo.geojson.Geometry;
import org.wololo.geojson.Point;
import org.wololo.jts2geojson.GeoJSONReader;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LocationServiceImpl implements LocationService {

	private final LocationDao locationDao;

	@Override
	public void saveLocation(AddLocationRequest request) {
		Location location = new Location();
		location.setGeometry(toJtsGeometry(request.getGeometry()));
		location.setName(request.getName());
		locationDao.save(location);
	}

	@Override
	public boolean isLocationWithinArea(String name, Point point) {
		return locationDao.existsWithin((com.vividsolutions.jts.geom.Point) toJtsGeometry(point), name) > 0;
	}

	private static com.vividsolutions.jts.geom.Geometry toJtsGeometry(Geometry geoJson) {
		return new GeoJSONReader().read(geoJson);
	}

}

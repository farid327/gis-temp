package com.arambam.api;

import com.arambam.dto.SearchLocationRequest;
import com.arambam.dto.SearchLocationResponse;
import com.arambam.dto.GeneralResponse;
import com.arambam.dto.AddLocationRequest;
import com.arambam.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.wololo.geojson.Point;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/locations")
@RequiredArgsConstructor
@RestController
public class LocationResource {

	private final LocationService locationService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse> saveLocation(@RequestBody AddLocationRequest request) {
		locationService.saveLocation(request);
		return new ResponseEntity(new GeneralResponse(true), HttpStatus.OK);
	}

	@PostMapping(path = "/exists", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneralResponse> existsLocation(@RequestBody SearchLocationRequest request) {
		Point point = new Point(new double[] { request.getLon(), request.getLat() });
		boolean exists = locationService.isLocationWithinArea(request.getName(), point);
		return new ResponseEntity(new SearchLocationResponse(exists), HttpStatus.OK);
	}

}

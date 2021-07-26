package com.arambam.model.dao;

import com.arambam.model.Location;
import com.vividsolutions.jts.geom.Point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationDao extends JpaRepository<Location, Long> {

	@Query("SELECT count(l) FROM Location l WHERE within(:point, l.geometry) = TRUE AND l.name =:name")
	Long existsWithin(@Param("point") Point point, @Param("name") String name);

}

package com.arambam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;

@Data
@Table(name = "locations")
@Entity
public class Location {

	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@NotNull
	@Column(name = "geometry")
	private Geometry geometry;

}

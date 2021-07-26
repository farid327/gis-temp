delete from locations;

INSERT INTO locations ("id","name", "geometry") VALUES (4,'area1',ST_GeomFromText('POLYGON((18 54,18 55,19 55,19 54,18 54))'));

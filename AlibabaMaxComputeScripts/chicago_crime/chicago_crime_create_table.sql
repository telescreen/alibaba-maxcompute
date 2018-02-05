CREATE TABLE chicago_crime (
	id BIGINT,
	casenumber STRING,
	createdate STRING,
	block STRING,
	iucr STRING,
	primarytype STRING,
	description STRING,
	locationdescription STRING,
	arrest BOOLEAN,
	domestic BOOLEAN,
	beat BIGINT,
	district DOUBLE,
	ward DOUBLE,
	communityarea DOUBLE,
	fbicode STRING,
	xcoordinate DOUBLE,
	ycoordinate DOUBLE,
	year BIGINT,
	updatedon STRING,
	lattitude DOUBLE,
	longtitude DOUBLE,
	locationname STRING
)
COMMENT 'Chicago Crime Data'
LIFECYCLE 100000;
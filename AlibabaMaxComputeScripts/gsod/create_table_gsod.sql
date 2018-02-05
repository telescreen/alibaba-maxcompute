CREATE TABLE gsod (
STN BIGINT,
WBAN BIGINT,
MODA BIGINT,
TEMPERATURE DOUBLE,
COUNTTEMP BIGINT,
SLP DOUBLE,
COUNTSLP BIGINT,
STP DOUBLE ,
COUNTSTP BIGINT,
VISIB DOUBLE,
COUNTVISIB DOUBLE,
WDSP DOUBLE,
COUNTWDSP DOUBLE,
MXSPD DOUBLE,
GUST DOUBLE,
MAXTEMP DOUBLE,
FLAGMAX STRING,
MINTEMP DOUBLE,
FLAGMIN STRING,
PRCP DOUBLE,
FLAGPRCP DOUBLE,
SNDP DOUBLE,
FRSHTT BIGINT
) PARTITIONED BY (YEAR BIGINT);
CREATE TABLE IF NOT EXISTS hacker_news (
    title STRING,
    url STRING,
    text STRING,
    dead STRING,
    author STRING,
    score BIGINT,
    time BIGINT,
    articletype STRING,
    sid BIGINT,
    parent BIGINT,
    descendants BIGINT,
    ranking STRING,
    deleted STRING,
    timestamp0 DATETIME
);

CREATE EXTERNAL TABLE IF NOT EXISTS hacker_news_external (
    url STRING,
    title STRING,
    text STRING,
    dead STRING,
    author STRING,
    score BIGINT,
    time BIGINT,
    articletype STRING,
    sid BIGINT,
    parent BIGINT,
    descendants BIGINT,
    ranking STRING,
    deleted STRING,
    timestamp0 DATETIME
)
STORED BY 'com.aliyun.odps.CsvStorageHandler'
LOCATION 'oss://<AccessID>:<AccessKey>@vpc100-oss-ap-southeast-1.aliyuncs.com/<bucket name>/<path>';
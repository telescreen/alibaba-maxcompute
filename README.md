# alibaba-maxcompute
Scripts and MapReduce Application for Alibaba MaxCompute

This is an demo application of using Alibaba Cloud's MaxCompute to do data analysis. Currently, the directory is divided 
into 2 parts
* Scripts parts in `AlibabaMaxComputeScripts@ directory
* MapReduce Java Application in `MRDemo`

### How to use

Below are steps to run the demo

##### Step 1: Install MaxCompute Studio
MaxCompute Studio is an Intellij Plugin to communicate with Alibaba MaxCompute. Details about MaxCompute Studio and 
install manuals can be referenced at [Plugin Homepage](https://plugins.jetbrains.com/plugin/9193-maxcompute-studio).

##### Step 2: Configuration
This project includes a setting file stored at `AlibabaMaxComputeScripts/maxcompute.ini`
In order to run scripts and MapReduce in MaxCompute cluster, you first need to create a cluster. Details about how to 
create a cluster can be referenced at [Official Documentations](https://www.alibabacloud.com/help/doc-detail/27803.htm).
After creating a cluster, the next step is to filled your `AccessID` and `AccessKey` to setting file `maxcompute.ini`

```bash
project_name = <Project Name>
access_id = <Access ID>
access_key = <Access Key>
end_point = <End point api>
# For Singapore Region, use end_point = http://service.ap-southeast-1.maxcompute.aliyun.com/api
```

`end_point` might varies depending on the region where you created your MaxCompute cluster. Details about regions can be
referenced at [Access Domain and Data Centers](https://www.alibabacloud.com/help/doc-detail/34951.htm) of 
Official Documentations

After filling `maxcompute.ini`, Open MaxCompute Studio (Intellij Menu *View* > *Tool Windows* > *+Project Explorer*). Add
project and choose `maxcompute.ini` as settings (Details please refer to [Plugin Homepage](https://plugins.jetbrains.com/plugin/9193-maxcompute-studio))

##### Step 3: Upload data to OSS and Synchronize data to MaxCompute storage
This repository provided scripts to create and sync data of following data sets

| DataSets          | Description                                                                           | Links                                                     |
|-------------------|---------------------------------------------------------------------------------------|-----------------------------------------------------------|
| Ambulance vehicle | An example dataset used for demo purpose by Alibaba Cloud's MaxCompute documentations |  https://www.alibabacloud.com/help/doc-detail/45389.htm   |
|  Chicago Crime    | Famous Chicago Crime Datasets                                                         | https://www.kaggle.com/currie32/crimes-in-chicago/data    |
| Hackernews        | All link data of hackernews                                                           | https://cloud.google.com/bigquery/public-data/hacker-news |
| movielens         | Famous Movie Lens data                                                                | https://grouplens.org/datasets/movielens/                 |
| gsod              | Data of earth temperature collected by sensors setup at various places                | ftp://ftp.ncdc.noaa.gov/pub/data/gsod/                    |

You might need to download about data and put them into your OSS.

I provide some scripts to sync data from OSS data source to MaxCompute storage. Details can be found under each data
subdirectory. Those scripts can be imported using [DataWorks](https://www.alibabacloud.com/help/product/30254.htm) *Data Integration*

Some analysis script samples are also included in each dataset's subdirectory

### Happy hacking! ### 
package com.study.hadoopPro;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class hadoop_upload_2 {			//copyFromLocalFile接口上传文件(基于FileSystem类)
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		Path src = new Path("/home/jack/input/data.txt");		//source源地址
		//---------------------------------源地址与目的地址互换即下载文件---------------------------------
		Path dst = new Path("/mydir/test4.txt");		//destination目的地址
		
		fs.copyFromLocalFile(src, dst);
		
		fs.close();
	}
}

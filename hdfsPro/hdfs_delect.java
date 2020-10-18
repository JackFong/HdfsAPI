package com.study.hadoopPro;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class hadoop_delect {		//删除文件
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		fs.delete(new Path("/mydir/test4.txt"));
		
		fs.close();
		
		System.out.println("文件删除成功");
	}
}

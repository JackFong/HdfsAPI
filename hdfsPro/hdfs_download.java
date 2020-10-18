package com.study.hadoopPro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class hadoop_download {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		InputStream is = fs.open(new Path("/mydir/test.txt"));		//由FileSystem.open()返回FSDataInputStream对象，根据这个对象创建输入流
		
		OutputStream os = new FileOutputStream("/home/jack/文档/test_output.txt");		//实例化FileOutputStream得到输出流
		
		IOUtils.copyBytes(is, os, 1024);
		
		is.close();
		os.close();
		
		fs.close();
	}
}

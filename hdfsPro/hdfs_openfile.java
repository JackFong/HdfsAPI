package com.study.hadoopPro;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class hadoop_openfile {		//文件读取（FSDataInputStream）
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		Path path = new Path("/mydir/test.txt");
		
		FSDataInputStream is = fs.open(path);
		
		String str = null;			//把数据先存放缓冲区，再从缓冲区读取数据
		while((str = is.readLine()) != null) {		//readLine() 读取数据，读取完返回null
			System.out.println(str);
		}
		
		is.close();
	}
}

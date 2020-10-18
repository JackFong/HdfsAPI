package com.study.hadoopPro;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class hadoop_upload {      //流拷贝上传文件
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		InputStream is = new FileInputStream("/home/jack/文档/test10.4.txt");    //创建输入流
		
		OutputStream os = fs.create(new Path("/mydir/test1.txt"));       //由输入流得到输出流,上传文件并重新命名，有该文件名时进行覆盖
		
		IOUtils.copyBytes(is , os , 1024);		//使用工具类进行复制，1024（1kb）为缓冲区大小（buffer）
		
		is.close();
		os.close();
		
		fs.close();
		
		
	}
}

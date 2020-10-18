package com.study.hadoopPro;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class hadoop_detail {		//查看文件详细信息
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		
		URI uri = new URI("hdfs://node1:8020");
		
		FileSystem fs = FileSystem.get(uri,conf,"jack");
		
		Path path = new Path("/mydir/test1.txt");		//指定要查看文件的路径		
		FileStatus fileStatus = fs.getFileLinkStatus(path);		//获取路径的状态
		
		long blockSize = fileStatus.getBlockSize();				//由该状态获取数据块大小
		System.out.println("该文件数据块大小：" + blockSize);
		
		long fileSize = fileStatus.getLen();			//由该状态获取文件的大小
		System.out.println("该文件大小：" + fileSize + "字节");

		String fileOwner = fileStatus.getOwner();		//由该状态获取文件的拥有者
		System.out.println("该文件的拥有者：" + fileOwner);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		//实例化对象，定义时间格式	（M为月份，m为小时）	
		long accessTime = fileStatus.getAccessTime();				//获取该状态的最近访问时间
		System.out.println("该文件的最近访问时间：" + sdf.format(new Date(accessTime)));
		long modifyTime = fileStatus.getModificationTime();			//获取修改的时间（最后一次修改的时间）
		System.out.println("该文件最后一次修改的时间：" + sdf.format(new Date(modifyTime)));
		
		fs.close();	
	}
}

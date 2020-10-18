package com.study.hadoopPro;

import java.net.URI;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.*;

public class hadoop     //文件写入（FSDataOutputStream）
{
    public static void main( String[] args ) throws Exception
    {
    	Configuration conf = new Configuration(); 	//实例化Configuration
           
    	URI uri = new URI("hdfs://node1:8020");     //配置NameNode地址，跟core-site.xml配置一样
    	
    	FileSystem fs = FileSystem.get(uri,conf,"jack");    //指定用户名，获取FileSystem对象，简命名为fs，get后面参数顺序不能改变
    	
    	Path dfs = new Path("/mydir/test1.txt");		//定义要创建的新文件
    	
    	FSDataOutputStream os = fs.create(dfs,true);	//输出流，FSDataOutputStream：api写入类，hadoop特有
    	
    	os.writeBytes("This is a test");		//数据先被写入缓冲区，再被切分成一个个数据包
    	
    	os.close();
    	//关闭输出流、和FileSystem客户端(fs)
    	fs.close();
    	
    	System.out.println("文件创建成功");
    }
}
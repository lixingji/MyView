package com.example.myview;

import java.util.ArrayList;
import java.util.List;


public class MyDataSource {

	public static List<String> getDataSource(){
		//
		List<String> list=new ArrayList<String>();
		list.add("广州");
		list.add("深圳");
		list.add("香港");
		list.add("北京");
		list.add("上海");
		
		return list;
	}
}

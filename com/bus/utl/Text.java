package com.bus.utl;

import java.io.File;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBHelper b= new DBHelper();
		System.out.println(b);
	}

	public void searchAll(File f){
		if (f.isDirectory()){
			System.out.println("目录下的文件有-----");
			File[] list = f.listFiles();
			for (File file : list){
				searchAll(file);
			}
		}else {
			System.out.println(f.getName());
		}
	}
}

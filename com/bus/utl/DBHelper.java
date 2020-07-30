package com.bus.utl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	/*private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static DruidDataSource dateSource;
	static{
		ResourceBundle bundle=ResourceBundle.getBundle("db");
		driver=bundle.getString("driver");
		url=bundle.getString("url");
		user=bundle.getString("user");
		password=bundle.getString("password");
		
		dateSource=new DruidDataSource();
		dateSource.setDriverClassName(driver);
		dateSource.setUrl(url);
		dateSource.setUsername(user);
		dateSource.setPassword(password);
		//1、加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败！");
		}
	}*/
	//------oracle--得到连接------
    private static String driver_name = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@10.10.10.17:1521:orcl";
	private static String user = "scott";
	private static String password ="tiger";

	static{
		//1、加载驱动
		try {
			Class.forName(driver_name);
			System.out.println("---oracle ok---");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败！");
		}
	}


	public static Connection getConnection() throws SQLException{
		//2、得到连接
		//Connection conn=DriverManager.getConnection(url,user,password);     原生的方法
		//return dateSource.getConnection();   //连接池连接
		//oracle连接
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}
	

}

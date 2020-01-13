package lesson29;

import java.sql.*;


public class TestJDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.建立连接
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//3.创建preparedStament对象
		String sql="insert into emp(ename,job,sal) values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		// 给占位符？赋值
		pst.setString(1, "hello");
		pst.setString(2, "程序员");
		pst.setDouble(3, 10240);
		
		//4.执行sql语句
		int x=pst.executeUpdate();
		//5.处理结果集
		if(x>0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败！");
		}
		//6.关闭数据库
		pst.close();
		con.close();
		
		
		
		
		

	}

}

package lesson29;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class homework {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu", "root", "root");
		List<User> list=new ArrayList<>();
		list.add(new User("张三","888888","zhangsan@126.com",new Date(1986-1900,10-1,11)));
		for(User u:list){
			String sql="insert into user(name,pwd,email,birthday) values(?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setString(2, u.getPwd());
			pst.setString(3, u.getEmail());
			pst.setDate(4,u.getBirthday());
			System.out.println(pst.executeUpdate());
			pst.close();
		}
		
		
		/*String sql="insert into user(name,pwd,email,birthday) values(?,?,?,?),(?,?,?,?),(?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, "张三");
		pst.setString(2, "888888");
		pst.setString(3, "zhangsan@126.com");
		Date date=new Date(1986-1900,10-1,11);
		pst.setDate(4,date);
		
		pst.setString(5, "李四");
		pst.setString(6, "999999");
		pst.setString(7, "lisi@126.com");
		Date date1=new Date(1988-1900,10-1,23);
		pst.setDate(8,date1);
		pst.setString(9, "王五");
		pst.setString(10, "777777");
		pst.setString(11, "wangwu@126.com");
		Date date2=new Date(1990-1900,9-1,11);
		pst.setDate(12,date2);
		
		int x=pst.executeUpdate();
		System.out.println(x);
		
		String sql1="update user set birthday=CURRENT_DATE where name='张三'";
		PreparedStatement pst1=conn.prepareStatement(sql1);
		
		int x1=pst1.executeUpdate();
		System.out.println(x1);
		
		String sql2="delete from user where name='李四'";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		
		int x2=pst2.executeUpdate();
		System.out.println(x2);*/
		
		
		
		
		
		conn.close();
	}

}

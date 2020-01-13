package lesson29;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestJDBC4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.建立连接
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//3.创建preparedStament对象
		String sql="select * from emp where ename like ? ";
		PreparedStatement pst=con.prepareStatement(sql);
		// 给占位符？赋值
		pst.setString(1, "%m%");
		
		//4.执行sql语句
		ResultSet rs=pst.executeQuery();
		List<Emp> list=new ArrayList<>();
		//5.处理结果集
		while(rs.next()){
			int no=rs.getInt("empno");
			String name=rs.getString("ename");
			Date date=rs.getDate("hiredate");
			double sal=rs.getDouble("sal");
			
			Emp em=new Emp(no,name,name, date,sal);
			list.add(em);
			
		}
		//遍历集合
		for(Emp emp:list){
			System.out.println(emp.getEname()+":"+emp.getHiredate());
		}
		//6.关闭数据库
		pst.close();
		con.close();
		
		
		
		
		

	}

}

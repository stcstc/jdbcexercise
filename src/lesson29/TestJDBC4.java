package lesson29;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestJDBC4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.��������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//3.����preparedStament����
		String sql="select * from emp where ename like ? ";
		PreparedStatement pst=con.prepareStatement(sql);
		// ��ռλ������ֵ
		pst.setString(1, "%m%");
		
		//4.ִ��sql���
		ResultSet rs=pst.executeQuery();
		List<Emp> list=new ArrayList<>();
		//5.��������
		while(rs.next()){
			int no=rs.getInt("empno");
			String name=rs.getString("ename");
			Date date=rs.getDate("hiredate");
			double sal=rs.getDouble("sal");
			
			Emp em=new Emp(no,name,name, date,sal);
			list.add(em);
			
		}
		//��������
		for(Emp emp:list){
			System.out.println(emp.getEname()+":"+emp.getHiredate());
		}
		//6.�ر����ݿ�
		pst.close();
		con.close();
		
		
		
		
		

	}

}

package lesson29;

import java.sql.*;


public class TestJDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.��������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//3.����preparedStament����
		String sql="insert into emp(ename,job,sal) values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		// ��ռλ������ֵ
		pst.setString(1, "hello");
		pst.setString(2, "����Ա");
		pst.setDouble(3, 10240);
		
		//4.ִ��sql���
		int x=pst.executeUpdate();
		//5.��������
		if(x>0){
			System.out.println("����ɹ�");
		}else{
			System.out.println("����ʧ�ܣ�");
		}
		//6.�ر����ݿ�
		pst.close();
		con.close();
		
		
		
		
		

	}

}

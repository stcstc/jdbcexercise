package lesson29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestJdbc2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*  1.����JDBC��������
			2.��������URL
			3.��������
			4.����Statement����
			5.ִ�в�ѯ�����
			6.�������
			7.�ر�����
		*/
		//1.����jdbc������mysql���ݿ����������com.mysql.jdbc.Driver
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������URL,mysql �ĵ�ַ��ʽ��jdbc:mysql://<��������IP>:port/<���ݿ���>
		//3.��������Connection
		Connection qiao=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//4.����Statement����
		Statement car=qiao.createStatement();
		//5.ִ�в�ѯ�����
		String sql="SELECT * From  emp";
		
		//6.�����������
		ResultSet rs=car.executeQuery(sql);
		while(rs.next()){
			 int eno=rs.getInt("empno");
			 String name=rs.getString("ENAME");
			 String job=rs.getString("job");
			 double sal=rs.getDouble("SAL");
			 Date hiredate=rs.getDate("HIREDATE");
			 
			 //����Ա�����󣬸�ֵ
			 Emp emp=new Emp();
			 emp.setEmpno(eno);
			 emp.setEname(name);
			 emp.setHiredate(hiredate);
			 emp.setSal(sal);
			 emp.setJob(job);
			 
			 System.out.println("Ա������"+emp.getEname()+",н��"+emp.getSal());
		}
		

		//7.�ر�����
		car.close();
		qiao.close();
		
		//��ϰ���ӿ���̨����Ա����ţ� ѡ��1,ɾ��Ա����ѡ��2���޸�Ա����ѡ��3 ������Ա��
		/*   ��ӭ����Ա������ϵͳ
		 *    1��ɾ��Ա��
		 *    2���޸�Ա��
		 *    3 ������Ա��
		 *   ��������Ĳ�����1
		 *      ������Ա����ţ�7785
		 *      ɾ���ɹ���/ɾ��ʧ�ܣ�
		 *   
		 * 
		 * */
	}

}

package lesson29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.����jdbc������mysql���ݿ����������com.mysql.jdbc.Driver
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������URL,mysql �ĵ�ַ��ʽ��jdbc:mysql://<��������IP>:port/<���ݿ���>
		//3.��������Connection
		Connection qiao=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//4.����Statement����
		Statement car=qiao.createStatement();
		
	 while(true){	
			System.out.println("*****************��ӭ����Ա������ϵͳ******************");
			System.out.println(" *    1��ɾ��Ա��");
			System.out.println(" *    2���޸�Ա��");
			System.out.println(" *    3 ������Ա��");
			System.out.println("*     4 ����ѯԱ����4.1��Ա����Ų�ѯ  4.2����ģ����ѯ ��4.3��ѯ����Ա��");
			System.out.println(" *    0 ���˳�ϵͳ");
			
			System.out.println("��������Ĳ�����");
			Scanner  sc=new Scanner(System.in);
			String in=sc.next();
			//�ж��û�����Ĳ�����
			if("1".equals(in)){
				System.out.println("������Ҫɾ����Ա����ţ�");
				String empno=sc.next();
				
				//5.ִ�в�ѯ�����
				//���ַ���ת��int��
				int no=0;
				try{
				  no=Integer.parseInt(empno);
				}catch(Exception ex){
					System.out.println("��������Ա�����Ϊ����");
				}
				String sql="delete from emp where empno="+no;
				int x=car.executeUpdate(sql);  //����ֵ������Ӱ������
				//6.�������
				if(x>0){
					System.out.println("ɾ���ɹ���");
				}else{
					System.out.println("û�и��û���ɾ��ʧ�ܣ�");
				}
				
			}
			else if("2".equals(in)){
				System.out.println("������Ҫ�޸ĵ�Ա����ţ�");
				  // 1.�޸�����  2.�޸Ĺ���  3.�޸��Ա�  ����
				String no=sc.next();
				System.out.println("��������Ҫ�޸ĵ���Ϣ������1.�޸�����  2.�޸Ĺ���  3.�޸��Ա�  ����");
				String op=sc.next();
				//�жϲ���
				if("1".equals(op)){
					System.out.println("��������������");
					String name=sc.next();
					String  sql="update emp set ename= '"+name+"'  where empno="+no;
					int x=car.executeUpdate(sql);
					if(x>0){
						System.out.println("�����޸ĳɹ���");
					}else{
						System.out.println("�޸�ʧ�ܣ�");
					}
				}
				
				
				
				
			}
			else if("3".equals(in)){
				System.out.println("������Ҫ��ӵ�Ա����ţ�");
				
				
				
			}
			else if("0".equals(in)){
				System.out.println("ллʹ�ã��ټ���");
				//7.�ر�����
				car.close();
				qiao.close();
				break;
			}
			else{
				System.out.println("û�иò�����");
			}

	 }
	}

}

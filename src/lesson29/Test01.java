package lesson29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载jdbc驱动，mysql数据库的驱动名：com.mysql.jdbc.Driver
		Class.forName("com.mysql.jdbc.Driver");
		//2.定义连接URL,mysql 的地址格式：jdbc:mysql://<主机名或IP>:port/<数据库名>
		//3.建立连接Connection
		Connection qiao=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//4.创建Statement对象
		Statement car=qiao.createStatement();
		
	 while(true){	
			System.out.println("*****************欢迎进入员工管理系统******************");
			System.out.println(" *    1：删除员工");
			System.out.println(" *    2：修改员工");
			System.out.println(" *    3 ：增加员工");
			System.out.println("*     4 ：查询员工：4.1按员工编号查询  4.2姓名模糊查询 ，4.3查询所有员工");
			System.out.println(" *    0 ：退出系统");
			
			System.out.println("请输入你的操作：");
			Scanner  sc=new Scanner(System.in);
			String in=sc.next();
			//判断用户输入的操作数
			if("1".equals(in)){
				System.out.println("请输入要删除的员工编号：");
				String empno=sc.next();
				
				//5.执行查询或更新
				//将字符串转成int型
				int no=0;
				try{
				  no=Integer.parseInt(empno);
				}catch(Exception ex){
					System.out.println("输入有误，员工编号为整数");
				}
				String sql="delete from emp where empno="+no;
				int x=car.executeUpdate(sql);  //返回值代表受影响行数
				//6.结果处理
				if(x>0){
					System.out.println("删除成功！");
				}else{
					System.out.println("没有该用户，删除失败！");
				}
				
			}
			else if("2".equals(in)){
				System.out.println("请输入要修改的员工编号：");
				  // 1.修改姓名  2.修改工资  3.修改性别  。。
				String no=sc.next();
				System.out.println("请输入您要修改的信息操作：1.修改姓名  2.修改工资  3.修改性别  。。");
				String op=sc.next();
				//判断操作
				if("1".equals(op)){
					System.out.println("请输入您的姓名");
					String name=sc.next();
					String  sql="update emp set ename= '"+name+"'  where empno="+no;
					int x=car.executeUpdate(sql);
					if(x>0){
						System.out.println("姓名修改成功！");
					}else{
						System.out.println("修改失败！");
					}
				}
				
				
				
				
			}
			else if("3".equals(in)){
				System.out.println("请输入要添加的员工编号：");
				
				
				
			}
			else if("0".equals(in)){
				System.out.println("谢谢使用！再见！");
				//7.关闭连接
				car.close();
				qiao.close();
				break;
			}
			else{
				System.out.println("没有该操作！");
			}

	 }
	}

}

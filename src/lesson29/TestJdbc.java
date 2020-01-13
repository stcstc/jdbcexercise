package lesson29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*  1.载入JDBC驱动程序
			2.定义连接URL
			3.建立连接
			4.创建Statement对象
			5.执行查询或更新
			6.结果处理
			7.关闭连接
		*/
		//1.加载jdbc驱动，mysql数据库的驱动名：com.mysql.jdbc.Driver
		Class.forName("com.mysql.jdbc.Driver");
		//2.定义连接URL,mysql 的地址格式：jdbc:mysql://<主机名或IP>:port/<数据库名>
		//3.建立连接Connection
		Connection qiao=DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
		//4.创建Statement对象
		Statement car=qiao.createStatement();
		//5.执行查询或更新
		String sql="delete from emp where empno=8";
		int x=car.executeUpdate(sql);  //返回值代表受影响行数
		//6.结果处理
		if(x>0){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
		//7.关闭连接
		car.close();
		qiao.close();
		
		//练习：从控制台输入员工编号， 选择1,删除员工，选择2：修改员工，选择3 ：增加员工
		/*   欢迎进入员工管理系统
		 *    1：删除员工
		 *    2：修改员工
		 *    3 ：增加员工
		 *   请输入你的操作：1
		 *      请输入员工编号：7785
		 *      删除成功！/删除失败！
		 *   
		 * 
		 * */
	}

}

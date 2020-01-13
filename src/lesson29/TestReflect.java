package lesson29;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		//普通创建对象过程：编译期间加载类的信息 （静态编译）
		Emp  emp=new Emp();
		System.out.println("对象"+emp+",属性"+emp.getEname());
		
		//反射：在运行期间加载类对象的信息(动态编译)
		Emp emp2=Emp.class.newInstance();
		System.out.println("反射对象"+emp2+",属性"+emp2.getEname());
		
		//获取class文件
		Class cls=Emp.class;
		System.out.println(cls);
		//通过class文件获取字段
		Field f=cls.getDeclaredField("sal");
		String s=f.getName();
		System.out.println(s);
		//字段类型
		String st=f.getType().getName();
		System.out.println(st);
		//获取方法
		Method m_arr[]=cls.getDeclaredMethods();
		for(Method m :m_arr){
			System.out.println(m);
		}
		
	}

}

package lesson29;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		//��ͨ����������̣������ڼ���������Ϣ ����̬���룩
		Emp  emp=new Emp();
		System.out.println("����"+emp+",����"+emp.getEname());
		
		//���䣺�������ڼ������������Ϣ(��̬����)
		Emp emp2=Emp.class.newInstance();
		System.out.println("�������"+emp2+",����"+emp2.getEname());
		
		//��ȡclass�ļ�
		Class cls=Emp.class;
		System.out.println(cls);
		//ͨ��class�ļ���ȡ�ֶ�
		Field f=cls.getDeclaredField("sal");
		String s=f.getName();
		System.out.println(s);
		//�ֶ�����
		String st=f.getType().getName();
		System.out.println(st);
		//��ȡ����
		Method m_arr[]=cls.getDeclaredMethods();
		for(Method m :m_arr){
			System.out.println(m);
		}
		
	}

}

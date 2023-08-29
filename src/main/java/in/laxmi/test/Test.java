package in.laxmi.test;

import java.util.List;

import in.laxmi.dao.EmployeeDao;
import in.laxmi.dao.impl.EmployeeDaoImpl;
import in.laxmi.entity.EmployeeEntity;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDao dao = new EmployeeDaoImpl();
		
		/*List<EmployeeEntity> lst = dao.executeNamedQuery(1);
		System.out.println(lst);
		lst.forEach(System.out::println);*/
		/*List list = dao.ExecuteNamedNativeQuery(100);
		list.forEach(System.out::println);*/
		
		List<EmployeeEntity> list = dao.executeCriteriaQuery();
		list.forEach(System.out::println);
		
	}

}

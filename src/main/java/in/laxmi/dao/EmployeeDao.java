package in.laxmi.dao;

import java.util.List;

import in.laxmi.entity.EmployeeEntity;

public interface EmployeeDao {
List<EmployeeEntity> executeNamedQuery(int deptNo);
List ExecuteNamedNativeQuery(int sal);
List<EmployeeEntity> executeCriteriaQuery();
}

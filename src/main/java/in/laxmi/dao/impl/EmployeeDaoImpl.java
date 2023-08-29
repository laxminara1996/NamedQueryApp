package in.laxmi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import in.laxmi.dao.EmployeeDao;
import in.laxmi.entity.EmployeeEntity;

public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBA_CONNECTION");

	public List<EmployeeEntity> executeNamedQuery(int deptNo) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<EmployeeEntity> td = em.createNamedQuery("query1",EmployeeEntity.class);
		List<EmployeeEntity> emps = td.getResultList();
		// TODO Auto-generated method stub
		em.close();
		return emps;
	}

	public List ExecuteNamedNativeQuery(int sal) {
		EntityManager em = factory.createEntityManager();
		Query q = em.createNamedQuery("query2");
		q.setParameter(1, sal);
		List lst = q.getResultList();
		// TODO Auto-generated method stub
		em.close();
		return lst;
	}

	public List<EmployeeEntity> executeCriteriaQuery() {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> q = cb.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> r = q.from(EmployeeEntity.class);
		q.select(r).where(cb.gt(r.get("empSalary"),100));
		Query qr = em.createQuery(q);
		List<EmployeeEntity> lst = qr.getResultList();
		em.close();
		return lst;
	}
	
}

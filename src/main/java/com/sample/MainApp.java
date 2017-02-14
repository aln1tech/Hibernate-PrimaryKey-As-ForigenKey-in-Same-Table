package com.sample;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.entity.Employee;
import com.sample.persistence.HibernateUtil;

public class MainApp 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    public static void main( String[] args )
    { 
    	//addEmployee();
    	updateEmployee(2);
    }

	private static void updateEmployee(Integer employeeId) {
		Session session = getSession();
		try 		{
			Employee employee = (Employee) session.get(Employee.class, employeeId);
			LOGGER.info("{}",employee.toString());
			employee.setManager((Employee) session.get(Employee.class, 3));
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		}
        catch(Exception e)        {
        	LOGGER.error("{} - {}",e.getMessage(),e);        	
        }
        finally {
        	if(session!=null)        	{
        		session.close();
        	}
        }
	}

	private static void addEmployee() {
        Session session = getSession();
        try        {
	        session.beginTransaction();
	        Employee employee = new Employee();
	        employee.setEmployeeName("Suresh");        
	        session.save(employee);        
	        session.getTransaction().commit();
        }
        catch(Exception e)        {
        	LOGGER.error("{} - {}",e.getMessage(),e);        	
        }
        finally {
        	if(session!=null)        	{
        		session.close();
        	}
        }
	}
	
	private static Session getSession()
	{
		return HibernateUtil.getSessionFactory().openSession();
	}
}

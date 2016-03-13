package AdminService;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;

public class DeleteUserService {
	
public Boolean getDeteteUser(String userID){
	    Boolean result=false;
	
	    String userLogin =  getUserLoginDB(userID);
	    
	    if(userLogin.equals("admin")){
	    	result=true;
	    	
	    	return result;
	    }
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		List<Object> idUser = null;
		
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
					
			SQLQuery query = session.createSQLQuery("DELETE FROM user WHERE id=?;");
			query.setParameter(0, userID);
			query.executeUpdate();
			
			SQLQuery query1 = session.createSQLQuery("DELETE FROM result WHERE id=?;");
			query1.setParameter(0, userID);
			query1.executeUpdate();
			
			transaction.commit();
			
		}catch(Exception e){
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
}
   
   public String getUserLoginDB(String userID){
	
	Session session = HibernateUtil.openSession();
	Transaction transaction = null;
	//List<Object> idUser = null;
	String userLogin = null;
	
	
	
	try{
		transaction = session.getTransaction();
		transaction.begin();
		SQLQuery query = session.createSQLQuery("SELECT login  FROM user WHERE id=?;");
		query.setParameter(0, userID);
		userLogin = (String)query.uniqueResult();
		
		System.out.println("!!!Выводимый логин для провкрки "+userLogin);
		
		transaction.commit();
		
	}catch(Exception e){
		//отменяем транзакцию
		transaction.rollback();
		e.printStackTrace();
	}finally{
		session.close();
	}
	
	return userLogin;
}
}

package AdminService;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;

public class EditUserService {
	
	public List<Object> getUserDB(String userID){
		Session session = HibernateUtil.openSession();
		//boolean result = false;
		List<Object> userDB = null;
			
		Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE id=?;");
			query.setParameter(0, userID);
			query.addEntity(Model.User.class);
			userDB = query.list();
			
			transaction.commit();// применяем транзакцию
			
			//проверяем, что вернул нам метод uniqueResult()
			
		}catch(Exception e){
			 
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			//sessionFactory.close();
		}
		
		return userDB;
	}

}

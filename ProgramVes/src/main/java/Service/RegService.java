package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import Model.User;

import Hibernate.HibernateUtil;

public class RegService {
	
	//private User user = new User();
	
	public boolean regUser(User user){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		if(userInBd(user)) return false;//проверки существования пользователя по логину и email в базе
		
		Session session = sessionFactory.openSession();
		//Transaction transaction = null;
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();// применяем транзакцию
		}catch(Exception e){
			 
			//отменяем транзакцию
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		return true;
	}
	
	//Метод проверки существования пользователя по логину и email в базе
		public boolean userInBd(User user){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			boolean result = false;
			Session session = sessionFactory.openSession();
			//Transaction transaction = null;
			
			try{
				session.beginTransaction();
				SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE name='blue';");
				query.addEntity(Model.User.class);
				//query.uniqueResult();
				User u = (User) query.uniqueResult();//возвращает экземпляр или null
				session.getTransaction().commit();// применяем транзакцию
				
				//проверяем, что вернул нам метод uniqueResult()
				if(u!=null) result = true;
			}catch(Exception e){
				 
				//отменяем транзакцию
				session.getTransaction().rollback();
				e.printStackTrace();
			}finally{
				session.close();
				sessionFactory.close();
			}
			
			return result;
		}

}

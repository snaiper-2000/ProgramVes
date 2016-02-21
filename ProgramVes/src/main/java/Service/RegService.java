package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class RegService {
	
	public boolean regUser(User user){
		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.openSession();
		
		if(userInBd(user) == true){
			return false;//проверки существования пользователя по логину и email в базе
		}
		
		Transaction transaction = null;
		//Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			//session.beginTransaction();
			
			
			session.saveOrUpdate(user);
			transaction.commit();// применяем транзакцию
		}catch(Exception e){
			 
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			//sessionFactory.close();
		}
		
		return true;
	}
	
	//Метод проверки существования пользователя по логину и email в базе
		public boolean userInBd(User user){
			//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = HibernateUtil.openSession();
			boolean result = false;
			//Session session = sessionFactory.openSession();
			Transaction transaction = null;
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				//session.beginTransaction();
				SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE login=?;");
				query.setParameter(0, user.getLogin());
				query.addEntity(Model.User.class);
				//query.uniqueResult();
				User u = (User) query.uniqueResult();//возвращает экземпляр или null
				transaction.commit();// применяем транзакцию
				
				//проверяем, что вернул нам метод uniqueResult()
				if(u!=null) result = true;
			}catch(Exception e){
				 
				//отменяем транзакцию
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
				//sessionFactory.close();
			}
			
			return result;
		}


}

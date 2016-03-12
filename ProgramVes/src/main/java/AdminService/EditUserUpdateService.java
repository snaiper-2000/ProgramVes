package AdminService;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class EditUserUpdateService {
	
	public boolean updateUser(User user){
		Session session = HibernateUtil.openSession();
		Boolean result;
		
		String userLoginDB = userInBd(user);
		
		//проверяет совпадает ли введенный логин с имеющимся в базе
		if(user.getLogin().equals(userLoginDB)){
			result = false;
		}else{
		
	    result = true;
/*		if(userInBd(user) == true){
			return false;//проверки существования пользователя по логину и email в базе
		}
*/		
		Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
		
			session.saveOrUpdate(user);
			transaction.commit();// применяем транзакцию
		}catch(Exception e){
			 
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
		
		return result; 
	} 
	
	//Метод проверки существования пользователя по логину в базе
		public String userInBd(User user){
			Session session = HibernateUtil.openSession();
			Transaction transaction = null;
			String userLoginDB = null;
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				SQLQuery query = session.createSQLQuery("SELECT login FROM user WHERE login=?;");
				query.setParameter(0, user.getLogin());
				//query.addEntity(Model.User.class);
				//query.uniqueResult();
				userLoginDB = (String) query.uniqueResult();//возвращает экземпляр или null
				transaction.commit();// применяем транзакцию
				
				
				System.out.println("Пользователь с логином = "+userLoginDB+"уже существует");
				
			}catch(Exception e){
				 
				//отменяем транзакцию
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
				//sessionFactory.close();
			}
			
			
			
			return userLoginDB;
		}

}

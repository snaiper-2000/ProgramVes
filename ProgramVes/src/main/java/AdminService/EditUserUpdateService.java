package AdminService;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class EditUserUpdateService {
	
	public boolean updateUser(User user,String id){
		Session session = HibernateUtil.openSession();
		Boolean result=false;
		Boolean peremennaya=false;
		
		String userInDB = userInBd(user);
		Integer userIDInBd = userIDInBd(user,id);
		
		//проверяет совпадает ли введенный логин с имеющимся в базе
		if(user.getLogin().equals(userInDB)){
			if(id.equals(userIDInBd)){
				
				peremennaya=true;
			    
			}else{
				
				peremennaya=false;
				result = false;
				return result;
			}
			
			peremennaya=true;
		}
		
		if(peremennaya=true){
				
		Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("UPDATE user SET surname=?, name=?, middleName=?, login=?, password=?, mobileTelephone=?, email=? WHERE id=?;");
			query.setParameter(0, user.getSurname());
			query.setParameter(1, user.getName());
			query.setParameter(2, user.getMiddleName());
			query.setParameter(3, user.getLogin());
			query.setParameter(4, user.getPassword());
			query.setParameter(5, user.getMobileTelephone());
			query.setParameter(6, user.getEmail());
			query.setParameter(7, id);
			query.executeUpdate();
			
			//session.saveOrUpdate(user);
			transaction.commit();// применяем транзакцию
		}catch(Exception e){
			 
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		result = true;
    }else{
    	result = false;
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
				
				userLoginDB = (String) query.uniqueResult();//возвращает экземпляр или null
				
				transaction.commit();// применяем транзакцию
				
				
				System.out.println("Пользователь с логином = "+userLoginDB+"уже существует");
				
			}catch(Exception e){
				 
				//отменяем транзакцию
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
			}
			
			return userLoginDB;
		}
		
		public Integer userIDInBd(User user,String id){
			Session session = HibernateUtil.openSession();
			Transaction transaction = null;
			Integer userIdDB = null;
			
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				SQLQuery query = session.createSQLQuery("SELECT id FROM user WHERE login=?;");
				query.setParameter(0, user.getLogin());
				
				userIdDB = (Integer)query.uniqueResult();
				
				System.out.println("Печать id юзера из базы"+ userIdDB);
				
				transaction.commit();// применяем транзакцию
				
				
			}catch(Exception e){
				 
				//отменяем транзакцию
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
			}
			
			
			return userIdDB;
		}

}

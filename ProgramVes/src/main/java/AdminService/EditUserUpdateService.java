package AdminService;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class EditUserUpdateService {
	
	public boolean updateUser(User user,String id){
		//Session session = HibernateUtil.openSession();
		Boolean result = false;
		//Boolean peremennaya=false;
		
		//int idInt = (Integer) id;
		
		int chislo=Integer.parseInt(id);
		
		System.out.println("печать id cо страницы панель администратора"+id);
		
		String userLoginInBd = userLoginInBd(user);
		Integer userIDInBd = userIDInBd(user,id);
		
		System.out.println(user.getLogin()+" = "+userLoginInBd+" ии "+id+" = "+userIDInBd);
		
		/*if(user.getLogin() != userLoginInBd ){
			
			result = true;
			updateUserBd(user, id);
			return result;
		}*/
		
		if(user.getLogin().equals(userLoginInBd) && userIDInBd.equals(chislo)){
			/*if(id.equals(userIDInBd)){*/
				
				result = true;
				updateUserBd(user, id);
				//return result;
				
		
		}else{if(userLoginInBd == null ){
			
			result = true;
			updateUserBd(user, id);
			//return result;
		}
			
		}
		
		return result;
		
	}
			
public void updateUserBd(User user, String id){			
			
	    Session session = HibernateUtil.openSession();		
		Transaction transaction = null;
		
		try{
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
			int resultUpdate = query.executeUpdate(); //возвращает количество субъектов которые были изменены
			
			System.out.println("Update отчет "+resultUpdate);
			
			//session.saveOrUpdate(user);
			transaction.commit();// применяем транзакцию
		}catch(Exception e){
			 
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
}	
	
	//Метод проверки существования пользователя по логину в базе
		public String userLoginInBd(User user){
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

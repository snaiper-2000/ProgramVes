package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class AuthService {
	
	public boolean authUser(String login,String password){
		boolean loginBd = getUserLogin(login);
		boolean passwordBd = getUserPassword(password);
		
		if(loginBd || passwordBd == true){
			return true;
		}else{return false;}
		
		//return true;
		
	}
	
	//провер€ем есть ли в базе введенный пользователем логин
	public boolean getUserLogin(String login){
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		//User user = null;
		boolean resultLogin = false;
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE login=?;");
			query.setParameter(0, login);
			query.addEntity(Model.User.class);
			User u = (User) query.uniqueResult();//возвращает экземпл€р или null
			transaction.commit();
			if(u!=null) resultLogin = true;
		}catch(Exception e){
			 
			//отмен€ем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return resultLogin;
	}
	
    public boolean getUserPassword(String password){
    	Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		//User user = null;
		boolean resultPassword = false;
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE password=?;");
			query.setParameter(0, password);
			query.addEntity(Model.User.class);
			User u = (User) query.uniqueResult();//возвращает экземпл€р или null
			transaction.commit();
			if(u!=null) resultPassword = true;
		}catch(Exception e){
			 
			//отмен€ем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return resultPassword;
	}

}

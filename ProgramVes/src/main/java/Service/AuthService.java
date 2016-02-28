package Service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Hibernate.HibernateUtil;
import Model.User;

public class AuthService {
	
	public boolean authUser(String login,String password){
		boolean loginBd = getUserLoginAndPassword(login, password);
		//boolean passwordBd = getUserPassword(password);
		
		//����� ���� ������ � ������������
		//getUserDB(login);
		
		if(loginBd /*|| passwordBd*/ == true){
			return true;
		}else{return false;}
		
		//return true;
		
	}
	
	//��������� ���� �� � ���� ��������� ������������� ����� � ������
	public boolean getUserLoginAndPassword(String login,String password){
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		//User user = null;
		boolean resultLogin = false;
		try{
			transaction = session.getTransaction();
			transaction.begin();
			
			SQLQuery queryLogin = session.createSQLQuery("SELECT * FROM user WHERE login=?;");
			queryLogin.setParameter(0, login);
			queryLogin.addEntity(Model.User.class);
			User uLogin = (User) queryLogin.uniqueResult();//���������� ��������� ��� null
			
			SQLQuery queryPassword = session.createSQLQuery("SELECT * FROM user WHERE password=?;");
			queryPassword.setParameter(0, password);
			queryPassword.addEntity(Model.User.class);
			User uPassword = (User)queryPassword.uniqueResult();//���������� ��������� ��� null
			
			transaction.commit();
			if(uLogin!=null || uPassword!=null) resultLogin = true;
		}catch(Exception e){
			 
			//�������� ����������
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return resultLogin;
	}
	
   /* public boolean getUserPassword(String password){
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
			User u = (User) query.uniqueResult();//���������� ��������� ��� null
			transaction.commit();
			if(u!=null) resultPassword = true;
		}catch(Exception e){
			 
			//�������� ����������
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return resultPassword;
	}*/
    
    //����� ���� ������ � ������������
    public User getUserDB(String login){
    	Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		List<Object> userDB = null;
		User user = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE login=?;");
			query.setParameter(0, login);
			query.addEntity(Model.User.class);
			userDB = query.list();//���������� ��������� ��� null
			transaction.commit();
			
		}catch(Exception e){
			 
			//�������� ����������
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
    	
    	for( userDB.iterator(); userDB.iterator().hasNext();){
    		
    		user =  (User) userDB.iterator().next();
    		System.out.println(" !!! date "+user.getDateUserReg());
    		break;
    	}
    	
    	return user;
    }

}

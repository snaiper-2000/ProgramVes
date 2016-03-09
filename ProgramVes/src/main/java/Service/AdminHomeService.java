package Service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.Result;
import Model.User;

public class AdminHomeService {
	
	public List<Object []> usersInBd(){
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		//String userLoginDB = null;
		List<Object []> users = null;
		User user = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user;");
			//query.setParameter(0, user.getLogin());
			query.addEntity(Model.User.class);
			//query.uniqueResult();
			users = query.list();
			//System.out.println(resultDate);
			transaction.commit();
			
		}catch(Exception e){
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
        /*for( users.iterator(); users.iterator().hasNext();){
    		
        	user =  (User) users.iterator().next();
    		//System.out.println(" ResultUserService  вывод флагов "+result.getFlag1()+" __ "+result.getFlag32());
    		break;
    	}
		
		/*for(Object [] obj :resultDate ){
				System.out.println(""+obj[0]);
			
    	}*/
		
		return users;
	}

}

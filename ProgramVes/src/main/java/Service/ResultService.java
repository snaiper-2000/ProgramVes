package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.Result;
import Model.User;

public class ResultService {
	
	//private User user = new User();
	
	public boolean saveResult(String user,Result res){
	Session session = HibernateUtil.openSession();
	boolean result = false;
	
	
	Transaction transaction = null;
	
	try{
		transaction = session.getTransaction();
		transaction.begin();
		//session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT id FROM user WHERE login=?;");
		query.setParameter(0, user);
		//query.addEntity(Model.User.class);
		//query.uniqueResult();
		/*User u = (User)*/Integer userId = (Integer) query.uniqueResult();//возвращает экземпляр или null
		System.out.println("Сохранение результата "+userId+" или "+query.uniqueResult());
		System.out.println("Сохранение результата UserLogin "+user);
		
		session.saveOrUpdate(res);
		
		transaction.commit();// применяем транзакцию
		
		//проверяем, что вернул нам метод uniqueResult()
		if(query.uniqueResult()!=null) result = true;
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

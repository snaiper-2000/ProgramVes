package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.Result;
import Model.User;

public class ResultService {
	
   private User u = new User();
	
	public boolean saveResult(String user,Result res){
	Session session = HibernateUtil.openSession();
	boolean result = false;
	//private User u = new User();
	
	
	Transaction transaction = null;
	
	try{
		transaction = session.getTransaction();
		transaction.begin();
		//session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT id FROM user WHERE login=?;");
		query.setParameter(0, user);
		//query.addEntity(Model.User.class);
		//query.uniqueResult();
		/*u = (User)query.uniqueResult();*/Integer userId = (Integer) query.uniqueResult();//возвращает экземпляр или null
		
		long userIdLong = (long) (userId);
		System.out.println("Сохранение результата "+u+" или "+query.uniqueResult()+"   "+userId);
		System.out.println("Сохранение результата UserLogin "+user);
		
		
		/*SQLQuery queryInsert = session.createSQLQuery("insert into result (id, flag1, flag2, flag3, flag4) values (?, ?, ?, ?, ?)");
		query.addEntity(Model.Result.class);
		queryInsert.setParameter(0, userId);
		queryInsert.setParameter(1, res.getFlag1());
		queryInsert.setParameter(2, res.getFlag2());
		queryInsert.setParameter(3, res.getFlag3());
		queryInsert.setParameter(4, res.getFlag4());*/
		
		/*res.getFlag1();
		res.getFlag2();
		res.getFlag3();
		res.getFlag4();*/
		
		
		u.setId(userIdLong);
		res.setUser(u);
	
		
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

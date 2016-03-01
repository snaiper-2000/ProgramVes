package Service;

import java.util.Date;

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
		
		
		u.setId(userIdLong);
		res.setUser(u);
		
		//получение текущей даты
		Date date = new Date();
		res.setDateResult(date);
	
		
		//session.saveOrUpdate(res);
		session.save(res);
		
		/*SQLQuery queryResultDate = session.createSQLQuery("SELECT date_result FROM result WHERE id=?;");
		queryResultDate.addEntity(Model.Result.class);
		queryResultDate.setParameter(0, userId);
		Date d = (Date)queryResultDate.uniqueResult();
		res.setDateResult(d);
		System.out.println("Вызов даты из таблицы Result "+d);*/
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

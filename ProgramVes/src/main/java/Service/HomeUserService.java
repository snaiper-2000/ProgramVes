package Service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
//import Model.Result;
//import Model.User;

public class HomeUserService {
	//private User user = new User();
		
		public List<Object []> getHomeUserDate(Long userId){
			
			System.out.println("Этот гадкий user "+userId);
			Session session = HibernateUtil.openSession();
			Transaction transaction = null;
			List<Object []> resultDate = null;
			
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				SQLQuery query = session.createSQLQuery("SELECT date_result FROM result WHERE id=?;");
				query.setParameter(0, userId);
				//query.addEntity(Model.Result.class);
				resultDate = query.list();
				System.out.println(resultDate);
				transaction.commit();
				
			}catch(Exception e){
				System.out.println("4");
				//отменяем транзакцию
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
			}
			
			/*for(Object [] obj :resultDate ){
					System.out.println(""+obj[0]);
				
	    	}*/
			
			return resultDate;
		}
}

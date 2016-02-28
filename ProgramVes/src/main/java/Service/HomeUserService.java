package Service;

//import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
//import Model.Result;
import Model.User;

public class HomeUserService {
	
		
		public void getHomeUserDate(User user){
			Session session = HibernateUtil.openSession();
			Transaction transaction = null;
			//List<Object []> resultDate = null;
			//Result result = null;
			System.out.println("1");
			try{
				transaction = session.getTransaction();
				transaction.begin();
				System.out.println("2");
				SQLQuery query = session.createSQLQuery("SELECT date_result FROM result WHERE id=?;");
				query.setParameter(0, user.getId());
				query.addEntity(Model.Result.class);
				System.out.println("3");
				/*resultDate =*/ query.list();
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
				for(int i = 0; i< resultDate.size(); i++ ){
					System.out.println(obj[i]);
				}	
				
	    	}*/
			
			//return result;
		}
}

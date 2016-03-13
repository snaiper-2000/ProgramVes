package AdminService;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;

public class DeleteUserService {
	
public void getDeteteUser(String userID){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		List<Object> idUser = null;
		
		
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			/*SQLQuery query2 = session.createSQLQuery("SELECT id  FROM result WHERE date_result=?;");
			query2.setParameter(0, userID);
			idUser = query2.list();
			
			System.out.println("idUser для провкрки "+idUser);
		*/
			
			SQLQuery query = session.createSQLQuery("DELETE FROM user WHERE id=?;");
			query.setParameter(0, userID);
			query.executeUpdate();
			
			SQLQuery query1 = session.createSQLQuery("DELETE FROM result WHERE id=?;");
			query1.setParameter(0, userID);
			query1.executeUpdate();
			
			transaction.commit();
			
		}catch(Exception e){
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		//return idUser;
}
}

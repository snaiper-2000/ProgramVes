package AdminService;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.Result;

public class EditResultDeleteService {
	
public List<Object> getDeteteDateResult(String date){
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		List<Object> idUser = null;
		
		
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT id  FROM result WHERE date_result=?;");
			query.setParameter(0, date);
			idUser = query.list();
			
			System.out.println("idUser для провкрки "+idUser);
		

			SQLQuery query1 = session.createSQLQuery("DELETE FROM result WHERE date_result=?;");
			query1.setParameter(0, date);
			query1.executeUpdate();
			
			transaction.commit();
			
		}catch(Exception e){
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return idUser;
}

}

package Service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.Result;
//import Model.User;

public class ResultUserService {
	
	public Result getResultUser(String resultDate){
		
		//System.out.println("Этот гадкий user "+userId);
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		List<Object> resultUser = null;
		Result result = null;
		
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			SQLQuery query = session.createSQLQuery("SELECT * FROM result WHERE date_result=?;");
			query.setParameter(0, resultDate);
			query.addEntity(Model.Result.class);
			resultUser = query.list();
			//System.out.println(resultDate);
			transaction.commit();
			
		}catch(Exception e){
			//отменяем транзакцию
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
        for( resultUser.iterator(); resultUser.iterator().hasNext();){
    		
        	result =  (Result) resultUser.iterator().next();
    		System.out.println(" ResultUserService  вывод флагов "+result.getFlag1()+" __ "+result.getFlag32());
    		break;
    	}
		
		/*for(Object [] obj :resultDate ){
				System.out.println(""+obj[0]);
			
    	}*/
		
		return result;
	}
}



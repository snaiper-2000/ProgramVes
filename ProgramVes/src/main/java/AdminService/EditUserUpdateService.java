package AdminService;

import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class EditUserUpdateService {
	
	public boolean updateUser(User user){
		Session session = HibernateUtil.openSession();
		Boolean result;
		
		String userLoginDB = userInBd(user);
		
		//��������� ��������� �� ��������� ����� � ��������� � ����
		if(user.getLogin().equals(userLoginDB)){
			result = false;
		}else{
		
	    result = true;
/*		if(userInBd(user) == true){
			return false;//�������� ������������� ������������ �� ������ � email � ����
		}
*/		
		Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
		
			session.saveOrUpdate(user);
			transaction.commit();// ��������� ����������
		}catch(Exception e){
			 
			//�������� ����������
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
		
		return result; 
	} 
	
	//����� �������� ������������� ������������ �� ������ � ����
		public String userInBd(User user){
			Session session = HibernateUtil.openSession();
			Transaction transaction = null;
			String userLoginDB = null;
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				SQLQuery query = session.createSQLQuery("SELECT login FROM user WHERE login=?;");
				query.setParameter(0, user.getLogin());
				//query.addEntity(Model.User.class);
				//query.uniqueResult();
				userLoginDB = (String) query.uniqueResult();//���������� ��������� ��� null
				transaction.commit();// ��������� ����������
				
				
				System.out.println("������������ � ������� = "+userLoginDB+"��� ����������");
				
			}catch(Exception e){
				 
				//�������� ����������
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
				//sessionFactory.close();
			}
			
			
			
			return userLoginDB;
		}

}

package Service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import Model.User;

import Hibernate.HibernateUtil;

public class RegService {
	
	//private User user = new User();
	
	public boolean regUser(User user){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		if(userInBd(user)) return false;//�������� ������������� ������������ �� ������ � email � ����
		
		Session session = sessionFactory.openSession();
		//Transaction transaction = null;
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();// ��������� ����������
		}catch(Exception e){
			 
			//�������� ����������
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		return true;
	}
	
	//����� �������� ������������� ������������ �� ������ � email � ����
		public boolean userInBd(User user){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			boolean result = false;
			Session session = sessionFactory.openSession();
			//Transaction transaction = null;
			
			try{
				session.beginTransaction();
				SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE name='blue';");
				query.addEntity(Model.User.class);
				//query.uniqueResult();
				User u = (User) query.uniqueResult();//���������� ��������� ��� null
				session.getTransaction().commit();// ��������� ����������
				
				//���������, ��� ������ ��� ����� uniqueResult()
				if(u!=null) result = true;
			}catch(Exception e){
				 
				//�������� ����������
				session.getTransaction().rollback();
				e.printStackTrace();
			}finally{
				session.close();
				sessionFactory.close();
			}
			
			return result;
		}

}

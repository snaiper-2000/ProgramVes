package Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import Model.User;

public class RegService {
	
	public boolean regUser(User user){
		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.openSession();
		
		if(userInBd(user) == true){
			return false;//�������� ������������� ������������ �� ������ � email � ����
		}
		
		Transaction transaction = null;
		//Transaction transaction = null;
		
		try{
			transaction = session.getTransaction();
			transaction.begin();
			//session.beginTransaction();
			
		//��������� ������� ����	
			Date date = new Date();
		      /* DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		       String s = formatter.format(now);
		       System.out.println(s);*/
			
			user.setDateUserReg(date);
			session.saveOrUpdate(user);
			transaction.commit();// ��������� ����������
		}catch(Exception e){
			 
			//�������� ����������
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			//sessionFactory.close();
		}
		
		return true;
	}
	
	//����� �������� ������������� ������������ �� ������ � email � ����
		public boolean userInBd(User user){
			//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = HibernateUtil.openSession();
			boolean result = false;
			//Session session = sessionFactory.openSession();
			Transaction transaction = null;
			
			try{
				transaction = session.getTransaction();
				transaction.begin();
				//session.beginTransaction();
				SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE login=?;");
				query.setParameter(0, user.getLogin());
				query.addEntity(Model.User.class);
				//query.uniqueResult();
				User u = (User) query.uniqueResult();//���������� ��������� ��� null
				transaction.commit();// ��������� ����������
				
				//���������, ��� ������ ��� ����� uniqueResult()
				if(u!=null) result = true;
			}catch(Exception e){
				 
				//�������� ����������
				transaction.rollback();
				e.printStackTrace();
			}finally{
				session.close();
				//sessionFactory.close();
			}
			
			return result;
		}


}

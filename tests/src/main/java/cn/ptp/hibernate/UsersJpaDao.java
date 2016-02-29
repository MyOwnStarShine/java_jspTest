package cn.ptp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import cn.ptp.hibernate.UsersDao;
import cn.ptp.hibernate.Users;

public class UsersJpaDao implements UsersDao
{
	private EntityManagerFactory entityManagerFactory;
	
	public UsersJpaDao(){
		entityManagerFactory = Persistence.createEntityManagerFactory("dao");
	}
	
	public void delete(int id){
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try{
			tx.begin();
			Users users = manager.find(Users.class, id);
			manager.remove(users);
			tx.commit();
		}catch(RuntimeException e){
			tx.rollback();
			throw e;
		}finally {
			manager.close();
		}
	}
	
	public Users get(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();  
        try {
            return manager.find(Users.class, id);  
        } finally {  
            manager.close();  
        }  
	}
	
	public void save(Users users) {  
        EntityManager manager = entityManagerFactory.createEntityManager();  
        EntityTransaction tx = manager.getTransaction();  
        try {  
            tx.begin();  
            manager.merge(users);  
            tx.commit();  
        } catch (RuntimeException e) {  
            tx.rollback();  
            throw e;  
        } finally {  
            manager.close();  
        }  
    }  
	
}
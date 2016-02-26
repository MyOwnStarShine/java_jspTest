package cn.ptp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



class Test 
{
	public static void main(String[] args) throws Exception
	{
		add1();
		//add2();
    }
	
	//----------------------------------------- JPA 方式
	private static UsersDao userDao;  
	public static void add1(){
		userDao=new UsersJpaDao();
		//testSave();
		testGet();
	}
	public static void testSave(){  
        Users users=new Users(); 
        users.setUsername("ison.zhang3");
        users.setSalt();
        users.setPasswd("123456");
        users.setCreateAt();
        userDao.save(users);
    }
    public static void testGet(){  
        Users users=userDao.get(3);  
        System.out.println("username: "+ users.getUsername());  
        System.out.println("create at: "+ users.getCreateAt());   
    }  
	//----------------------------------------- END JPA方式
	
	//------------------------------------------ annotation 注解方式
	public static void add2() throws Exception {
		setUp();
        Users u = new Users();

        u.setUsername("ison.zhang2");
        u.setSalt();
        u.setPasswd("123456");
        u.setCreateAt();
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        System.out.println("success");
		
	}
	private static SessionFactory sessionFactory=null;
	protected static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	//--------------------------------------------------- END annotation 注解方式
	
	
}

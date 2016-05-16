package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;


public class AppHibernateVer4 {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistryBuilder serviceRegistry;

    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate!" );

        //configure
        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());

        //data
        UserDetails user = new UserDetails();
        user.setUserName("Test Name");

        //transaction
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

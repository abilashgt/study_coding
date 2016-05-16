package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails3;


public class AppHibernate3
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate!" );

        UserDetails3 user = new UserDetails3();
        user.setUserName("First User");

        Address address = new Address();
        address.setStreet("First street");
        address.setCity("First city");
        address.setState("First state");
        address.setPin("First 123");

        Address address2 = new Address();
        address2.setStreet("Second street");
        address2.setCity("Second city");
        address2.setState("Second state");
        address2.setPin("Second 123");

        user.getListOfAddresses().add(address);
        user.getListOfAddresses().add(address2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = null;
        user = (UserDetails3) session.get(UserDetails3.class, 1);
        System.out.println("User name retrieved = " + user.getUserName());

        //if you close the session, then use eager initialization in UserDetails3
        //session.close();
        System.out.println("User Address retrieved = " + user.getListOfAddresses().size());

        sessionFactory.close();
    }
}

package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails;

import java.util.Date;


public class AppHibernate
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate!" );

        UserDetails user = new UserDetails();
        user.setUserName("First User");
        user.setJoinDate(new Date());
        user.setDesciption("Describe 1");

        Address address = new Address();
        address.setStreet("street name");
        address.setCity("city name");
        address.setState("state name");
        address.setPin("123");
        user.setAddress(address);
        user.setOfficeAddress(address);

        UserDetails user2 = new UserDetails();
        user2.setUserName("Second User");
        user2.setJoinDate(new Date());
        user2.setDesciption("Describe 2");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 2);
        System.out.println("User name retrieved = " + user.getUserName());

        sessionFactory.close();
    }
}

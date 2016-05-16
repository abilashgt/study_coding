package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.one2one.O2OUserDetails;
import org.koushik.javabrains.dto.one2one.O2OVehicle;


public class AppOne2One
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate!" );

        O2OUserDetails user = new O2OUserDetails();
        user.setUserName("First User");

        O2OUserDetails user2 = new O2OUserDetails();
        user2.setUserName("Second User");

        O2OVehicle vehicle = new O2OVehicle();
        vehicle.setVehicleName("Car");
        user.setVehicle(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = null;
        user = (O2OUserDetails) session.get(O2OUserDetails.class, 2);
        System.out.println("User name retrieved = " + user.getUserName());

        sessionFactory.close();
    }
}

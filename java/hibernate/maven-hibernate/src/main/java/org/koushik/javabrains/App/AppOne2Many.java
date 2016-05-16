package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.one2many.O2MUserDetails;
import org.koushik.javabrains.dto.one2many.O2MVehicle;


public class AppOne2Many
{
    public static void main( String[] args )
    {

        //users
        O2MUserDetails user = new O2MUserDetails();
        user.setUserName("First User");

        O2MUserDetails user2 = new O2MUserDetails();
        user2.setUserName("Second User");

        //vehicles
        O2MVehicle vehicle = new O2MVehicle();
        vehicle.setVehicleName("Car");

        O2MVehicle vehicle2 = new O2MVehicle();
        vehicle2.setVehicleName("Jeep");

        //for NotFoundAction.IGNORE
        O2MVehicle vehicle3 = new O2MVehicle();
        vehicle3.setVehicleName("Lorry");

        //relations
        vehicle.setUser(user);
        vehicle2.setUser(user);
        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user);
        session.persist(user2);
        //commenting for cascade to do it automatically
        //session.save(vehicle);
        //session.save(vehicle2);

        //for NotFoundAction.IGNORE
        session.save(vehicle3);

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}

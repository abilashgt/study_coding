package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.many2many.M2MUserDetails;
import org.koushik.javabrains.dto.many2many.M2MVehicle;


public class AppMany2Many
{
    public static void main( String[] args )
    {

        // users
        M2MUserDetails user = new M2MUserDetails();
        user.setUserName("First User");

        M2MUserDetails user2 = new M2MUserDetails();
        user2.setUserName("Second User");

        // vehicles
        M2MVehicle vehicle = new M2MVehicle();
        vehicle.setVehicleName("Car");

        M2MVehicle vehicle2 = new M2MVehicle();
        vehicle2.setVehicleName("Jeep");

        // relations
        vehicle.getUsers().add(user);
        vehicle2.getUsers().add(user);
        user.getVehicles().add(vehicle);
        user.getVehicles().add(vehicle2);
        user2.getVehicles().add(vehicle);
        user2.getVehicles().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.save(vehicle);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}

package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.inheritance.*;


public class AppInheritance
{
    public static void main( String[] args )
    {
        //vehicles
        InVehicle vehicle = new InVehicle();
        vehicle.setVehicleName("Car");

        InTwoWheeler bike = new InTwoWheeler();
        bike.setVehicleName("bike");
        bike.setSteeringHandle("bike steering handle");

        InFourWheeler car = new InFourWheeler();
        car.setVehicleName("porche");
        car.setSteeringWheel("porche steering handle");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //commiting
        session.save(vehicle);
        session.save(bike);
        session.save(car);

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}

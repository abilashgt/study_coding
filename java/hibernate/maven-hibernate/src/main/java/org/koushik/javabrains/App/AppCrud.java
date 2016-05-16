package org.koushik.javabrains.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.crud.CRUDUserDetails;


public class AppCrud
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        /*
        ** session 1
        */
        session.beginTransaction();

        // Create (insert)
        // Transient State: Object not connected to hibernate yet
        CRUDUserDetails user;
        for(int i=1; i<=10; i++) {
            user = new CRUDUserDetails();
            user.setUserName("User "+i);

            // becomes Persistent State: Object gets connected to hibernate and the so to the db
            session.save(user);
        }

        // Read (fetching)
        // Persistent State: Object gets connected
        user = (CRUDUserDetails) session.get(CRUDUserDetails.class, 6);
        System.out.println("\nUser = " + user.getUserName());

        // Delete
        // becomes Transient State: object becomes disconnected. thus insert creates new row.
        session.delete(user);
        //pending. direct delete by id

        // Update
        // Persistent State: Object gets connected to hibernate and the so to the db
        user = (CRUDUserDetails) session.get(CRUDUserDetails.class, 5);
        user.setUserName("updated user");
        session.update(user); //need not be used. saves inspite of this command
        // tracks the changes to the object and updates the db even though save or update is not called.
        // note that it also works after inserting (saving) an object to the db.
        user.setUserName("updated user again");

        session.getTransaction().commit();
        session.close();

        // Detached State: Object disconnects

        /*
        ** session 2
        */
        session = sessionFactory.openSession();
        session.beginTransaction();

        // Update
        //user.setUserName("updated user after session close"); // in Transient State
        session.update(user); // attach back and becomes Persistent State
        user.setUserName("change user after session close and update"); // in Persistent State

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}

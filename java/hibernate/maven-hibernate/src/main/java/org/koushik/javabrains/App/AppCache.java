package org.koushik.javabrains.App;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.crud.CRUDUserDetails;
import java.util.List;


public class AppCache {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        /*
        First Level Cache
        First Level Optimization
         */
        Session session = factory.openSession();
        session.beginTransaction();

        CRUDUserDetails user1 = (CRUDUserDetails) session.get(CRUDUserDetails.class, 2);
        user1.setUserName("updated User 2");

        //only runs the select query ones for the above
        CRUDUserDetails user2 = (CRUDUserDetails) session.get(CRUDUserDetails.class, 2);

        session.getTransaction().commit();
        session.close();

        /*
        Second Level Cache
        Across session;
         */

        session = factory.openSession();
        session.beginTransaction();

        //here the select query runs again since the session was closed before which clears the cache
        CRUDUserDetails user3 = (CRUDUserDetails) session.get(CRUDUserDetails.class, 2);

        session.getTransaction().commit();
        session.close();

        // implemented in the table CRUDUserDetails

        /*
        Second Level Cache
        Query cache;
         */
        System.out.println("\nQUERY CACHE:");

        session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from CRUDUserDetails user where user.UserId = 2");
        query.setCacheable(true);
        List<CRUDUserDetails> users = (List<CRUDUserDetails>)query.list();

        session.getTransaction().commit();
        session.close();

        session = factory.openSession();
        session.beginTransaction();

        Query query2 = session.createQuery("from CRUDUserDetails user where user.UserId = 2");
        query2.setCacheable(true);
        users = (List<CRUDUserDetails>)query2.list();

        session.getTransaction().commit();
        session.close();


        factory.close();
    }
}

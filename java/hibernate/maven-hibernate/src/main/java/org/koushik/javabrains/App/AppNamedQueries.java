package org.koushik.javabrains.App;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.crud.CRUDUserDetails;

import java.util.List;
import java.util.Map;


public class AppNamedQueries
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Named Query
        Query query = session.getNamedQuery("UserDetails.byName");
        query.setString("name", "User 7");
        List<CRUDUserDetails> users = (List<CRUDUserDetails>)query.list();

        System.out.println("Named Query: Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        // Named Native Query
        query = session.getNamedQuery("UserDetails.byId");
        query.setInteger("id", 7);
        users = (List<CRUDUserDetails>)query.list();

        System.out.println("\nNamed Native Query: Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

package org.koushik.javabrains.App;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.koushik.javabrains.dto.crud.CRUDUserDetails;
import java.util.List;


public class AppCriteria
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // criteria
        Criteria criteria = session.createCriteria(CRUDUserDetails.class);
        criteria.add(Restrictions.eq("UserName", "User 7"));

        List<CRUDUserDetails> users = (List<CRUDUserDetails>)criteria.list();
        System.out.println("\nList 1: Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        // Restrictions chaining
        criteria = session.createCriteria(CRUDUserDetails.class);
        criteria.add(Restrictions.like("UserName", "%1%"))
                .add(Restrictions.ge("UserId", 7)); //greater than equal 7

        users = (List<CRUDUserDetails>)criteria.list();
        System.out.println("\nList 2: Chaining, Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        // OR chaining
        criteria = session.createCriteria(CRUDUserDetails.class);
        criteria.add(Restrictions.or(Restrictions.like("UserName", "%1%"), Restrictions.ge("UserId", 7)));

        users = (List<CRUDUserDetails>)criteria.list();
        System.out.println("\nList 3: OR, Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        // projections and order
        criteria = session.createCriteria(CRUDUserDetails.class)
                          .setProjection(Projections.property("UserName"))
                          .addOrder(org.hibernate.criterion.Order.desc("UserId"));

        List<String> usernames = (List<String>)criteria.list();
        System.out.println("\nList 4: Projections, Size=" + users.size());
        for(String username : usernames){
            System.out.println(username);
        }

        // projections 2
        criteria = session.createCriteria(CRUDUserDetails.class)
                          .setProjection(Projections.max("UserId"));

        Integer max = (Integer) criteria.uniqueResult();
        System.out.println("\nValue 5: Projections 2, Max UserId=" + max);

        // query by example
        CRUDUserDetails exampleUser = new CRUDUserDetails();
        exampleUser.setUserName("User 1%");
        Example example = Example.create(exampleUser);
        criteria = session.createCriteria(CRUDUserDetails.class)
                          .add(example.enableLike());

        users = (List<CRUDUserDetails>)criteria.list();
        System.out.println("\nList 6: Query by example, Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserName());
        }

        // query by example 2
        exampleUser = new CRUDUserDetails();
        exampleUser.setUserName("User 1");
        exampleUser.setUserId(2);
        example = Example.create(exampleUser);
        criteria = session.createCriteria(CRUDUserDetails.class)
                          //.add(example.excludeProperty("UserName"))
                          ;

        users = (List<CRUDUserDetails>)criteria.list();
        System.out.println("\nList 7: Query by example 2, Size=" + users.size());
        for(CRUDUserDetails user : users){
            System.out.println(user.getUserName());
        }


        //end session
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

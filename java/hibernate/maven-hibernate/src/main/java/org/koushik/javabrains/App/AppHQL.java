package org.koushik.javabrains.App;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.crud.CRUDUserDetails;
import java.util.List;
import java.util.Map;


public class AppHQL
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // list 1
        Query query = session.createQuery("from CRUDUserDetails");
        query.setFirstResult(2);
        query.setMaxResults(4);

        List<CRUDUserDetails> users = (List<CRUDUserDetails>)query.list();
        System.out.println("List 1: Size=" + users.size());

        for(CRUDUserDetails user : users){
            System.out.println(user.getUserId()+"-"+user.getUserName());
        }

        // list 2
        System.out.println("");
        String minUserId = "4";
        String maxUserId = "9";
        //Query query2 = session.createQuery("select UserName from CRUDUserDetails where UserId > ? and UserId < ?");
        //// data binding
        //query2.setInteger(0, Integer.parseInt(minUserId));
        //query2.setInteger(1, Integer.parseInt(maxUserId));
        // or
        Query query2 = session.createQuery("select UserName from CRUDUserDetails where UserId > :min and UserId < :max");
        // data binding
        query2.setInteger("min", Integer.parseInt(minUserId));
        query2.setInteger("max", Integer.parseInt(maxUserId));

        List<String> users2 = (List<String>)query2.list();
        System.out.println("List 2: Size="+users2.size());

        for(String user : users2){
            System.out.println(user);
        }

        // list 3
        //not yet made it work
        System.out.println("");
        Query query3 = session.createQuery("select new map(UserId, UserName) from CRUDUserDetails");
        List<Map<String, String>> users3 = (List<Map<String, String>>)query3.list();
        System.out.println("List 3: Size="+users3.size());

        for(Map<String, String> user3 : users3){
            System.out.println(user3.toString());
            System.out.println(user3.get("UserId")+"-"+user3.get("UserName"));
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

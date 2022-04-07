package com.tec.manytomanyproject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = new Configuration().configure().addAnnotatedClass(Employees.class).addAnnotatedClass(Projects.class)
        .buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        // creating employees
        Employees chinnu = new Employees(1, "chinnu");
        Employees vinnu = new Employees(2, "vinnu");
        Employees Giri = new Employees(3, "Giri");
        
        // creating projects
        
        Projects pr = new Projects(1, "premium pro");
        Projects af = new Projects(2, "AfterAffect ");
        
        List<Employees> premployees = new ArrayList<Employees>();
        List<Employees> afemployees = new ArrayList<Employees>();
        
        //Assigning employees premium pro
        premployees.add(chinnu);
        premployees.add(vinnu);
        premployees.add(Giri);
        
        //Assigning employees after affects

        afemployees.add(vinnu);
        afemployees.add(Giri);
        
        pr.setEmployees(premployees);
        af.setEmployees(afemployees);
        
        
        session.save(chinnu);
        session.save(vinnu);
        session.save(Giri);
        
        session.save(pr);
        
        session.save(af);
        
        
        
        
        
        
        
        
        
        
        
        
        tx.commit();
        
    }
}

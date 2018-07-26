/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrtooldb;

import Beans.Candidate;
import DAO.CandidateDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Clock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import Core.App;

/**
 *
 * @author zoran.milicevic
 */
public class HRTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Session s = Hibernate.HibernateUtil.getSessionFactory().openSession();
//        s.beginTransaction();
//        
//        s.getTransaction().commit();
//        s.close();


        App.login(1, 3, 3);

    }

}

package Model;

/**
 * Created by akshay.Gupta on 1/13/2015.
 */

//import Controllers.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Authenticate {

    public Authenticate(){}

    public boolean Authenticate_login(EmployeeEntity e){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);


        Criterion username = Restrictions.eq("username", e.getUsername());
        Criterion password = Restrictions.eq("password", e.getPassword());

        cr.add(Restrictions.and(username, password));
        List ans = cr.list();
        session.close();

        if(ans.isEmpty()){
            return false;
        } else {
            return true;
        }

    }
    public String Authenticate_and_register(EmployeeEntity e){

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);

        Criterion username = Restrictions.eq("username", e.getUsername());
        cr.add(username);
        List ans = cr.list();
        if(!ans.isEmpty()) return "User_already_exists";

        Transaction t = session.beginTransaction();
        session.persist(e);
        t.commit();
        return "success";
    }

    public boolean isThere(EmployeeEntity e){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);

        Criterion username = Restrictions.eq("username", e.getUsername());
        cr.add(username);
        List ans = cr.list();
        if(!ans.isEmpty()) return true;
        return false;
    }

    public boolean Check_permission(EmployeeEntity e, String permission){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Role.class);

        Criterion role = Restrictions.eq("username", e.getUsername());
        cr.add(role);
        List<Role> ans = cr.list();

        for(int i = 0; i < ans.size(); i++){
            Criteria c = session.createCriteria(Permissions.class);

            Role r = new Role();
            r = ans.get(i);
            Criterion permissions = Restrictions.eq("role", r.getRole());
            c.add(permissions);
            List<Permissions> res = c.list();

            for(int j=0; j< res.size(); j++){
                Permissions p = new Permissions();
                p = res.get(j);
                if(permission.equals(p.getPermission())) return true;
            }
        }
        return false;
    }

    public void delete(EmployeeEntity e){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Role.class);
        Transaction t = session.beginTransaction();

        String s = "Delete from EmployeeEntity where username = '" + e.getUsername() + "'";
        Query query = session.createQuery(s);
        query.executeUpdate();

        t.commit();
        session.close();

    }

    public List viewAll(){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);

        return cr.list();
    }

    public List edit(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Role.class);
        cr.add(Restrictions.ne("role","admin"));
        return cr.list();
    }

    public void addRole(Role r){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Role.class);

        Transaction t = session.beginTransaction();
        session.persist(r);
        t.commit();
        session.close();

    }

    public void delRole(Role r){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Role.class);

        Transaction t = session.beginTransaction();

        String s = "Delete from Role where username = '" + r.getUsername() + "' AND role = '" + r.getRole() + "'";
        Query query = session.createQuery(s);
        query.executeUpdate();

        t.commit();
        session.close();

    }




}

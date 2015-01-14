package Controllers;

import Model.*;

import java.util.List;
import java.util.Stack;

public class Service {

       public boolean authenticate_login(String username, String password){

           EmployeeEntity e = new EmployeeEntity();
           e.setUsername(username);
           e.setPassword(password);

           Authenticate a = new Authenticate();
           return a.Authenticate_login(e);

       }

        public String authenticate_and_register(String name,String username, String Password, String Conf_password){

            EmployeeEntity e = new EmployeeEntity();
            e.setName(name);
            e.setUsername(username);
            e.setPassword(Password);
            e.setConfirmPassword(Conf_password);
            Authenticate a = new Authenticate();

            return a.Authenticate_and_register(e);
        }

        public boolean isthere(String username){
            EmployeeEntity e = new EmployeeEntity();
            e.setUsername(username);

            Authenticate a = new Authenticate();

            return a.isThere(e);
        }

        public boolean check_permission(String username, String permission){

            EmployeeEntity e = new EmployeeEntity();
            e.setUsername(username);

            Authenticate a = new Authenticate();
            return a.Check_permission(e,permission);
        }

        public void delete_employee(String username){

            EmployeeEntity e = new EmployeeEntity();
            e.setUsername(username);

            Authenticate a = new Authenticate();
            a.delete(e);
        }

        public List viewall(){

            Authenticate a = new Authenticate();

            return a.viewAll();
        }

        public List edit(){

            Authenticate a = new Authenticate();
            return a.edit();

        }

        public List editmanager(){

            Authenticate a = new Authenticate();
            return a.editManager();
        }
        public void addrole(String username,String role){

            Role r = new Role();
            r.setUsername(username);
            r.setRole(role);

            Authenticate a = new Authenticate();
            a.addRole(r);
        }

        public void addmanager(String username, String manager){
            EmployeeEntity e = new EmployeeEntity();
            e.setUsername(username);
            e.setManager(manager);

            Authenticate a = new Authenticate();
            a.addManager(e);
        }

        public void delrole(String username, String role){

            Role r = new Role();
            r.setUsername(username);
            r.setRole(role);

            Authenticate a = new Authenticate();
            a.delRole(r);
        }

        public void delmanager(String username, String manager){
            EmployeeEntity e = new EmployeeEntity();
            e.setUsername(username);
            e.setManager(manager);

            Authenticate a = new Authenticate();
            a.delManager(e);
        }

        public Stack<String> subordinates(List l , String manager){
            EmployeeEntity e = new EmployeeEntity();
            e.setManager(manager);

            Authenticate a = new Authenticate();
            return a.getsubordinates(e,l);
        }



}

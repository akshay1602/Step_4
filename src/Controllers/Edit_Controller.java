package Controllers;

import Model.EmployeeEntity;
import com.sun.javafx.sg.PGShape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Stack;

@Controller

public class Edit_Controller {
    @RequestMapping("/edit")
    public ModelAndView doEdit(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");

        Service s = new Service();
        boolean status = s.check_permission(username,"edit");

        if(status) {
            List l = (List)s.edit();
            return new ModelAndView("edit","list",l);
        }else {
            return new ModelAndView("no_permission","message",username);
        }
    }

    @RequestMapping("/editManager")
    public ModelAndView editmanager(HttpServletRequest request , HttpServletResponse res){

        String username = request.getParameter("username");

        Service s = new Service();
        Boolean status = s.check_permission(username,"editmanager");

        if(status){
            List l = (List) s.editmanager();
            return new ModelAndView("editmanager","list",l);

        } else {
            return new ModelAndView("no_permission","message",username);
        }

    }

    @RequestMapping("/addRole")
    public ModelAndView addrole(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");
        String role = request.getParameter("role");

        Service s = new Service();
        if(!s.isthere(username)){
            return new ModelAndView("error","message","user does not exists");
        }

        s.addrole(username,role);

        List l = (List)s.edit();
        return new ModelAndView("edit","list",l);
    }

    @RequestMapping("/addManager")
    public ModelAndView addmanager(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");
        String manager = request.getParameter("manager");

        Service s = new Service();
        if(!s.isthere(username)){
            return new ModelAndView("error","message","user does not exists");
        }

        s.addmanager(username, manager);

        List l = (List)s.editmanager();
        return new ModelAndView("editmanager","list",l);
    }

    @RequestMapping("/delRole")
    public ModelAndView delRole(HttpServletRequest request, HttpServletResponse res){

        String username = request.getParameter("username");
        String role = request.getParameter("role");

        Service s = new Service();

        s.delrole(username,role);
        List l = (List) s.edit();
        return new ModelAndView("edit","list",l);
    }

    @RequestMapping("/delManager")
    public ModelAndView delManager(HttpServletRequest request, HttpServletResponse res){
        String username = request.getParameter("username");
        String manager = request.getParameter("manager");

        Service s = new Service();

        s.delmanager(username,manager);

        List l = (List) s.editmanager();
        return new ModelAndView("editmanager","list",l);
    }
    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");

        Service s = new Service();
        boolean status = s.check_permission(username,"delete");

        if(status){
            return new ModelAndView("delete","username",username);
        }else {
            return new ModelAndView("no_permission","username",username);
        }
    }

    @RequestMapping("/doDeletion")
    public ModelAndView doDeletion(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");
        String deletion_username = request.getParameter("deletion_username");

        Service s = new Service();
        if(!s.isthere(deletion_username)) {
            return new ModelAndView("no_such_user","message","");
        }
        s.delete_employee(deletion_username);

        return new ModelAndView("welcome","message",username);
    }


    @RequestMapping("/view")
    public ModelAndView viewAll(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");

        Service s = new Service();
        boolean status = s.check_permission(username,"view");

        if(status){
            List l = s.viewall();
            return new ModelAndView("view","list",l);

        }else {
            return new ModelAndView("no_permission","message",username);
        }

    }

    @RequestMapping("/subordinate")
    public ModelAndView subordinate(HttpServletRequest request,HttpServletResponse res){

        String username = request.getParameter("username");

        //Service s = new Service();

        return new ModelAndView("subordinates","message","username");

    }

    @RequestMapping("/subordinates_of_role")
    public ModelAndView subordinates_of_emp(HttpServletRequest request,HttpServletResponse res){

        String role = request.getParameter("role");

        Service service = new Service();

        List l = service.viewall();

        Stack<String> l2 = service.subordinates(l,role);

        return new ModelAndView("view_subordinates","stack",l2);
    }



}

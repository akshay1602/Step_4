package Controllers;


//import Model.EmployeeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class Login_Controller {
    @RequestMapping("/login")
    public ModelAndView Login_into_db(HttpServletRequest request, HttpServletResponse res) {

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        boolean status = false;

        Service s = new Service();
        status = s.authenticate_login(name,password);

        if(status){
            return new ModelAndView("welcome","message",name);
        } else {
            return new ModelAndView("error","message","Authentication Failed");
        }

    }
}
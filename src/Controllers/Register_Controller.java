package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Authenticate;

@Controller

public class Register_Controller {
    @RequestMapping("/register")
    public ModelAndView Register_into_db(HttpServletRequest request, HttpServletResponse res) {
        String s1 = request.getParameter("Name");
        String s2 = request.getParameter("Username");
        String s3 = request.getParameter("Password");
        String s4 = request.getParameter("Confirm_Password");

        Service service = new Service();
        String s = service.authenticate_and_register(s1, s2, s3, s4);

        if(s == "User_already_exists") {
            return new ModelAndView("User_already_exists", "message", "User_exists");
        }else {
            return new ModelAndView("welcome", "message", s2);
        }

    }
}

package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.formbean.RegisterFormBean;

import java.util.Date;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserDAO UserDAO;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/registration");
        return response;
    }//ModelAndView index()

    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/registration");

        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setCreateDate((new Date()));

        UserDAO.save(user);

        log.info(form.toString());

        return response;
    }//ModelAndView registerSubmit()

}//public class UserController

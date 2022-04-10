package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;
import teksystems.esmondkimcasestudy.database.entity.User;
import teksystems.esmondkimcasestudy.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserDAO UserDAO;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/registration");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form",form);

        return response;
    }//ModelAndView index()

    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if ( bindingResult.hasErrors() ) {
            HashMap errors = new HashMap();

            for (ObjectError error : bindingResult.getAllErrors() ) {
//                errors.put( ((FieldError) error ).getField(), error.getDefaultMessage() );
                log.info ( ((FieldError) error).getField() + " " + error.getDefaultMessage() );
            }
            response.addObject("formErrors", errors);

            response.setViewName("user/register");
            return response;
        }//if bindingResult.hasErrors()

        User user = UserDAO.findById(form.getId());

        if ( user == null ) {
            user = new User();
        }

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setCreateDate((new Date()));

        UserDAO.save(user);

        log.info(form.toString());

        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }//ModelAndView registerSubmit()


    @GetMapping("/user/edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/registration");

        User user = UserDAO.findById(id);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setEmail(user.getEmail());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }

}//public class UserController

package teksystems.esmondkimcasestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.esmondkimcasestudy.database.dao.UserDAO;
import teksystems.esmondkimcasestudy.database.entity.User;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class UsersController {

    @Autowired
    private UserDAO UserDAO;

    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    public ModelAndView users() throws Exception {
        ModelAndView response = new ModelAndView();

        List<User> users = UserDAO.findAll();

        response.addObject("users", users);

        return response;
    }//users()

    @Transactional
    @RequestMapping(value = "/user/deleteuser", method =  { RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView delete(@PathParam("id") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println(id);

        UserDAO.deleteById(id);

        response.setViewName("redirect:/user/users");

        return response;

    }//delete()

}

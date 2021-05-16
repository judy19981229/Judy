package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView userDetail(Integer id){
        ModelAndView modelAndView=new ModelAndView();
        User user= userService.queryUserById(id);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("userDetail");
        return modelAndView;
    }
}

package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService1;

    @Resource
    private UserService userService2;

    @RequestMapping("/user")
    public ModelAndView userDetail(Integer id){
        ModelAndView modelAndView=new ModelAndView();
        User user1= userService1.queryUserById(id);
        modelAndView.addObject("user1",user1);
        User user2= userService2.queryUserById(id);
        modelAndView.addObject("user2",user2);
        modelAndView.setViewName("userDetail");
        return modelAndView;
    }
}

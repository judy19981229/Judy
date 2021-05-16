package service;

import model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Resource
    User user;

    @Override
    public User queryUserById(Integer id) {
        user.setId(id);
        user.setName("lisi");
        user.setAge(23);

        return user;
    }
}

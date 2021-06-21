package service;

import model.User;

public class UserServiceImpl1 implements UserService {

    @Override
    public User queryUserById(Integer id) {
        User user=new User();
        user.setId(id);
        user.setName("lisi-1");
        user.setAge(23);

        return user;
    }
}

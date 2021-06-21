package service;

import model.User;

public class UserServiceImpl2 implements UserService {
    @Override
    public User queryUserById(Integer id) {
        User user=new User();
        user.setId(id);
        user.setName("lisi-2");
        user.setAge(23);

        return user;
    }
}

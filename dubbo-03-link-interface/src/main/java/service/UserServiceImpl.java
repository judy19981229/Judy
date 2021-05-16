package service;

import model.User;

import javax.annotation.Resource;

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

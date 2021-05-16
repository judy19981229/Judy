package service;

import model.User;

public interface UserService {
    //根据用户标识获取用户的信息
    User queryUserById(Integer id);
}

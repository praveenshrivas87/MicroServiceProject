package com.lcwp.user.service.services;

import com.lcwp.user.service.entities.User;
import java.util.List;

public interface UserService {

    //Create User
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //Get single User
    User getUser(String userId);

    //TODO: Update
    //TOTO: Delete

}

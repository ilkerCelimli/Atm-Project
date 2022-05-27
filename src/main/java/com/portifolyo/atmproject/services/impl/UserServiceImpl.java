package com.portifolyo.atmproject.services.impl;


import com.portifolyo.atmproject.entity.Customer;
import com.portifolyo.atmproject.entity.User;
import com.portifolyo.atmproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServices<User> {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }


}

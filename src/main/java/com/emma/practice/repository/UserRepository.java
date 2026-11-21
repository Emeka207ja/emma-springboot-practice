package com.emma.practice.repository;

import com.emma.practice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public  User save(User user){
        users.put(user.getEmail(),user);
        return user;
    }

    public User getByEmail(String email){
        return users.get(email);
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();

        for (Map.Entry<String,User> entry : users.entrySet()){
            userList.add(entry.getValue());
        }

        return  userList;
    }

    public boolean existsByEmail(String email){
        User user = getByEmail(email);
        return  user != null;
    }
}

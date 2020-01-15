package org.yt.springboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yt.springboothibernate.entity.User;
import org.yt.springboothibernate.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UserController <br/>
 * Description: <br/>
 * date: 2019/12/23 14:44 <br/>
 *
 * @author Min <br/>
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("user")
    public List<User> listAll(){
        return userRepository.listAllUsers();
    }

    @RequestMapping("saveAll")
    public List<User> saveAll(String name1,String name2){
        User user1 = new User();
        user1.setUsername(name1);
        user1.setAge(22);
        user1.setPassword("123412");

        User user2 = new User();
        user2.setUsername(name2);
        user2.setAge(25);
        user2.setPassword("12sdf2");
        List<User> list = new ArrayList();
        list.add(user1);
        list.add(user2);

        List<User> users = userRepository.saveAll(list);

        return users;
    }
}

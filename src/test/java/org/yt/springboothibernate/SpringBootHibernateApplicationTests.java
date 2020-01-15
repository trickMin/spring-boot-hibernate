package org.yt.springboothibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.yt.springboothibernate.entity.User;
import org.yt.springboothibernate.repository.UserRepository;

import java.util.List;

@Slf4j
@SpringBootTest
class SpringBootHibernateApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        Sort unsorted = Sort.unsorted();
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<User> users = userRepository.findAll(pageRequest);
        System.out.println("总页数："+users.getTotalPages());
        List<User> content = users.getContent();
        for (User user:content){
            System.out.println("用户："+user);
        }
    }

    @Test
    public void testModify(){
        String username = "修改11";
        int i = userRepository.updateUsername(username);
        System.out.println(i);
    }

}

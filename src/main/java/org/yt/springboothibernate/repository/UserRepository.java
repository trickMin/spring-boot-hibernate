package org.yt.springboothibernate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.yt.springboothibernate.entity.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * ClassName: UserRepository <br/>
 * Description: <br/>
 * date: 2019/12/23 14:39 <br/>
 *
 * @author Min <br/>
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 用SQL语句查询所有
     * @return
     */
    @Query(value = "select * from user",nativeQuery = true)
    List<User> listAllUsers();

    /**
     * 分页查询
     * Page和Pageable都是spring.data中现有的类
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

    /**
     * 删除和修改操作必须要加上两个注解
     * 1.@Transactional（可以选SpringFramework的事务）
     * 2.@Modifying
     * 用@Query写HQL语句，注意对象是实体类，所以这里是User而不是user
     * 第几个形参，就用?几来代替（第3个形参，?3）
     * 也可以通过@Param注解实现参数名具体化（类比MyBatis）,例：
     *
     *     @Query("select u from User u where u.username = :username and u.age = :age")
     *     List<User> findByAgeAndUsername(@Param("username")String username, @Param("age")Integer age);
     *
     * @param username
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User set username = ?1 where id = 4")
    int updateUsername(String username);

    /**
     * 联表查询可以自定义HQL查询
     */
}

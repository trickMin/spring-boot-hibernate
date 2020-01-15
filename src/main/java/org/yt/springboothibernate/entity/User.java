package org.yt.springboothibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ClassName: User <br/>
 * Description: <br/>
 * date: 2019/12/13 16:57 <br/>
 *
 * @author Min <br/>
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键生成策略根据数据库选择，MySQL用IDENTITY，Oracle用SEQUENCE（不要选AUTO，有时会出错）
    private Integer id;
    @Column  // 省略默认列名就是属性名
    private Integer age;
    @Column(name = "username", length = 50) // 这是和数据表对应的一个列
    private String username;
    @Column
    private String password;
}

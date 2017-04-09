package cn.edu.suda.dixonshen.service;

import cn.edu.suda.dixonshen.domain.User;

import java.io.Serializable;

/**
 * 创建一个UserService继承BaseService，并指定具体的实体类型
 * 为什么要再写一个UserService接口？不同对象的业务体系不同，BaseService并不能完全替代不同对象的具体行为表现
 * Created by Z003R98D on 4/6/2017.
 */
public interface UserService extends BaseService<User> {

    void add(User user) throws Exception;

    void del(User user) throws Exception;

    void update(User user) throws Exception;

    User findOneById(Serializable id);
}

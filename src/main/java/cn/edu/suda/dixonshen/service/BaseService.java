package cn.edu.suda.dixonshen.service;

import java.io.Serializable;

/**
 * 创建一个BaseService接口，用泛型解耦
 * Created by Z003R98D on 4/6/2017.
 */
public interface BaseService<T>{

    void add(T t) throws Exception;

    void del(T t) throws Exception;

    void update(T t) throws Exception;

    T findOneById(Serializable id) throws Exception;

}

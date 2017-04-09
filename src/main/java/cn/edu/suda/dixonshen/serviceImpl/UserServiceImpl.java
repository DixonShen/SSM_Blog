package cn.edu.suda.dixonshen.serviceImpl;

import cn.edu.suda.dixonshen.dao.UserDao;
import cn.edu.suda.dixonshen.domain.User;
import cn.edu.suda.dixonshen.exception.*;
import cn.edu.suda.dixonshen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by Z003R98D on 4/6/2017.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 添加用户，一般来说需要检查用户为空、用户名为空、密码为空
     * @param user
     * @throws UserCanNotBeNullException
     * @throws UserNameCanNotBeNullException
     * @throws UserPwdCanNotBeNullException
     * @throws UserAlreadyExistException
     * @throws OtherThingsException
     */
    public void add(User user) throws UserCanNotBeNullException, UserNameCanNotBeNullException,
            UserPwdCanNotBeNullException, UserAlreadyExistException, OtherThingsException {
        //先检查用户是否存在
        if (null == user) {
            //抛出用户为空的自定义异常
            throw new UserCanNotBeNullException("User can not be Null");
        }
        //用户名不能为空检查
        if (StringUtils.isEmpty(user.getLoginId())) {
            //抛出用户名为空的自定义异常
            throw new UserNameCanNotBeNullException("User loginID can not be Null");
        }
        //用户密码不能为空检查
        if (StringUtils.isEmpty(user.getPwd())) {
            //抛出用户密码为空的自定义异常
            throw new UserPwdCanNotBeNullException("User pwd can not be Null");
        }
        //由于我这个是仓库管理系统，根据业务需求来说，我们的用户基本信息都是不能为空的
        //基本信息包括：姓名、年龄、用户名、密码、性别、手机号，年龄大于18
        if (StringUtils.isEmpty(user.getName())
                || StringUtils.isEmpty(user.getSex())
                || user.getAge() < 18
                || StringUtils.isEmpty(user.getCellNumber())) {
            //其他综合异常
            throw new OtherThingsException("Some use's base info can not be null");
        }
        //已经存在相同用户
        if (null != userDao.findOneById(user.getLoginId())) {
            //存在相同的用户异常
            throw new UserAlreadyExistException("Register User Failed，Because the  user Aiready exist");
        }
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            //其他用户添加失败异常
            e.printStackTrace();
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }

    /**
     * 删除用户，要检查用户是否为空、用户名是否为空
     * @param user
     * @throws UserCanNotBeNullException
     * @throws UserNameCanNotBeNullException
     */
    public void del(User user) throws UserCanNotBeNullException, UserNameCanNotBeNullException {
        if (null == user) {
            throw new UserCanNotBeNullException("User can not be null");
        }
        if (StringUtils.isEmpty(user.getLoginId())) {
            throw new UserNameCanNotBeNullException("User name can not be null");
        }
        int result = 0;
        try {
            userDao.del(user);
        } catch (Exception e) {
            System.out.println("删除用户失败,不存在该用户");
            e.printStackTrace();
        }
        if (result > 0)
            System.out.println("删除用户成功");
    }

    /**
     * 更新用户信息， 要检查用户是否为空
     * @param user
     * @throws UserCanNotBeNullException
     */
    public void update(User user) throws UserCanNotBeNullException {
        if (null == user){
            throw new UserCanNotBeNullException("user can not be null");
        }
        int result = 0;
        try {
            userDao.update(user);
        } catch (Exception e) {
            System.out.println("更新用户信息失败");
            e.printStackTrace();
        }
        if (result > 0)
            System.out.println("更新用户信息成功");
    }

    /**
     * 根据用户名查找用户
     * @param id
     */
    public User findOneById(Serializable id) {
        User result = null;
        try {
            result = userDao.findOneById(id);
        } catch (Exception e) {
            System.out.println("查找用户失败，该用户不存在");
            e.printStackTrace();
        }
        if (null != result) {
            System.out.println("查找用户成功\n" + result.toString());
        }
        return result;
    }
}

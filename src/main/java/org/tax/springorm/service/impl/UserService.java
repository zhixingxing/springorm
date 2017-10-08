package org.tax.springorm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tax.springorm.dao.IUserDao;
import org.tax.springorm.po.User;
import org.tax.springorm.service.IUserService;

@Transactional
public class UserService implements IUserService{
    private IUserDao userDao;
    
    public void saveUser() {
        User u1=new User();
        u1.setName("邵");
        u1.setAge(24);
        userDao.save(u1);
        User u2=new User();
        u2.setName("陈");
        u2.setAge(20);
        userDao.save(u2);
    }

    @Transactional(rollbackFor={Exception.class})
    public void saveUserThrowException() throws Exception {
        User u1=new User();
        u1.setName("邵");
        u1.setAge(24);
        userDao.save(u1);
        
        if(1+1>1){
            throw new Exception("Runtime error...");//抛出一般的异常：Exception
        }
        
        User u2=new User();
        u2.setName("陈");
        u2.setAge(20);
        userDao.save(u2);
        
    }
    
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true) 
    public void findUsers() {
        List<User> users=userDao.query("from User where name=?", new Object[]{"邵"});
        for (User user : users) {
            System.out.println(user);
        }
    }
    
    public IUserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
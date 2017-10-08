package org.tax.springorm.dao.impl;

import org.tax.springorm.dao.AbstractHibernateDao;
import org.tax.springorm.dao.IUserDao;
import org.tax.springorm.po.User;

public class UserDaoImpl extends AbstractHibernateDao<User> implements IUserDao {

    public UserDaoImpl() {
        super(User.class);
    }

}
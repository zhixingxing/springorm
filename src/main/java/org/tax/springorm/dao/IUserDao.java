package org.tax.springorm.dao;

import java.util.List;
import org.tax.springorm.po.User;
public interface IUserDao {
    public void save(User user);
    public List<User> query(String sql,Object[] args);
}

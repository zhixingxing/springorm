package org.tax.springorm.service;

public interface IUserService {
    void saveUser();
    void saveUserThrowException() throws Exception;
    void findUsers();
}
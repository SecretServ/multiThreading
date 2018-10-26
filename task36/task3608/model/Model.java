package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

/**
 * Created by BrigadaSSEE on 24.10.2018.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}

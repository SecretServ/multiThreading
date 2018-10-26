package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BrigadaSSEE on 25.10.2018.
 */

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    private List<User> getAllUsers() {
        List<User> list;
        list = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
        return list;
    }

    private UserService userService = new UserService() {
        @Override
        public User deleteUser(long id) {
            return userServiceImpl.deleteUser(id);
        }

        @Override
        public User createOrUpdateUser(String name, long id, int level) {
            return userServiceImpl.createOrUpdateUser(name, id, level);
        }

        @Override
        public List<User> getUsersByName(String name) {
            return userServiceImpl.getUsersByName(name);
        }

        @Override
        public List<User> getAllDeletedUsers() {
            return userServiceImpl.getAllDeletedUsers();
        }

        @Override
        public List<User> getUsersBetweenLevels(int fromLevel, int toLevel) {
            return userServiceImpl.getUsersBetweenLevels(fromLevel, toLevel);
        }

        @Override
        public List<User> filterOnlyActiveUsers(List<User> allUsers) {
            return userServiceImpl.filterOnlyActiveUsers(allUsers);
        }

        @Override
        public User getUsersById(long userId) {
            return userServiceImpl.getUsersById(userId);
        }
    };

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = new ArrayList<>();

        list = getAllUsers();

        modelData.setUsers(list);
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
        modelData.setDisplayDeletedUserList(false);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
        //modelData.setDisplayDeletedUserList(true);
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }
}

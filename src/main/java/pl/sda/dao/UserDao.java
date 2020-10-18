package pl.sda.dao;

import pl.sda.model.User;

public class UserDao extends AbstractDao<User>{

    public UserDao() {
        super(User.class);
    }
}

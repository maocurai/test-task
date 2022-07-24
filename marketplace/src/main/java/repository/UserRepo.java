package repository;

import exception.UserNotFoundException;
import model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepo {

    boolean save(User user);
    boolean delete(User user);
    User findById(Long id) throws UserNotFoundException;
    List<User> findAll();

    boolean update(User user, BigDecimal newBalance);
}

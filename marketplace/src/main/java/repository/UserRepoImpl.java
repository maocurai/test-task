package repository;

import data.DataSource;
import exception.UserNotFoundException;
import model.Product;
import model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class UserRepoImpl implements UserRepo {

    private static Long idGenerator = 0l;

    @Override
    public boolean save(User user) {
        user.setId(idGenerator);
        ++idGenerator;
        return DataSource.users.add(user);
    }

    @Override
    public boolean delete(User user) {
        return DataSource.users.remove(user);
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return DataSource.users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return DataSource.users;
    }

    @Override
    public boolean update(User user, BigDecimal newBalance) {
        User user1 = DataSource.users.stream().filter(x -> x.getId() == user.getId()).findFirst().get();
        user1.setBalance(newBalance);
        return true;
    }

    public void addProduct(User user, Product product) {
        DataSource.purchases.compute(user, (k, v) -> {
            if(v == null) {
                return new ArrayList<>() {{ add(product); }};
            } else {
                v.add(product);
                return v;
            }});
    }
}

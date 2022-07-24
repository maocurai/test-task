package data;

import model.Product;
import model.User;

import java.math.BigDecimal;
import java.util.*;

public class DataSource {

    public static Map<User, List<Product>> purchases = new LinkedHashMap();
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList();
}

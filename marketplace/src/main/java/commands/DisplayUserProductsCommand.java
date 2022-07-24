package commands;

import data.DataSource;
import data.SystemMessages;
import exception.UserNotFoundException;
import model.Product;
import repository.UserRepoImpl;

import java.security.MessageDigest;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Command(command = "8")
public class DisplayUserProductsCommand implements ICommand {

    private UserRepoImpl userRepo = new UserRepoImpl();

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println(SystemMessages.INPUT_USER_ID.getMessage());
            Long id = sc.nextLong();

            List<Product> products = DataSource.purchases.get(userRepo.findById(id));

            if(products == null) {
                System.out.println(SystemMessages.NOTHING_TO_SHOW.getMessage());
            } else {
                System.out.println(SystemMessages.PRODUCT_LIST.getMessage());
                products.stream().forEach(System.out::println);
            }

        } catch (InputMismatchException e) {
            System.out.println(SystemMessages.VALUE_MUST_BE_NUMBER.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());;
        }

    }
}

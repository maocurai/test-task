package commands;

import data.SystemMessages;
import exception.NotEnoughMoneyException;
import exception.ProductNotFoundException;
import exception.UserNotFoundException;
import model.Product;
import model.User;
import repository.ProductRepoImpl;
import repository.UserRepoImpl;

import java.util.Scanner;

@Command(command = "7")
public class BuyProductCommand implements ICommand {

    private UserRepoImpl userRepo = new UserRepoImpl();

    private ProductRepoImpl productRepo = new ProductRepoImpl();


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("To buy product\n" + SystemMessages.INPUT_USER_ID.getMessage());
            User userById = userRepo.findById(scanner.nextLong());
            System.out.println(SystemMessages.INPUT_PRODUCT_ID.getMessage());
            Product productById = productRepo.findById(scanner.nextLong());
            if(userById.getBalance().compareTo(productById.getPrice()) == -1) throw new NotEnoughMoneyException();
            userRepo.update(userById, (userById.getBalance().subtract(productById.getPrice())));
            userRepo.addProduct(userById, productById);
            System.out.println(SystemMessages.SUCCESS.getMessage());

        } catch (UserNotFoundException | ProductNotFoundException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}

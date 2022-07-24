package commands;

import data.DataSource;
import data.SystemMessages;
import exception.ProductNotFoundException;
import model.Product;
import model.User;
import repository.ProductRepoImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Command(command = "9")
public class DisplayProductBuyersCommand implements ICommand {

    private ProductRepoImpl productRepo = new ProductRepoImpl();

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println(SystemMessages.INPUT_PRODUCT_ID.getMessage());
            Long id = sc.nextLong();

            Product productById = productRepo.findById(id);

            System.out.println(SystemMessages.USER_LIST.getMessage());

            List<User> collect = DataSource.purchases.entrySet().stream()
                    .filter(x -> x.getValue().contains(productById))
                    .map(x -> x.getKey())
                    .collect(Collectors.toList());

            if(collect.isEmpty()) {
                System.out.println(SystemMessages.NOTHING_TO_SHOW.getMessage());
            } else {
                collect.stream().forEach(System.out::println);
            }

        } catch (InputMismatchException e) {
            System.out.println(SystemMessages.VALUE_MUST_BE_NUMBER.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

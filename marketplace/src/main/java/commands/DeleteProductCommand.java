package commands;

import data.SystemMessages;
import exception.ProductNotFoundException;
import repository.ProductRepoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

@Command(command = "6")
public class DeleteProductCommand implements ICommand {

    private ProductRepoImpl productRepo = new ProductRepoImpl();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(SystemMessages.INPUT_PRODUCT_ID.getMessage());
            Long id = scanner.nextLong();

            productRepo.delete(productRepo.findById(id));
            System.out.println(SystemMessages.SUCCESS.getMessage());

        } catch (InputMismatchException e) {
            System.out.println(SystemMessages.VALUE_MUST_BE_NUMBER.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

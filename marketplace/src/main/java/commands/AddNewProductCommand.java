package commands;

import data.SystemMessages;
import exception.FalseInputException;
import model.Product;
import repository.ProductRepoImpl;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

@Command(command = "5")
public class AddNewProductCommand implements ICommand {

    private ProductRepoImpl productRepo = new ProductRepoImpl();

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {
            Product newProduct = new Product();

            System.out.println(SystemMessages.INPUT_PRODUCT_NAME.getMessage());
            newProduct.setName(checkName(sc.nextLine()));

            System.out.println(SystemMessages.INPUT_PRICE.getMessage());
            BigDecimal bigDecimal = sc.nextBigDecimal();
            if (bigDecimal.compareTo(BigDecimal.valueOf(0)) == -1) throw new FalseInputException(SystemMessages.NUMBER_IS_LESS_THAN_ZERO.getMessage());

            newProduct.setPrice(bigDecimal);
            productRepo.save(newProduct);
            System.out.println(SystemMessages.SUCCESS.getMessage());

        } catch (FalseInputException e) {
            System.out.println(e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println(SystemMessages.VALUE_MUST_BE_NUMBER.getMessage());
        }
    }

    private String checkName(String name) throws FalseInputException {
        if (name.length() < 2 || !name.matches("(^[A-Z]{1}[a-z]+$)|(^[А-Я]{1}[а-я]+$)")) {
            throw new FalseInputException(SystemMessages.NAME_FAILURE.getMessage());
        } else {
            return name;
        }
    }
}

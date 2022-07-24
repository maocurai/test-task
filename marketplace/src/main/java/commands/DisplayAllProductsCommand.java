package commands;

import data.SystemMessages;
import repository.ProductRepoImpl;

@Command(command = "4")
public class DisplayAllProductsCommand implements ICommand {

    private ProductRepoImpl productRepo = new ProductRepoImpl();

    @Override
    public void execute() {
        if(productRepo.findAll().size() == 0) {
            System.out.println(SystemMessages.NOTHING_TO_SHOW.getMessage());
        } else {
            System.out.println(SystemMessages.PRODUCT_LIST.getMessage());
            productRepo.findAll().forEach(System.out::println);
        }
    }
}

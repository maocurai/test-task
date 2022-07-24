package commands;

import data.SystemMessages;

import java.util.List;

@Command(command = "showMenu")
public class ShowMenuCommand implements ICommand {

    private List<String> menuItems = List.of("1. Display list of all users", "2. Add new user", "3. Delete user", "4. Display list of all products",
            "5. Add new product", "6. Delete product", "7. Buy product", "8. Display list of user products",
            "9. Display list of users that bought product", "q. Quit");

    @Override
    public void execute() {
        System.out.println();
        menuItems.stream().forEach(System.out::println);
        System.out.print(SystemMessages.SELECT_AN_OPTION.getMessage());
    }
}

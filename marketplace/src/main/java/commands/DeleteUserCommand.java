package commands;

import data.SystemMessages;
import exception.UserNotFoundException;
import repository.UserRepoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

@Command(command = "3")
public class DeleteUserCommand implements ICommand {

    private UserRepoImpl userRepo = new UserRepoImpl();

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(SystemMessages.INPUT_USER_ID.getMessage());
            Long id = sc.nextLong();

            userRepo.delete(userRepo.findById(id));
            System.out.println(SystemMessages.SUCCESS.getMessage());

        } catch (InputMismatchException e) {
            System.out.println(SystemMessages.VALUE_MUST_BE_NUMBER.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

package commands;

import data.SystemMessages;
import repository.UserRepoImpl;

@Command(command = "1")
public class DisplayAllUsersCommand implements ICommand {

    private UserRepoImpl userRepo = new UserRepoImpl();

    @Override
    public void execute() {
        if(userRepo.findAll().size() == 0) {
            System.out.println(SystemMessages.NOTHING_TO_SHOW.getMessage());
        } else {
            System.out.println(SystemMessages.USER_LIST.getMessage());
            userRepo.findAll().forEach(System.out::println);
        }
    }
}

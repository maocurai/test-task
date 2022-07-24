package commands;

import data.SystemMessages;

@Command(command = "unregisteredCommand")
public class UnregisteredCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println(SystemMessages.COMMAND_NOT_EXISTS.getMessage());
    }
}

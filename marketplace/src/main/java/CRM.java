import commands.Command;
import commands.ICommand;
import commands.UnregisteredCommand;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class CRM {

    private Map<String, ICommand> commands = new HashMap<>();

    public void startApplication() {
        findAllCommands();
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            if (commands.containsKey("showMenu")) {
                commands.get("showMenu").execute();
            } else {
                new UnregisteredCommand().execute();
            }
            try {
                String data = scanner.nextLine();
                if(data.equals("q")) break;
                i = Integer.parseInt(data);
            } catch (InputMismatchException | NumberFormatException e) {
                new UnregisteredCommand().execute();
                continue;
            }

            if (commands.containsKey(Integer.valueOf(i).toString())) {
                commands.get(Integer.valueOf(i).toString()).execute();
            } else {
                new UnregisteredCommand().execute();
            }

        } while (true);
        System.out.println("Thank for work with our product!");
    }

    private void findAllCommands(){
        Reflections reflections = new Reflections("commands", new SubTypesScanner(false));
        Set<Class> classes = reflections.getSubTypesOf(Object.class).stream().collect(Collectors.toSet());
        for(Class cls : classes) {
            boolean isInterfaceImplemented = Arrays.stream(cls.getInterfaces()).anyMatch(x -> x.getSimpleName().equals("ICommand"));
            if(isInterfaceImplemented){
                    try {
                        String commandName = (String) cls
                                .getDeclaredAnnotation(Command.class)
                                .getClass()
                                .getMethod("command")
                                .invoke(cls.getAnnotation(Command.class));

                        ICommand inst = (ICommand)(cls.getConstructor().newInstance());
                        commands.put(commandName, inst);
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}

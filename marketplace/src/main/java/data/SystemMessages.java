package data;

public enum SystemMessages  {

    SUCCESS("Success"),
    NAME_FAILURE("Name is empty, has less than two characters, starts with lowercase or contains invalid characters"),
    NOTHING_TO_SHOW("Nothing to show"),
    VALUE_MUST_BE_NUMBER("Value must be a number"),
    SELECT_AN_OPTION("\nSelect an option : "),
    COMMAND_NOT_EXISTS("Command not exists"),
    INPUT_PRODUCT_NAME("Enter product name: "),
    INPUT_PRICE("Enter price: "),
    NUMBER_IS_LESS_THAN_ZERO("Values less than 0 are not allowed"),
    INPUT_USER_ID("Enter user id : "),
    INPUT_PRODUCT_ID("Enter product id : "),
    USER_LIST("\nList of users : "),
    PRODUCT_LIST("\nList of products : ");


    private final String message;


    SystemMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

package model;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal balance = BigDecimal.valueOf(0);

    public User(String firstName, String lastName, BigDecimal balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nId : " + id + "\nFirst name : " + firstName + "\nLast name : " + lastName + "\nBalance : " + balance;
    }

}

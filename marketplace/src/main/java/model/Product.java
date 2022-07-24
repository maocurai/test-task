package model;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@NoArgsConstructor
@Getter @Setter
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nId : " + id + "\nName : " + name + "\nPrice : " + price;
    }

}

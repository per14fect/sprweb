package model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sweet {
    Long id;
    String name;
    Integer count;
    BigDecimal price;
}

package model;

import lombok.Data;

@Data
public class Car {
    private int discount = 100;
    private Person person;
}

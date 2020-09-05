package banking.entities;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private int Number;

    @OneToOne
    private Person person;

    public Address() {

    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    @Override
    public String toString() {
        return "Address(" +
                "street = " + street + '\'' +
                ", Number = " + Number +
                ')';
    }



}

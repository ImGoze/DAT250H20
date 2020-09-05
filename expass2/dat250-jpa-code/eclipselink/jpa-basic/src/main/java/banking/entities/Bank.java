package banking.entities;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank(" +
                "name = '" + name + '\'' +
                ')';
    }
}

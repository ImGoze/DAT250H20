package banking.entities;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;
    private int limit;
    private int balance;

    @OneToOne
    private Bank bank;

    @OneToOne
    private PinCode pinCode;

    public CreditCard() {

    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public void setPinCode(PinCode pinCode) {
        this.pinCode = pinCode;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLimit() {
        return limit;
    }

    public PinCode getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "CreditCard(" +
                "number = " + number +
                ", limit = " + limit +
                ", balance=" + balance +
                ", bank=" + bank +
                ", pinCode=****" +
                ')';
    }
}


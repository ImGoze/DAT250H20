package banking.entities;

import javax.persistence.*;

@Entity
public class PinCode {
    @Id
    @GeneratedValue
    private int id;
    private int pincode;
    private int count;

    public PinCode() {

    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getCount() {
        return count;
    }
}

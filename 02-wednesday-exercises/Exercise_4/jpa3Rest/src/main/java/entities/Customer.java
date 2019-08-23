package entities;

/**
 *
 * @author martin
 */
public class Customer {
    private String type;
    private int birthday;
    private String sound;

    public Customer() {
    }

    public Customer(String type, int birthday, String sound) {
        this.type = type;
        this.birthday = birthday;
        this.sound = sound;
    }
    
    
}

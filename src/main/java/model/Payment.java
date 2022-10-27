package model;

public class Payment {
    private int id;
    private double value;
    private boolean paid;
    //constructors
    public Payment(int id, double value, boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
    }
    ///getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    @Override
    public String toString() {
        if (this.paid) {
            return "Payment{" +
                    "id=" + id +
                    ", value=" + value +
                    ", is paid}";
        }else {
            return "Payment{" +
                    "id=" + id +
                    ", value=" + value +
                    ", is pending}";
        }
    }
}

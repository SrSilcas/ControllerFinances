package model;

public class Payment {
    private int id;
    private int month;
    private int year;
    private double value;
    private boolean paid;
    //constructors
    public Payment(int id, int month, int year, double value, boolean paid) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.value = value;
        this.paid = paid;
    }
    public Payment() {
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
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
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

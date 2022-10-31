package model;

public class Payment {
    private int id;
    private int month;
    private int year;
    private double value;
    private boolean status;
    //constructors
    public Payment(int id, int month, int year, double value, boolean status) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.value = value;
        this.status = status;
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
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
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
        if (this.status) {
            return "Payment{" +
                    "id= " + id +
                    ", value= R$" + value +
                    ", is paid}";
        }else {
            return "Payment{" +
                    "id= " + id +
                    ", value= R$" + value +
                    ", is pending}";
        }
    }
}

package model;

public class Expense {

    private int id;
    private int idPayment;
    private int month;
    private int year;
    private double value;
    private String usedProducts;
    //constructors
    public Expense(int id, int idPayment, int month, int year, double value, String usedProducts) {
        this.id = id;
        this.idPayment = idPayment;
        this.month = month;
        this.year = year;
        this.value = value;
        this.usedProducts = usedProducts;
    }
    public Expense(Payment payment) {
        this.idPayment = payment.getId();
        this.month = payment.getMonth();
        this.year = payment.getYear();
    }
    public Expense() {
    }
    //getters and setters
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
    public String getUsedProducts() {
        return usedProducts;
    }
    public void setUsedProducts(String usedProducts) {
        this.usedProducts = usedProducts;
    }
    public int getIdPayment() {
        return idPayment;
    }
    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
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
        return "Expense{" +
                "id=" + id +
                ", value=" + value +
                ", usedProducts='" + usedProducts + '\'' +
                '}';
    }
}

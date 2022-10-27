package model;

public class Expense {

    private int id;
    private int idPayment;
    private double value;
    private String usedProducts;
    //constructors
    public Expense(int id, int idPayment, double value, String usedProducts) {
        this.id = id;
        this.idPayment = idPayment;
        this.value = value;
        this.usedProducts = usedProducts;
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
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", value=" + value +
                ", usedProducts='" + usedProducts + '\'' +
                '}';
    }
}

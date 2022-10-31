package org.example;


import controller.ExpenseDAO;
import controller.PaymentDAO;

public class Main {
    public static void main(String[] args) {
//        Payment payment1 = new Payment();
//        payment1.setMonth(8);
//        payment1.setYear(22);
//        payment1.setValue(122.52);
//        payment1.setStatus(false);
//
//        Expense expense1 = new Expense();
//        expense1.setIdPayment(1);
//        expense1.setMonth(8);
//        expense1.setYear(22);
//        expense1.setValue(52.00);
//        expense1.setUsedProducts("teste, teste, teste");
//
//        PaymentController.save(payment1);
//        ExpenseController.save(expense1);
//        System.out.println(payment1);
//        System.out.println(expense1);
        System.out.println(PaymentDAO.getAll());
        System.out.println(ExpenseDAO.getAll());

    }
}
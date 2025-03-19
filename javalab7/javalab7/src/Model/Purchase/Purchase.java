package Model.Purchase;
import Model.Customers.*;
import Model.Products.*;

public class Purchase {
    Customers c_temp;
    Products p_temp;
    String purchase_date;
    int Product_charges;

    public Purchase(Customers c, Products p, String p_date, int charges)
    {
        setp_temp(p);
        setC_temp(c);
        setPurchase_date(p_date);
        setProduct_charges(charges);
    }

    public void setp_temp(Products p_temp) {
        this.p_temp = p_temp;
    }

    public void setC_temp(Customers c_temp) {
        this.c_temp = c_temp;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public void setProduct_charges(int product_charges) {
        this.Product_charges =product_charges;
    }

    public Customers getc_temp() {
        return c_temp;
    }

    public Products getp_temp() {
        return p_temp;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public int getProduct_charges() {
        return Product_charges;
    }
}

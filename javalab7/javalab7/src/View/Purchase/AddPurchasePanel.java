package View.Purchase;

import javax.swing.*;

public class AddPurchasePanel extends JPanel {


    JTextField txt_customer_id;
    JTextField txt_product_id;
    JTextField txt_purchase_date;
    JTextField txt_product_charges;
    JButton addPurchaseBtn;

    public AddPurchasePanel()
    {
        txt_customer_id = new JTextField();
        txt_product_id = new JTextField();
        txt_purchase_date = new JTextField();
        txt_product_charges = new JTextField();

        addPurchaseBtn = new JButton("Add Purchase");

        txt_customer_id.setText("txt_customer_id");
        txt_product_id.setText("txt_product_id");
        txt_purchase_date.setText("txt_purchase_date");
        txt_product_charges.setText("txt_product_charges");

        add(txt_customer_id);
        add(txt_product_id);
        add(txt_purchase_date);
        add(txt_product_charges);

        add(addPurchaseBtn);
    }

    public JTextField getTxt_customer_id() {
        return txt_customer_id;
    }

    public void setTxt_customer_id(JTextField txt_customer_id) {
        this.txt_customer_id = txt_customer_id;
    }

    public JTextField getTxt_product_id() {
        return txt_product_id;
    }

    public void setTxt_product_id(JTextField txt_product_id) {
        this.txt_product_id = txt_product_id;
    }

    public JTextField getTxt_purchase_date() {
        return txt_purchase_date;
    }

    public void getTxt_purchase_date(JTextField txt_purchase_date) {
        this.txt_purchase_date = txt_purchase_date;
    }

    public JTextField getTxt_product_charges() {
        return txt_product_charges;
    }

    public void setTxt_product_charges(JTextField txt_product_charges) {
        this.txt_product_charges = txt_product_charges;
    }

    public JButton getAddPurchaseBtn() {
        return addPurchaseBtn;
    }

    public void setAddPurchaseBtn(JButton addPurchaseBtn) {
        this.addPurchaseBtn = addPurchaseBtn;
    }


}

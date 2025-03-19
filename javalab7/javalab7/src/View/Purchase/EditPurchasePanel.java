package View.Purchase;

import javax.swing.*;

public class EditPurchasePanel extends JPanel {


    JTextField txt_get_purchase_idx;
    JButton getPurchaseBtn;
    JTextField txt_customer_id;
    JTextField txt_product_id;
    JTextField txt_purchase_date;
    JTextField txt_product_charges;
    JButton editPurchaseBtn;

    public EditPurchasePanel()
    {

        txt_customer_id = new JTextField();
        txt_product_id = new JTextField();
        txt_purchase_date = new JTextField();
        txt_product_charges = new JTextField();
        editPurchaseBtn = new JButton("Edit Purchase");
        txt_get_purchase_idx = new JTextField();
        getPurchaseBtn = new JButton("Get Purchase to Edit");

        txt_customer_id.setText("txt_customer_id");
        txt_product_id.setText("txt_product_id");
        txt_purchase_date.setText("txt_purchase_date");
        txt_product_charges.setText("txt_product_charges");
        txt_get_purchase_idx.setText("get Purchase idx");

        txt_customer_id.setEditable(false);
        txt_product_id.setEditable(false);

        add(txt_get_purchase_idx);
        add(getPurchaseBtn);

        add(txt_customer_id);
        add(txt_product_id);
        add(txt_purchase_date);
        add(txt_product_charges);
        add(editPurchaseBtn);
    }


    public JTextField getTxt_get_purchase_idx() {
        return txt_get_purchase_idx;
    }

    public void setTxt_get_purchase_idx(JTextField txt_get_purchase_idx) {
        this.txt_get_purchase_idx = txt_get_purchase_idx;
    }

    public JButton getGetPurchaseBtn() {
        return getPurchaseBtn;
    }

    public void setGetPurchaseBtn(JButton getPurchaseBtn) {
        this.getPurchaseBtn = getPurchaseBtn;
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

    public void setTxt_purchase_date(JTextField txt_purchase_date) {
        this.txt_purchase_date = txt_purchase_date;
    }

    public JTextField getTxt_product_charges() {
        return txt_product_charges;
    }

    public void setTxt_product_charges(JTextField txt_product_charges) {
        this.txt_product_charges = txt_product_charges;
    }

    public JButton getEditPurchaseBtn() {
        return editPurchaseBtn;
    }

    public void setEditPurchaseBtn(JButton editPurchaseBtn) {
        this.editPurchaseBtn = editPurchaseBtn;
    }

}

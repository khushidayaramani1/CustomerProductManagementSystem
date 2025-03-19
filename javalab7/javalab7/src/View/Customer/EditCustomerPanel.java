package View.Customer;

import javax.swing.*;

public class EditCustomerPanel extends JPanel {
    JTextField txt_get_customer_idx;
    JButton getCustomerBtn;
    JTextField txt_customer_id;
    JTextField txt_customer_fname;
    JTextField txt_customer_lname;
    JTextField txt_customer_email;
    JTextField txt_customer_address;
    JTextField txt_customer_mobile;
    JTextField txt_customer_budget;
    JButton editCustomerBtn;

    public EditCustomerPanel()
    {
        txt_customer_id = new JTextField();
        txt_get_customer_idx = new JTextField();
        txt_customer_fname = new JTextField();
        txt_customer_lname = new JTextField();
        txt_customer_email = new JTextField();
        txt_customer_address = new JTextField();
        txt_customer_mobile = new JTextField();
        txt_customer_budget = new JTextField();
        getCustomerBtn = new JButton("Get Customer to Edit");
        editCustomerBtn = new JButton("Edit Customer");

        txt_get_customer_idx.setText("get customer id");
        txt_customer_id.setText("txt_customer_id");
        txt_customer_fname.setText("txt_customer_fname");
        txt_customer_lname.setText("txt_customer_lname");
        txt_customer_email.setText("txt_customer_email");
        txt_customer_address.setText("txt_customer_address");
        txt_customer_mobile.setText("txt_customer_mobile");
        txt_customer_budget.setText("txt_customer_budget");

        add(txt_get_customer_idx);
        add(getCustomerBtn);

        add(txt_customer_id);
        add(txt_customer_fname);
        add(txt_customer_lname);
        add(txt_customer_email);
        add(txt_customer_address);
        add(txt_customer_mobile);
        add(txt_customer_budget);
        add(editCustomerBtn);
    }

    public JTextField getTxt_get_customer_idx() {
        return txt_get_customer_idx;
    }

    public void setTxt_get_customer_idx(JTextField txt_get_customer_idx) {
        this.txt_get_customer_idx = txt_get_customer_idx;
    }

    public JButton getGetCustomerBtn() {
        return getCustomerBtn;
    }

    public void setGetCustomerBtn(JButton getCustomerBtn) {
        this.getCustomerBtn = getCustomerBtn;
    }

    public JTextField getTxt_customer_id() {
        return txt_customer_id;
    }

    public void setTxt_customer_id(JTextField txt_customer_id) {
        this.txt_customer_id = txt_customer_id;
    }

    public JTextField getTxt_customer_fname() {
        return txt_customer_fname;
    }

    public void setTxt_customer_fname(JTextField txt_customer_fname) {
        this.txt_customer_fname = txt_customer_fname;
    }

    public JTextField getTxt_customer_lname() {
        return txt_customer_lname;
    }

    public void setTxt_customer_lname(JTextField txt_customer_lname) {
        this.txt_customer_lname = txt_customer_lname;
    }

    public JTextField getTxt_customer_email() {
        return txt_customer_email;
    }

    public void setTxt_customer_email(JTextField txt_customer_email) {
        this.txt_customer_email = txt_customer_email;
    }

    public JTextField getTxt_customer_address() {
        return txt_customer_address;
    }

    public void setTxt_customer_address(JTextField txt_customer_address) {
        this.txt_customer_address = txt_customer_address;
    }

    public JTextField getTxt_customer_mobile() {
        return txt_customer_mobile;
    }

    public void setTxt_customer_mobile(JTextField txt_customer_mobile) {
        this.txt_customer_mobile = txt_customer_mobile;
    }

    public JTextField getTxt_customer_budget() {
        return txt_customer_budget;
    }

    public void setTxt_customer_budget(JTextField txt_customer_budget) {
        this.txt_customer_budget = txt_customer_budget;
    }

    public JButton getEditCustomerBtn() {
        return editCustomerBtn;
    }

    public void setEditCustomerBtn(JButton editCustomerBtn) {
        this.editCustomerBtn = editCustomerBtn;
    }



}

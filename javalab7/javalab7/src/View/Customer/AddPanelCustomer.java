package View.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddPanelCustomer extends JPanel {
    JTextField txt_fname;
    JTextField txt_lname;
    JTextField txt_email;
    JTextField txt_address;
    JTextField txt_mobile;
    JTextField txt_budget;
    JTextField txt_id;
    JButton addCustomerBtn;

    public AddPanelCustomer()
    {
        txt_fname = new JTextField();
        txt_lname = new JTextField();
        txt_email = new JTextField();
        txt_address = new JTextField();
        txt_mobile = new JTextField();
        txt_budget = new JTextField();
        txt_id = new JTextField();
        addCustomerBtn = new JButton("Add Customer");

        txt_fname.setText("txt_fname");
        txt_lname.setText("txt_lname");
        txt_email.setText("txt_email");
        txt_address.setText("txt_address");
        txt_mobile.setText("txt_mobile");
        txt_budget.setText("txt_budget");
        txt_id.setText("txt_id");

        add(txt_id);
        add(txt_fname);
        add(txt_lname);
        add(txt_email);
        add(txt_address);
        add(txt_mobile);
        add(txt_budget);


        add(addCustomerBtn);

    }

    public JTextField getTxt_id() {
        return txt_id;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public JTextField getTxt_fname() {
        return txt_fname;
    }

    public void setTxt_fname(JTextField txt_fname) {
        this.txt_fname = txt_fname;
    }

    public JTextField getTxt_lname() {
        return txt_lname;
    }

    public void setTxt_lname(JTextField txt_lname) {
        this.txt_lname = txt_lname;
    }

    public JTextField getTxt_email() {
        return txt_email;
    }

    public void setTxt_email(JTextField txt_email) {
        this.txt_email = txt_email;
    }

    public JTextField getTxt_address() {
        return txt_address;
    }

    public void setTxt_address(JTextField txt_address) {
        this.txt_address = txt_address;
    }

    public JTextField getTxt_mobile() {
        return txt_mobile;
    }

    public void setTxt_mobile(JTextField txt_mobile) {
        this.txt_mobile = txt_mobile;
    }

    public JTextField getTxt_budget() {
        return txt_budget;
    }

    public void setTxt_budget(JTextField txt_budget) {
        this.txt_budget = txt_budget;
    }

    public JButton getAddCustomerBtn() {
        return addCustomerBtn;
    }

    public void setAddCustomerBtn(JButton addCustomerBtn) {
        this.addCustomerBtn = addCustomerBtn;
    }
}

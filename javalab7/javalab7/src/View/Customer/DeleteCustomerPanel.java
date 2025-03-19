package View.Customer;

import javax.swing.*;

public class DeleteCustomerPanel extends JPanel {
    JTextField txt_del_customer_id;
    JButton deleteCustomerBtn;
    public DeleteCustomerPanel()
    {
        txt_del_customer_id = new JTextField();
        deleteCustomerBtn = new JButton("Delete Customer");

        txt_del_customer_id.setText("txt_customer_id");

        add(txt_del_customer_id);
        add(deleteCustomerBtn);
    }

    public JButton getDeleteCustomerBtn() {
        return deleteCustomerBtn;
    }

    public JTextField getTxt_del_customer_id() {
        return txt_del_customer_id;
    }

    public void setDeleteCustomerBtn(JButton deleteCustomerBtn) {
        this.deleteCustomerBtn = deleteCustomerBtn;
    }

    public void setTxt_del_customer_id(JTextField txt_del_customer_id) {
        this.txt_del_customer_id = txt_del_customer_id;
    }
}

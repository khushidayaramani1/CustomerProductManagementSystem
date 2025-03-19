package View.Product;

import javax.swing.*;

public class DeleteProductPanel extends JPanel {
    JTextField txt_del_product_id;
    JButton deleteProductBtn;
    public DeleteProductPanel()
    {
        txt_del_product_id = new JTextField();
        deleteProductBtn = new JButton("Delete Product");

        txt_del_product_id.setText("txt_product_id");

        add(txt_del_product_id);
        add(deleteProductBtn);

    }

    public JButton getDeleteProductBtn() {
        return deleteProductBtn;
    }

    public void setDeleteProductBtn(JButton deleteProductBtn) {
        this.deleteProductBtn = deleteProductBtn;
    }

    public JTextField getTxt_del_product_id() {
        return txt_del_product_id;
    }

    public void setTxt_del_product_id(JTextField txt_del_product_id) {
        this.txt_del_product_id = txt_del_product_id;
    }
}

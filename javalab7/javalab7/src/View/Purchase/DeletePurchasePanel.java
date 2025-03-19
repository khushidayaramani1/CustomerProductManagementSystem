package View.Purchase;

import javax.swing.*;

public class DeletePurchasePanel extends JPanel {
    JTextField txt_del_purchase_idx;
    JButton deletePurchaseBtn;

    public DeletePurchasePanel()
    {

        txt_del_purchase_idx = new JTextField();
        deletePurchaseBtn = new JButton("Delete Purchase");

        txt_del_purchase_idx.setText("txt_purchase_idx");

        add(txt_del_purchase_idx);
        add(deletePurchaseBtn);
    }


    public JButton getDeletePurchaseBtn() {
        return deletePurchaseBtn;
    }

    public void setDeletePurchaseBtn(JButton deletePurchaseBtn) {
        this.deletePurchaseBtn = deletePurchaseBtn;
    }

    public JTextField getTxt_del_purchase_idx() {
        return txt_del_purchase_idx;
    }

    public void setTxt_del_purchase_idx(JTextField txt_del_purchase_idx) {
        this.txt_del_purchase_idx = txt_del_purchase_idx;
    }
}

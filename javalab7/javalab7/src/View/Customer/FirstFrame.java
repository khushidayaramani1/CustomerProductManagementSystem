package View.Customer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FirstFrame extends JFrame {
    JButton manageCustomerBtn;
    JButton manageProductBtn;
    JButton managePurchaseBtn;
    JPanel firstPanel;

    public FirstFrame() {
        super("Main DashBoard");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        manageCustomerBtn = new JButton("Manage Customer");
        manageProductBtn = new JButton("Manage Product");
        managePurchaseBtn = new JButton("Manage Purchase");

        Border cyanBorder = BorderFactory.createLineBorder(Color.CYAN, 50);
        Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 50);
        Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 50);

        // Set different colored borders to buttons
        manageCustomerBtn.setBorder(cyanBorder);
        manageProductBtn.setBorder(greenBorder);
        managePurchaseBtn.setBorder(yellowBorder);


        firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(3, 1, 20, 20));
        firstPanel.add(manageCustomerBtn);
        firstPanel.add(manageProductBtn);
        firstPanel.add(managePurchaseBtn);

        add(firstPanel);
        pack();
        setSize(500, 600);
        setVisible(true);
    }

    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }

    public void setManageCustomerBtn(JButton manageCustomerBtn) {
        this.manageCustomerBtn = manageCustomerBtn;
    }

    public void setManageProductBtn(JButton manageProductBtn) {
        this.manageProductBtn = manageProductBtn;
    }

    public void setManagePurchaseBtn(JButton managePurchaseBtn) {
        this.managePurchaseBtn = managePurchaseBtn;
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public JButton getManageCustomerBtn() {
        return manageCustomerBtn;
    }

    public JButton getManagePurchaseBtn() {
        return managePurchaseBtn;
    }

    public JButton getManageProductBtn() {
        return manageProductBtn;
    }
}











package View.Purchase;

import javax.swing.*;

public class ManagePurchaseFrame extends JFrame {
    InitialPanelPurchase enroll_ip;
    public ManagePurchaseFrame()
    {
        super("Manage Purchase DashBoard");
        enroll_ip = new InitialPanelPurchase();
        add(enroll_ip);
        pack();
        setSize(500,600);
    }

    public void setEnroll_ip(InitialPanelPurchase enroll_ip) {
        this.enroll_ip = enroll_ip;
    }

    public InitialPanelPurchase getEnroll_ip() {
        return enroll_ip;
    }
}

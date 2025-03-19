package View.Product;

import javax.swing.*;

public class ManageProductFrame extends JFrame {
    InitialPanelProduct prod_ip;
    public ManageProductFrame()
    {
        super("Manage Product DashBoard");
        prod_ip = new InitialPanelProduct();
        add(prod_ip);
        pack();
        setSize(500,600);
    }

    public void setProd_ip(InitialPanelProduct prod_ip) {
        this.prod_ip = prod_ip;
    }

    public InitialPanelProduct getProd_ip() {
        return prod_ip;
    }
}

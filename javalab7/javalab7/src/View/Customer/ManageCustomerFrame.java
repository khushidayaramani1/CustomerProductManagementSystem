package View.Customer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class ManageCustomerFrame extends JFrame{
    InitialPanelCustomer ip;
    public ManageCustomerFrame()
    {
        super("Manage Customer DashBoard");
        ip = new InitialPanelCustomer();
        add(ip);
        pack();
        setSize(500,600);
    }

    public void setIp(InitialPanelCustomer ip) {
        this.ip = ip;
    }

    public InitialPanelCustomer getIp() {
        return ip;
    }
}

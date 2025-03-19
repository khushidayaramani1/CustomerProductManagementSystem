package View.Customer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class InitialPanelCustomer extends JPanel {
    private CenterPanelCustomer cp;
    private AddPanelCustomer aps;

    private EditCustomerPanel ecp;

    private DeleteCustomerPanel dcp;

    public InitialPanelCustomer()
    {
        super();
        cp = new CenterPanelCustomer();
        add(cp);
        aps = new AddPanelCustomer();
        add(aps);
        dcp = new DeleteCustomerPanel();
        add(dcp);
        ecp = new EditCustomerPanel();
        add(ecp);
    }

    public CenterPanelCustomer getCp() {
        return cp;
    }

    public void setCp(CenterPanelCustomer cp) {
        this.cp = cp;
    }

    public AddPanelCustomer getAps() {
        return aps;
    }

    public void setAps(AddPanelCustomer aps) {
        this.aps = aps;
    }

    public DeleteCustomerPanel getDcp() {
        return dcp;
    }

    public void setDcp(DeleteCustomerPanel dcp) {
        this.dcp = dcp;
    }

    public EditCustomerPanel getEcp() {
        return ecp;
    }

    public void setEcp(EditCustomerPanel ecp) {
        this.ecp = ecp;
    }
}

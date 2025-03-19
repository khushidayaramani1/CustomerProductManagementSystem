package View.Purchase;

import javax.swing.*;

public class InitialPanelPurchase extends JPanel {


    private PurchaseTablePanel etp;
    private AddPurchasePanel ape;
    private EditPurchasePanel eep;
    private DeletePurchasePanel dep;

    public InitialPanelPurchase() {
        super();
        etp = new PurchaseTablePanel();
        add(etp);
        ape = new AddPurchasePanel();
        add(ape);
        eep = new EditPurchasePanel();
        add(eep);
        dep = new DeletePurchasePanel();
        add(dep);
    }

    public PurchaseTablePanel getEtp() {
        return etp;
    }

    public void setEtp(PurchaseTablePanel etp) {
        this.etp = etp;
    }

    public AddPurchasePanel getApe() {
        return ape;
    }

    public void setApe(AddPurchasePanel ape) {
        this.ape = ape;
    }

    public EditPurchasePanel getEep() {
        return eep;
    }

    public void setEep(EditPurchasePanel eep) {
        this.eep = eep;
    }

    public DeletePurchasePanel getDep() {
        return dep;
    }

    public void setDep(DeletePurchasePanel dep) {
        this.dep = dep;
    }


}


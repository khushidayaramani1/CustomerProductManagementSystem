package View.Product;

import javax.swing.*;

public class InitialPanelProduct extends JPanel {
    private ProductTablePanel ptp;
    private AddProductPanel app;
    private DeleteProductPanel dpp;
    private EditProductPanel epp;

    public InitialPanelProduct()
    {
        super();
        ptp = new ProductTablePanel();
        add(ptp);
        app = new AddProductPanel();
        add(app);
        dpp = new DeleteProductPanel();
        add(dpp);
        epp = new EditProductPanel();
        add(epp);

    }

    public ProductTablePanel getPtp() {
        return ptp;
    }

    public EditProductPanel getEpp() {
        return epp;
    }

    public DeleteProductPanel getDpp() {
        return dpp;
    }

    public AddProductPanel getApp() {
        return app;
    }

    public void setDpp(DeleteProductPanel dpp) {
        this.dpp = dpp;
    }

    public void setEpp(EditProductPanel epp) {
        this.epp = epp;
    }

    public void setApp(AddProductPanel app) {
        this.app = app;
    }

    public void setPtp(ProductTablePanel ptp) {
        this.ptp = ptp;
    }
}

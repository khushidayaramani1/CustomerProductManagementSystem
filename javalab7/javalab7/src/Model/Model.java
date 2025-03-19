package Model;
import Model.Customers.manageCustomers;
import Model.Products.manageProducts;
import Model.Purchase.managePurchase;

public class Model {
    manageCustomers ms;
    manageProducts mc;
    managePurchase me;
    public Model()
    {
        ms = new manageCustomers();
        mc = new manageProducts();
        me = new managePurchase();
    }

    public manageCustomers getMs() {
        return ms;
    }

    public managePurchase getMe() {
        return me;
    }

    public manageProducts getMc() {
        return mc;
    }

    public void setMc(manageProducts mc) {
        this.mc = mc;
    }

    public void setMe(managePurchase me) {
        this.me = me;
    }

    public void setMs(manageCustomers ms) {
        this.ms = ms;
    }
}

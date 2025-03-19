package View;
import View.Customer.FirstFrame;
import View.Product.ManageProductFrame;
import View.Customer.ManageCustomerFrame;
import View.Purchase.ManagePurchaseFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManageCustomerFrame msf;
    ManageProductFrame mcf;
    ManagePurchaseFrame mef;

    public View()
    {
        ff = new FirstFrame();
        msf = new ManageCustomerFrame();
        mcf = new ManageProductFrame();
        mef = new ManagePurchaseFrame();
    }
    public void centerInitialSetupCustomer(int linesBeingDisplayed, int size)
    {
        msf.getIp().getCp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        msf.getIp().getCp().createButtons((linesBeingDisplayed+1)*size);
    }
    public void centerInitialSetupPurchase(int linesBeingDisplayed, int size)
    {
       mef.getEnroll_ip().getEtp().setLayout(new GridLayout(linesBeingDisplayed + 1,size));
       mef.getEnroll_ip().getEtp().createButtons((linesBeingDisplayed+1) * size);
    }
    public void centerInitialSetupProduct(int linesBeingDisplayed, int size)
    {
        mcf.getProd_ip().getPtp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mcf.getProd_ip().getPtp().createButtons((linesBeingDisplayed+1)*size);
    }

    public void centerUpdateProduct(ArrayList<ArrayList<String>> lines, ArrayList<String> headers)
    {

        for (int i = 0; i < headers.size(); i++) {
            mcf.getProd_ip().getPtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int product_row_no = 0; product_row_no < lines.size(); product_row_no++) {
            for (int product_col_no = 0; product_col_no < headers.size(); product_col_no++) {
                int button_no = product_row_no * headers.size() + headers.size() + product_col_no;
                String button_txt = lines.get(product_row_no).get(product_col_no);

                mcf.getProd_ip().getPtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdateCustomer(ArrayList<ArrayList<String>> lines, ArrayList<String> headers)
    {
        for (int i = 0; i < headers.size(); i++) {
            msf.getIp().getCp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int customer_row_no = 0; customer_row_no < lines.size(); customer_row_no++) {
            for (int customer_col_no = 0; customer_col_no < headers.size(); customer_col_no++) {
                int button_no = customer_row_no * headers.size() + headers.size() + customer_col_no;
                String button_txt = lines.get(customer_row_no).get(customer_col_no);

                msf.getIp().getCp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdatePurchase(ArrayList<ArrayList<String>> lines, ArrayList<String> headers)
    {
        for (int i = 0; i < headers.size(); i++) {
            mef.getEnroll_ip().getEtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int purchase_row_no = 0; purchase_row_no < lines.size(); purchase_row_no++) {
            for (int purchase_col_no = 0; purchase_col_no < headers.size(); purchase_col_no++) {
                int button_no = purchase_row_no * headers.size() + headers.size() + purchase_col_no;
                String button_txt = lines.get(purchase_row_no).get(purchase_col_no);

                mef.getEnroll_ip().getEtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }


    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

    public void setMsf(ManageCustomerFrame msf) {
        this.msf = msf;
    }

    public ManageCustomerFrame getMsf() {
        return msf;
    }

    public void setMcf(ManageProductFrame mcf) {
        this.mcf = mcf;
    }

    public ManageProductFrame getMcf() {
        return mcf;
    }

    public void setMef(ManagePurchaseFrame mef) {
        this.mef = mef;
    }

    public ManagePurchaseFrame getMef() {
        return mef;
    }
}

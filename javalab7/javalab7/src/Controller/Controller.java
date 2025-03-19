package Controller;
import Model.Model;
import Model.Customers.Customers;
import View.View;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
public class Controller {
    Model model;
    View view;
    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        view.getFf().getManageCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Customer Button Clicked");
                view.getFf().setVisible(false);
                view.getMsf().setVisible(true);
            }
        });
        view.getMsf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        model.getMs().setLinesBeingDisplayed(20);
        view.centerInitialSetupCustomer(model.getMs().getLinesBeingDisplayed(),model.getMs().getHeaders().size());

        model.getMs().setFirstLineToDisplay(0);
        view.centerUpdateCustomer(model.getMs().getLines(model.getMs().getFirstLineToDisplay(),model.getMs().getLastLineToDisplay()),model.getMs().getHeaders());

        view.getMsf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs().getFirstLineToDisplay();
                int current_last_line = model.getMs().getLastLineToDisplay();
                int no_of_cities = model.getMs().getTable().size();
                int no_of_display_lines = model.getMs().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cities-1)
                {
                    model.getMs().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cities-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cities - no_of_display_lines)
                    {
                        new_first_line = no_of_cities-no_of_display_lines;
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateCustomer(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());
            }
        });


        view.getMsf().getIp().getAps().getAddCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Customer Button Clicked");
                String txt_customer_id = view.getMsf().getIp().getAps().getTxt_id().getText();
                String txt_customer_fname = view.getMsf().getIp().getAps().getTxt_fname().getText();
                String txt_customer_lname = view.getMsf().getIp().getAps().getTxt_lname().getText();
                String txt_customer_email = view.getMsf().getIp().getAps().getTxt_email().getText();
                String txt_customer_address = view.getMsf().getIp().getAps().getTxt_address().getText();
                String txt_customer_mobile = view.getMsf().getIp().getAps().getTxt_mobile().getText();
                String txt_customer_budget = view.getMsf().getIp().getAps().getTxt_budget().getText();
                try {
                    model.getMs().addNewCustomer(Integer.valueOf(txt_customer_id),txt_customer_fname,txt_customer_lname,txt_customer_email,txt_customer_address,txt_customer_mobile,Integer.valueOf(txt_customer_budget));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMsf().getIp().getDcp().getDeleteCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Customer Button Clicked");
                String txt_customer_idx = view.getMsf().getIp().getDcp().getTxt_del_customer_id().getText();
                try{
                    int cust_id = model.getMs().deleteCustomer(Integer.valueOf(txt_customer_idx));
                    for (int i =0; i< model.getMe().getTable().size(); i++)
                    {
                        if (cust_id == model.getMe().getTable().get(i).getc_temp().getCust_id())
                        {
                            model.getMe().deletePurchase(i);
                        }
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getMsf().getIp().getEcp().getGetCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Customer Details Clicked");
                String txt_customer_idx = view.getMsf().getIp().getEcp().getTxt_get_customer_idx().getText();
                model.getMs().readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");
                int customer_id = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_id();
                String customer_fname = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_fname();
                String customer_lname = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_lname();
                String customer_email = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_email();
                String customer_address = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_addr();
                String customer_mobile = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_mob();
                int customer_budget = model.getMs().getTable().get(Integer.valueOf(txt_customer_idx)).getCust_budget();
                view.getMsf().getIp().getEcp().getTxt_customer_id().setText(String.valueOf(customer_id));
                view.getMsf().getIp().getEcp().getTxt_customer_fname().setText(customer_fname);
                view.getMsf().getIp().getEcp().getTxt_customer_lname().setText(customer_lname);
                view.getMsf().getIp().getEcp().getTxt_customer_email().setText(customer_email);
                view.getMsf().getIp().getEcp().getTxt_customer_address().setText(customer_address);
                view.getMsf().getIp().getEcp().getTxt_customer_mobile().setText(customer_mobile);
                view.getMsf().getIp().getEcp().getTxt_customer_budget().setText(String.valueOf(customer_budget));
            }
        });
        view.getMsf().getIp().getEcp().getEditCustomerBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Customer Button Clicked");
                String txt_customer_idx = view.getMsf().getIp().getEcp().getTxt_get_customer_idx().getText();
                String txt_customer_id = view.getMsf().getIp().getEcp().getTxt_customer_id().getText();
                String txt_customer_fname = view.getMsf().getIp().getEcp().getTxt_customer_fname().getText();
                String txt_customer_lname = view.getMsf().getIp().getEcp().getTxt_customer_lname().getText();
                String txt_customer_email = view.getMsf().getIp().getEcp().getTxt_customer_email().getText();
                String txt_customer_address = view.getMsf().getIp().getEcp().getTxt_customer_address().getText();
                String txt_customer_mobile = view.getMsf().getIp().getEcp().getTxt_customer_mobile().getText();
                String txt_customer_budget = view.getMsf().getIp().getEcp().getTxt_customer_budget().getText();
                try{
                    model.getMs().editCustomer(Integer.valueOf(txt_customer_idx),Integer.valueOf(txt_customer_id),txt_customer_fname,txt_customer_lname,txt_customer_email,txt_customer_address,txt_customer_mobile,Integer.valueOf(txt_customer_budget));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });




        //PRODUCT BUTTON
//




        view.getFf().getManageProductBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Product Button Clicked");
                view.getFf().setVisible(false);
                view.getMcf().setVisible(true);
            }
        });
        view.getMcf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMc().setLinesBeingDisplayed(20);
        view.centerInitialSetupProduct(model.getMc().getLinesBeingDisplayed(),model.getMc().getHeaders().size());
        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateProduct(model.getMc().getLines(model.getMc().getFirstLineToDisplay(),model.getMc().getLastLineToDisplay()),model.getMc().getHeaders());

        view.getMcf().getProd_ip().getPtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_cities = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cities-1)
                {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cities-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cities - no_of_display_lines)
                    {
                        new_first_line = no_of_cities-no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateProduct(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });

        view.getMcf().getProd_ip().getApp().getAddProductBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Product Button Clicked");
                String txt_product_id = view.getMcf().getProd_ip().getApp().getTxt_prod_id().getText();
                String txt_product_name = view.getMcf().getProd_ip().getApp().getTxt_prod_name().getText();
                String txt_product_size = view.getMcf().getProd_ip().getApp().getTxt_prod_size().getText();
                String txt_product_type = view.getMcf().getProd_ip().getApp().getTxt_prod_type().getText();
                String txt_product_price = view.getMcf().getProd_ip().getApp().getTxt_prod_price().getText();
                String txt_product_colour = view.getMcf().getProd_ip().getApp().getTxt_prod_colour().getText();
                String txt_product_material = view.getMcf().getProd_ip().getApp().getTxt_prod_material().getText();
                try {
                    model.getMc().addNewProduct(Integer.valueOf(txt_product_id),txt_product_name,txt_product_size,txt_product_type,Integer.valueOf(txt_product_price),txt_product_colour,txt_product_material);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getProd_ip().getDpp().getDeleteProductBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Product Button Clicked");
                String txt_product_idx = view.getMcf().getProd_ip().getDpp().getTxt_del_product_id().getText();
                try{
                    int prod_id = model.getMc().deleteProduct(Integer.valueOf(txt_product_idx));
                    for (int i =0; i< model.getMe().getTable().size(); i++)
                    {
                        if (prod_id == model.getMe().getTable().get(i).getp_temp().getPr_id())
                        {
                            model.getMe().deletePurchase(i);
                        }
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getProd_ip().getEpp().getGetProductBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Product Details Clicked");
                String txt_product_idx = view.getMcf().getProd_ip().getEpp().getTxt_get_product_idx().getText();
                model.getMc().readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");
                int product_id = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_id();
                String product_name = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_name();
                String product_size = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_size();
                String product_type = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_type();
                int product_price = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_price();
                String product_colour = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_colour();
                String product_material = model.getMc().getTable().get(Integer.valueOf(txt_product_idx)).getPr_material();
                view.getMcf().getProd_ip().getEpp().getTxt_product_id().setText(String.valueOf(product_id));
                view.getMcf().getProd_ip().getEpp().getTxt_product_name().setText(product_name);
                view.getMcf().getProd_ip().getEpp().getTxt_product_size().setText(product_size);
                view.getMcf().getProd_ip().getEpp().getTxt_product_type().setText(product_type);
                view.getMcf().getProd_ip().getEpp().getTxt_product_price().setText(String.valueOf(product_price));
                view.getMcf().getProd_ip().getEpp().getTxt_product_colour().setText(product_colour);
                view.getMcf().getProd_ip().getEpp().getTxt_product_material().setText(product_material);
            }
        });
        view.getMcf().getProd_ip().getEpp().getEditProductBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Product Button Clicked");
                String txt_product_idx = view.getMcf().getProd_ip().getEpp().getTxt_get_product_idx().getText();
                String txt_product_id = view.getMcf().getProd_ip().getEpp().getTxt_product_id().getText();
                String txt_product_name = view.getMcf().getProd_ip().getEpp().getTxt_product_name().getText();
                String txt_product_size = view.getMcf().getProd_ip().getEpp().getTxt_product_size().getText();
                String txt_product_type = view.getMcf().getProd_ip().getEpp().getTxt_product_type().getText();
                String txt_product_price = view.getMcf().getProd_ip().getEpp().getTxt_product_price().getText();
                String txt_product_colour = view.getMcf().getProd_ip().getEpp().getTxt_product_colour().getText();
                String txt_product_material = view.getMcf().getProd_ip().getEpp().getTxt_product_material().getText();

                try{
                    model.getMc().editProduct(Integer.valueOf(txt_product_idx),Integer.valueOf(txt_product_id),txt_product_name,txt_product_size,txt_product_type,Integer.valueOf(txt_product_price),txt_product_colour,txt_product_material);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        //Purchase BUTTON

        view.getFf().getManagePurchaseBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Purchase Button Clicked");
                view.getFf().setVisible(false);
                view.getMef().setVisible(true);
            }
        });

        view.getMef().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMe().setLinesBeingDisplayed(20);
        view.centerInitialSetupPurchase(model.getMe().getLinesBeingDisplayed(),model.getMe().getHeaders().size());

        model.getMe().setFirstLineToDisplay(0);
        view.centerUpdatePurchase(model.getMe().getLines(model.getMe().getFirstLineToDisplay(),model.getMe().getLastLineToDisplay()),model.getMe().getHeaders());

        view.getMef().getEnroll_ip().getEtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMe().getFirstLineToDisplay();
                int current_last_line = model.getMe().getLastLineToDisplay();
                int no_of_cities = model.getMe().getTable().size();
                int no_of_display_lines = model.getMe().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMe().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMe().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cities-1)
                {
                    model.getMe().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cities-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cities - no_of_display_lines)
                    {
                        new_first_line = no_of_cities-no_of_display_lines;
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdatePurchase(model.getMe().getLines(model.getMe().getFirstLineToDisplay(), model.getMe().getLastLineToDisplay()), model.getMe().getHeaders());
            }
        });

        view.getMef().getEnroll_ip().getApe().getAddPurchaseBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Purchase Button Clicked");
                String txt_customer_id = view.getMef().getEnroll_ip().getApe().getTxt_customer_id().getText();
                String txt_product_id = view.getMef().getEnroll_ip().getApe().getTxt_product_id().getText();
                String txt_purchase_date = view.getMef().getEnroll_ip().getApe().getTxt_purchase_date().getText();
                String txt_product_charges = view.getMef().getEnroll_ip().getApe().getTxt_product_charges().getText();
                try {
                    model.getMe().addNewPurchase(Integer.valueOf(txt_customer_id),Integer.valueOf(txt_product_id),txt_purchase_date,Integer.valueOf(txt_product_charges));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMef().getEnroll_ip().getEep().getGetPurchaseBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Purchase Details Clicked");
                String txt_purchase_idx = view.getMef().getEnroll_ip().getEep().getTxt_get_purchase_idx().getText();
                model.getMe().readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
                int c_id = model.getMe().getTable().get(Integer.valueOf(txt_purchase_idx)).getc_temp().getCust_id();
                int p_id = model.getMe().getTable().get(Integer.valueOf(txt_purchase_idx)).getp_temp().getPr_id();
                String purchase_date = model.getMe().getTable().get(Integer.valueOf(txt_purchase_idx)).getPurchase_date();
                int product_charges = model.getMe().getTable().get(Integer.valueOf(txt_purchase_idx)).getProduct_charges();

                view.getMef().getEnroll_ip().getEep().getTxt_customer_id().setText(String.valueOf(c_id));
                view.getMef().getEnroll_ip().getEep().getTxt_product_id().setText(String.valueOf(p_id));
                view.getMef().getEnroll_ip().getEep().getTxt_purchase_date().setText(purchase_date);
                view.getMef().getEnroll_ip().getEep().getTxt_product_charges().setText(String.valueOf(product_charges));
            }
        });

        view.getMef().getEnroll_ip().getEep().getEditPurchaseBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Purchase Button Clicked");
                String txt_purchase_idx = view.getMef().getEnroll_ip().getEep().getTxt_get_purchase_idx().getText();
                String txt_customer_idx = view.getMef().getEnroll_ip().getEep().getTxt_customer_id().getText();
                String txt_product_idx = view.getMef().getEnroll_ip().getEep().getTxt_product_id().getText();
                String txt_purchase_date = view.getMef().getEnroll_ip().getEep().getTxt_purchase_date().getText();
                String txt_product_charges = view.getMef().getEnroll_ip().getEep().getTxt_product_charges().getText();
                try {
                    model.getMe().editPurchase(Integer.valueOf(txt_purchase_idx),Integer.valueOf(txt_customer_idx),Integer.valueOf(txt_product_idx),txt_purchase_date,Integer.valueOf(txt_product_charges));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMef().getEnroll_ip().getDep().getDeletePurchaseBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Purchase Button Clicked");
                String txt_purchase_idx = view.getMef().getEnroll_ip().getDep().getTxt_del_purchase_idx().getText();
                try {
                    model.getMe().deletePurchase(Integer.valueOf(txt_purchase_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }
}

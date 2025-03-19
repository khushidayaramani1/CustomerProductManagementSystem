package View.Product;

import javax.swing.*;

public class AddProductPanel extends JPanel {
    JTextField txt_prod_id;
    JTextField txt_prod_name;
    JTextField txt_prod_size;
    JTextField txt_prod_type;
    JTextField txt_prod_price;
    JTextField txt_prod_colour;
    JTextField txt_prod_material;
    JButton addProductBtn;

    public AddProductPanel()
    {
        txt_prod_id = new JTextField();
        txt_prod_name = new JTextField();
        txt_prod_size = new JTextField();
        txt_prod_type = new JTextField();
        txt_prod_price = new JTextField();
        txt_prod_colour = new JTextField();
        txt_prod_material = new JTextField();
        addProductBtn = new JButton("Add Product");

        txt_prod_id.setText("txt_prod_id");
        txt_prod_name.setText("txt_prod_name");
        txt_prod_size.setText("txt_prod_size");
        txt_prod_type.setText("txt_prod_type");
        txt_prod_price.setText("txt_prod_price");
        txt_prod_colour.setText("txt_prod_colour");
        txt_prod_material.setText("txt_prod_material");

        add(txt_prod_id);
        add(txt_prod_name);
        add(txt_prod_size);
        add(txt_prod_type);
        add(txt_prod_price);
        add(txt_prod_colour);
        add(txt_prod_material);



        add(addProductBtn);


    }


    public JTextField getTxt_prod_id() {
        return txt_prod_id;
    }

    public JTextField getTxt_prod_name() {
        return txt_prod_name;
    }

    public JTextField getTxt_prod_size() {
        return txt_prod_size;
    }

    public JTextField getTxt_prod_type() {
        return txt_prod_type;
    }

    public JTextField getTxt_prod_price() {
        return txt_prod_price;
    }

    public JTextField getTxt_prod_colour() {
        return txt_prod_colour;
    }

    public JTextField getTxt_prod_material() {
        return txt_prod_material;
    }

    public JButton getAddProductBtn() {
        return addProductBtn;
    }

    public void setTxt_prod_name(JTextField txt_prod_name) {
        this.txt_prod_name = txt_prod_name;
    }

    public void setTxt_prod_id(JTextField txt_prod_id) {
        this.txt_prod_id = txt_prod_id;
    }

    public void setTxt_prod_size(JTextField txt_prod_size) {
        this.txt_prod_size = txt_prod_size;
    }

    public void setTxt_prod_type(JTextField txt_prod_type) {
        this.txt_prod_type = txt_prod_type;
    }

    public void setTxt_prod_price(JTextField txt_prod_price) {
        this.txt_prod_price = txt_prod_price;
    }

    public void setTxt_prod_colour(JTextField txt_prod_colour) {
        this.txt_prod_colour = txt_prod_colour;
    }

    public void setTxt_prod_material(JTextField txt_prod_material) {
        this.txt_prod_material = txt_prod_material;
    }

    public void setAddProductBtn(JButton addProductBtn) {
        this.addProductBtn = addProductBtn;
    }
}

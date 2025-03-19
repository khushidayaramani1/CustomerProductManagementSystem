package View.Product;

import javax.swing.*;

public class EditProductPanel extends JPanel {
    JTextField txt_get_product_idx;
    JButton getProductBtn;
    JTextField txt_product_id;
    JTextField txt_product_name;
    JTextField txt_product_size;
    JTextField txt_product_type;
    JTextField txt_product_price;
    JTextField txt_product_colour;
    JTextField txt_product_material;
    JButton editProductBtn;

    public EditProductPanel()
    {
        txt_product_id = new JTextField();
        txt_get_product_idx = new JTextField();
        txt_product_name = new JTextField();
        txt_product_size = new JTextField();
        txt_product_type = new JTextField();
        txt_product_price = new JTextField();
        txt_product_colour = new JTextField();
        txt_product_material = new JTextField();
        getProductBtn = new JButton("Get Product to Edit");
        editProductBtn = new JButton("Edit Product");

        txt_get_product_idx.setText("get product id");
        txt_product_id.setText("txt_product_id");
        txt_product_name.setText("txt_product_name");
        txt_product_size.setText("txt_product_size");
        txt_product_type.setText("txt_product_type");
        txt_product_price.setText("txt_product_price");
        txt_product_colour.setText("txt_product_colour");
        txt_product_material.setText("txt_product_material");

        add(txt_get_product_idx);
        add(getProductBtn);

        add(txt_product_id);
        add(txt_product_name);
        add(txt_product_size);
        add(txt_product_type);
        add(txt_product_price);
        add(txt_product_colour);
        add(txt_product_material);
        add(editProductBtn);

    }

    public JTextField getTxt_get_product_idx() {
        return txt_get_product_idx;
    }

    public void setTxt_get_product_idx(JTextField txt_get_product_idx) {
        this.txt_get_product_idx = txt_get_product_idx;
    }

    public JButton getGetProductBtn() {
        return getProductBtn;
    }

    public void setGetProductBtn(JButton getProductBtn) {
        this.getProductBtn = getProductBtn;
    }

    public JTextField getTxt_product_id() {
        return txt_product_id;
    }

    public void setTxt_product_id(JTextField txt_product_id) {
        this.txt_product_id = txt_product_id;
    }

    public JTextField getTxt_product_name() {
        return txt_product_name;
    }

    public void setTxt_product_name(JTextField txt_product_name) {
        this.txt_product_name = txt_product_name;
    }

    public JTextField getTxt_product_size() {
        return txt_product_size;
    }

    public void setTxt_product_size(JTextField txt_product_size) {
        this.txt_product_size = txt_product_size;
    }

    public JTextField getTxt_product_type() {
        return txt_product_type;
    }

    public void setTxt_product_type(JTextField txt_product_type) {
        this.txt_product_type = txt_product_type;
    }

    public JTextField getTxt_product_price() {
        return txt_product_price;
    }

    public void setTxt_product_price(JTextField txt_product_price) {
        this.txt_product_price = txt_product_price;
    }

    public JTextField getTxt_product_colour() {
        return txt_product_colour;
    }

    public void setTxt_product_colour(JTextField txt_product_colour) {
        this.txt_product_colour = txt_product_colour;
    }

    public JTextField getTxt_product_material() {
        return txt_product_material;
    }

    public void setTxt_product_material(JTextField txt_product_material) {
        this.txt_product_material = txt_product_material;
    }

    public JButton getEditProductBtn() {
        return editProductBtn;
    }

    public void setEditProductBtn(JButton editProductBtn) {
        this.editProductBtn = editProductBtn;
    }



}

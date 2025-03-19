package Model.Products;

public class Items{
    String pr_name;
    String pr_size;
    String pr_type;
    int pr_price;
    String pr_colour;

    public Items(){
        System.out.println("Creating an Item");
    }
    public Items(String name,String size,String type,int price,String colour)
    {
        this.setPr_name(name);
        this.setPr_size(size);
        this.setPr_type(type);
        this.setPr_price(price);
        this.setPr_colour(colour);
    }

    public void setPr_name(String pr_name) {
        this.pr_name = pr_name;
    }

    public void setPr_size(String pr_size) {
        this.pr_size = pr_size;
    }

    public void setPr_type(String pr_type) {
        this.pr_type = pr_type;
    }

    public void setPr_price(int pr_price) {
        this.pr_price = pr_price;
    }

    public void setPr_colour(String pr_colour) {
        this.pr_colour = pr_colour;
    }

    public String getPr_name() {
        return pr_name;
    }

    public String getPr_size() {
        return pr_size;
    }

    public String getPr_type() {
        return pr_type;
    }

    public int getPr_price() {
        return pr_price;
    }

    public String getPr_colour() {
        return pr_colour;
    }
    public void display()
    {
        System.out.println("Product Name: "+getPr_name());
        System.out.println("Product Size "+getPr_size());
        System.out.println("Product Type "+getPr_type());
        System.out.println("Product Price: "+getPr_price());
        System.out.println("Product Colour: "+getPr_colour());
    }
}

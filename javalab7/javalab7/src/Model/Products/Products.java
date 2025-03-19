package Model.Products;

/**
 * Identification comments:
 *   Name: Harshita Bhatia
 *   Experiment No: 06 *
 *   Experiment Date: 13/02/24
 *  *   @version 1.0
 *  * Beginning comments:
 *  * Filename: Products.java
 *  * @author: Harshita Bhatia
 *  * Overview: This is the Products class. In this file we have achieved the following
 *  * - Created Attributes
 *  * --- int pr_id
 *  * --- String pr_material
 *  * --- int pr_count which is declared as static variable
 *   Experiment Title: Implementation of Abstract Class and Abstract Methods for the entities of the relationship and Implementing JSON File Handling in Java to store objects data. Reading a json file to objects and writing objects to a json data file.
 * - Created Setters and Getters
 * - Created constructors and overloaded them based on no. of parameters
 * - Created static setters and getters
 * - Made use of single inheritance where Items Class is the base class and Products Class is derived class
 * - Accessed methods of base class using the keyword super
 * - Created a Display Function to call the getters and display Instance data
 */
public class Products extends Items {
    private static int pr_count = 0;
    int pr_id;
    String pr_material;
    String pr_warranty;
    int pr_credits;

    public static void setPr_count(int count) {
        pr_count = count;
    }

    public static int getPr_count() {
        return pr_count;
    }

    public Products()
    {
        setPr_count(getPr_count()+1);
        this.setPr_id(pr_count);
    }
    public Products(String pr_material,String pr_name,String pr_size,String pr_type,int pr_price,String pr_colour)
    {
        super(pr_name,pr_size,pr_type,pr_price,pr_colour);
        setPr_count(getPr_count()+1);
        this.setPr_id(pr_count);
        this.setPr_material(pr_material);
    }
    public Products(int pr_id,String pr_material,String pr_name,String pr_size,String pr_type,int pr_price,String pr_colour)
    {
        super(pr_name,pr_size,pr_type,pr_price,pr_colour);
        setPr_count(getPr_count()+1);
        this.setPr_id(pr_id);
        this.setPr_material(pr_material);
    }

    public void setPr_warranty(String pr_warranty) {
        this.pr_warranty = pr_warranty;
    }

    public void setPr_credits(int pr_credits) {
        this.pr_credits = pr_credits;
    }

    public void setPr_id(int pr_id) {this.pr_id = pr_id;}

    public void setPr_material(String pr_material) {
        this.pr_material = pr_material;
    }

    public int getPr_id() {
        return pr_id;
    }

    public String getPr_material() {
        return pr_material;
    }

    public String getPr_warranty() {
        return pr_warranty;
    }

    public int getPr_credits() {
        return pr_credits;
    }

    public void display() {
        System.out.println("Product Id: " + getPr_id());
        System.out.println("Product Material: " + getPr_material());
        super.display();
    }
}

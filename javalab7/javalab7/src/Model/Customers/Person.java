package Model.Customers;

public class Person {
    String cust_fname;
    String cust_lname;
    String cust_email;
    String cust_addr;
    String cust_mob;
    public Person(){
        System.out.println("Creating a Person");
    }
    public Person(String fname,String lname,String email,String addr,String mob)
    {
        this.setCust_fname(fname);
        this.setCust_lname(lname);
        this.setCust_email(email);
        this.setCust_addr(addr);
        this.setCust_mob(mob);
    }

    public void setCust_fname(String cust_fname) {
        this.cust_fname = cust_fname;
    }

    public void setCust_lname(String cust_lname) {
        this.cust_lname = cust_lname;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public void setCust_addr(String cust_addr) {
        this.cust_addr = cust_addr;
    }

    public void setCust_mob(String cust_mob) {
        this.cust_mob = cust_mob;
    }

    public String getCust_fname() {
        return cust_fname;
    }

    public String getCust_lname() {
        return cust_lname;
    }

    public String getCust_email() {
        return cust_email;
    }

    public String getCust_addr() {
        return cust_addr;
    }

    public String getCust_mob() {
        return cust_mob;
    }

    public void display(){
        System.out.println("Customer First Name: "+getCust_fname());
        System.out.println("Customer Last Name: "+getCust_lname());
        System.out.println("Customer Email: "+getCust_email());
        System.out.println("Customer Address: "+getCust_addr());
        System.out.println("Customer Mobile No: "+getCust_mob());
    }
}

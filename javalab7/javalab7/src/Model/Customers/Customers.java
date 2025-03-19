package Model.Customers;

public class Customers extends Person {
    private static int cust_count = 0;
    int cust_id;
    int cust_budget;

    public static int getCust_count() {
        return cust_count;
    }

    public static void setCust_count(int cust_count) {
        Customers.cust_count = cust_count;
    }
    public Customers()
    {
        setCust_count(getCust_count()+1);
        this.setCust_id(cust_count);
    }
    public Customers(int cust_budget,String cust_fname,String cust_lname,String cust_email,String cust_addr,String cust_mob)
    {
        super(cust_fname,cust_lname,cust_email,cust_addr,cust_mob);
        this.setCust_id(cust_count);
        setCust_count(getCust_count()+1);
        this.setCust_budget(cust_budget);
    }
    public Customers(int cust_id,int cust_budget,String cust_fname,String cust_lname,String cust_email,String cust_addr,String cust_mob)
    {
        super(cust_fname,cust_lname,cust_email,cust_addr,cust_mob);
        setCust_count(getCust_count()+1);
        this.setCust_id(cust_id);
        this.setCust_budget(cust_budget);
    }

    public int getCust_id() {
        return cust_id;
    }

    public int getCust_budget() {
        return cust_budget;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public void setCust_budget(int cust_budget) {
        this.cust_budget = cust_budget;
    }
    public void display()
    {
        System.out.println("Customer Id: "+getCust_id());
        System.out.println("Customer Budget: "+getCust_budget());
        super.display();
    }
}






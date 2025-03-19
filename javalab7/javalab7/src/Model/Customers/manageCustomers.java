package Model.Customers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Displayable;


import javax.management.StringValueExp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class manageCustomers extends FileHandlingCustomers implements Displayable{
    ArrayList<Customers> customers = new ArrayList<Customers>();
    ObjectMapper objectMapper = new ObjectMapper();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageCustomers(){
        readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");
    }
    public ArrayList<Customers> readCustomerJsonFile(String file_path)
    {
        customers.removeAll(customers);
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            //Iterate through JSON array
            if (rootNode.isArray()){
                for (JsonNode node : rootNode){
                    int cust_id = node.get("cust_id").asInt();
                    String fname = node.get("cust_fname").asText();
                    String lname = node.get("cust_lname").asText();
                    String email = node.get("cust_email").asText();
                    String address = node.get("cust_addr").asText();
                    String mobile = node.get("cust_mob").asText();
                    int cust_budget = node.get("cust_budget").asInt();
                    Customers cust = new Customers(cust_id,cust_budget,fname,lname,email,address,mobile);
                    customers.add(cust);

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void writeCustomerJsonFile(String file_path, ArrayList<Customers> customers) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), customers);
    }

    public void setStudentsTable(ArrayList<Customers> students) {
        this.customers = customers;
    }

    public ArrayList<String> getHeaders(){
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Email");
        headers.add("Address");
        headers.add("Mobile");
        headers.add("Budget");
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> customer_details = new ArrayList<String>();

        customer_details.add(String.valueOf(customers.get(line).getCust_id()));
        customer_details.add(customers.get(line).getCust_fname());
        customer_details.add(customers.get(line).getCust_lname());
        customer_details.add(customers.get(line).getCust_email());
        customer_details.add(customers.get(line).getCust_addr());
        customer_details.add(customers.get(line).getCust_mob());
        customer_details.add(String.valueOf(customers.get(line).getCust_budget()));
        return  customer_details;
    }

    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine){
        ArrayList<ArrayList<String>> customers_subset =new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            customers_subset.add(getLine(i));
        }
        return customers_subset;
    }
    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Customers> getTable(){

        readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");
        return customers;
    }

    public void addNewCustomer(int customer_id,String customer_fname,String customer_lname,String customer_email, String customer_address,String customer_mobile,int customer_budget) throws IOException {
        readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");
        Customers temp_cust = new Customers(customer_id,customer_budget,customer_fname,customer_lname,customer_email,customer_address,customer_mobile);
        customers.add(temp_cust);
        writeCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json",customers);
    }
    public void editCustomer(int edit_customer_idx,int customer_id,String customer_fname,String customer_lname,String customer_email,String customer_address,String customer_mobile,int customer_budget) throws IOException {
        readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");
        customers.get(edit_customer_idx).setCust_id(customer_id);
        customers.get(edit_customer_idx).setCust_fname(customer_fname);
        customers.get(edit_customer_idx).setCust_lname(customer_lname);
        customers.get(edit_customer_idx).setCust_email(customer_email);
        customers.get(edit_customer_idx).setCust_addr(customer_address);
        customers.get(edit_customer_idx).setCust_mob(customer_mobile);
        customers.get(edit_customer_idx).setCust_budget(customer_budget);
        writeCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json",customers);
    }

//    public int deleteCustomer(int delete_customer_idx) throws IOException
//    {
//        readCustomerJsonFile("D:/JAVA/JAVA LAB 10/javalab7/javalab7/src/Model/Customers/Customers.json");
//        customers.remove(delete_customer_idx);
//        int cust_id = customers.get(delete_customer_idx).getCust_id();
//        writeCustomerJsonFile("D:/JAVA/JAVA LAB 10/javalab7/javalab7/src/Model/Customers/Customers.json",customers);
//        return cust_id;
//
//    }
public int deleteCustomer(int custId) throws IOException {
    List<Customers> customers = readCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json");

    int delete_customer_idx = -1;
    for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getCust_id() == custId) {
            delete_customer_idx = i;
            break;
        }
    }

    if (delete_customer_idx != -1) {
        int deletedCustId = customers.get(delete_customer_idx).getCust_id();
        customers.remove(delete_customer_idx);
        writeCustomerJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Customers/Customers.json", (ArrayList<Customers>) customers);
        return deletedCustId;
    } else {
        throw new IllegalArgumentException("Customer with ID " + custId + " not found.");
    }
}

}




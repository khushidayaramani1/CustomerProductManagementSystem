package Model.Purchase;

import Model.Products.*;
import Model.Products.manageProducts;
import Model.Displayable;
import Model.Customers.*;
import Model.Customers.manageCustomers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class managePurchase extends FileHandlingPurchase implements Displayable {
    ArrayList<Customers> customers = new ArrayList<Customers>();

    ArrayList<Products> products = new ArrayList<Products>();

    ArrayList<Purchase> purchase_data = new ArrayList<Purchase>();


    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public managePurchase(){
        manageCustomers ms1 = new manageCustomers();
        customers = ms1.getTable();
        manageProducts mc1 = new manageProducts();
        products = mc1.getTable();
        readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
    }
    @Override
    public ArrayList<Purchase> readPurchaseJsonFile(String file_path) {
        purchase_data.removeAll(purchase_data);
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int c_temp = node.get("c_temp").asInt();
                    int p_temp = node.get("p_temp").asInt();
                    String purchase_date = node.get("purchase_date").asText();
                    int product_charges = node.get("product_charges").asInt();

                    Customers c_temp_obj = null;
                    Products p_temp_obj = null;

                    for(int i = 0; i < customers.size(); i++)
                    {
                        if(c_temp == customers.get(i).getCust_id())
                        {
                            c_temp_obj = customers.get(i);
                        }
                    }

                    for(int i = 0; i < products.size(); i++)
                    {
                        if(p_temp == products.get(i).getPr_id())
                        {
                            p_temp_obj = products.get(i);
                        }
                    }

                    Purchase e_temp = new Purchase(c_temp_obj,p_temp_obj,purchase_date,product_charges);
                    purchase_data.add(e_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return purchase_data;
    }

    @Override
    protected void writePurchaseJsonFile(String file_path, ArrayList<Purchase> purchase_al) throws IOException {
        ArrayList<Map<String,Object>> purchase_to_be_written = new ArrayList<>();

        for(int i = 0; i < purchase_al.size(); i++)
        {
            HashMap<String, Object> data = new HashMap<>();
            data.put("c_temp",purchase_al.get(i).getc_temp().getCust_id());
            data.put("p_temp",purchase_al.get(i).getp_temp().getPr_id());
            data.put("purchase_date",purchase_al.get(i).getPurchase_date());
            data.put("product_charges",purchase_al.get(i).getProduct_charges());

            purchase_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), purchase_to_be_written);
    }


    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Customer Name");
        headers.add("Product Name");
        headers.add("Purchase Date");
        headers.add("Product Charges");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> purchase_details = new ArrayList<String>();

        purchase_details.add(purchase_data.get(line).getc_temp().getCust_fname());
        purchase_details.add(purchase_data.get(line).getp_temp().getPr_name());
        purchase_details.add(purchase_data.get(line).getPurchase_date());
        purchase_details.add(String.valueOf(purchase_data.get(line).getProduct_charges()));


        return purchase_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> product_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            product_subset.add(getLine(i));
        }
        return product_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return this.firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return 0;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(this.firstLineIndex + this.linesBeingDisplayed - 1);
        return this.lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return this.linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
            this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
    this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Purchase> getTable() {
        readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
        return purchase_data;
    }

    public void addNewPurchase(int customer_id,int product_id,String purchase_date, int product_charges) throws IOException
    {
        readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
        Purchase temp_purchase = new Purchase(customers.get(customer_id), products.get(product_id), purchase_date, product_charges);
        purchase_data.add(temp_purchase);
        writePurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json",purchase_data);
    }
    public void editPurchase(int edit_purchase_idx, int customer_id, int product_id, String purchase_date, int product_charges) throws IOException {
        readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
        purchase_data.get(edit_purchase_idx).setPurchase_date(purchase_date);
        purchase_data.get(edit_purchase_idx).setProduct_charges(product_charges);
        purchase_data.get(edit_purchase_idx).setC_temp(customers.get(customer_id));
        purchase_data.get(edit_purchase_idx).setp_temp(products.get(product_id));
        writePurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json",purchase_data);
    }
    public void deletePurchase(int delete_purchase_idx) throws IOException {
        readPurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json");
        purchase_data.remove(delete_purchase_idx);
        writePurchaseJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Purchase/Purchase.json",purchase_data);
    }

}

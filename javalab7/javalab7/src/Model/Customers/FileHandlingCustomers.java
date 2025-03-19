package Model.Customers;
import Model.Customers.Customers;
import Model.Products.Products;
import java.io.IOException;
import java.util.ArrayList;
public abstract class FileHandlingCustomers {
    protected abstract ArrayList<Customers> readCustomerJsonFile(String file_path);
    protected abstract void writeCustomerJsonFile(String file_path,ArrayList<Customers> customers) throws IOException;
}

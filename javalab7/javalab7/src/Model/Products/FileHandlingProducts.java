package Model.Products;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingProducts {
    protected abstract ArrayList<Products> readProductsJsonFile(String file_path);

    protected abstract void writeProductsJsonFile(String file_path, ArrayList<Products> products) throws IOException;
}

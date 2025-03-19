package Model.Purchase;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingPurchase {
    protected abstract ArrayList<Purchase> readPurchaseJsonFile(String file_path);
    protected abstract void writePurchaseJsonFile(String file_path, ArrayList<Purchase> purchases) throws IOException;
}

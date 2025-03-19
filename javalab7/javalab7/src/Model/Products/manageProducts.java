package Model.Products;
import Model.Customers.Customers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Displayable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class manageProducts extends FileHandlingProducts implements Displayable {
    ArrayList<Products> products = new ArrayList<Products>();
    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageProducts() {
        readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");
    }

    public ArrayList<Products> readProductsJsonFile(String file_path) {
        products.removeAll(products);
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int pr_id = node.get("pr_id").asInt();
                    String name = node.get("pr_name").asText();
                    String size = node.get("pr_size").asText();
                    String type = node.get("pr_type").asText();
                    int price = node.get("pr_price").asInt();
                    String colour = node.get("pr_colour").asText();
                    String pr_material = node.get("pr_material").asText();
                    Products prod = new Products(pr_id, pr_material, name, size, type, price, colour);
                    products.add(prod);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void writeProductsJsonFile(String file_path, ArrayList<Products> products) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), products);
    }

    public void setStudentsTable(ArrayList<Products> products) {
        this.products = products;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Size");
        headers.add("Type");
        headers.add("Price");
        headers.add("Colour");
        headers.add("Material");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> product_details = new ArrayList<String>();

        product_details.add(String.valueOf(products.get(line).getPr_id()));
        product_details.add(products.get(line).getPr_name());
        product_details.add(products.get(line).getPr_size());
        product_details.add(products.get(line).getPr_type());
        product_details.add(String.valueOf(products.get(line).getPr_price()));
        product_details.add(products.get(line).getPr_colour());
        product_details.add(products.get(line).getPr_material());

        return product_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> products_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            products_subset.add(getLine(i));
        }
        return products_subset;
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

    public ArrayList<Products> getTable() {
        readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");
        return products;
    }

    public void addNewProduct(int product_id, String product_name, String product_size, String product_type, int product_price, String product_colour, String product_material) throws IOException {
        readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");
        Products temp_prod = new Products(product_id, product_material, product_name, product_size, product_type, product_price, product_colour);
        products.add(temp_prod);
        writeProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json", products);
    }

    public void editProduct(int edit_product_idx, int product_id, String product_name, String product_size, String product_type, int product_price, String product_colour, String product_material) throws IOException {
        readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");
        products.get(edit_product_idx).setPr_id(product_id);
        products.get(edit_product_idx).setPr_name(product_name);
        products.get(edit_product_idx).setPr_size(product_size);
        products.get(edit_product_idx).setPr_type(product_type);
        products.get(edit_product_idx).setPr_price(product_price);
        products.get(edit_product_idx).setPr_colour(product_colour);
        products.get(edit_product_idx).setPr_material(product_material);
        writeProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json", products);
    }

    public int deleteProduct(int prodID) throws IOException {
        List<Products> products = readProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json");

        int delete_product_idx = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPr_id() == prodID) {
                delete_product_idx = i;
                break;
            }
        }
        if (delete_product_idx != -1) {
            int deletedProdId = products.get(delete_product_idx).getPr_id();
            products.remove(delete_product_idx);
            writeProductsJsonFile("D:/JAVA/LAB 11 JAVA/javalab7/javalab7/src/Model/Products/Products.json", (ArrayList<Products>) products);
            return deletedProdId;
        } else {
            throw new IllegalArgumentException("Product with ID " + prodID + " not found.");
        }
    }
}

package View.Product;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class ProductTablePanel extends JPanel{

    ArrayList<JButton> prod_buttons = new ArrayList<>();
    public ProductTablePanel(){super();}
    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.GREEN);
            b.setSize(500,50);
            prod_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no, String button_text)
    {
        prod_buttons.get(button_no).setText(button_text);
    }
    public ArrayList<JButton> getAllButtons(){return prod_buttons;}

}

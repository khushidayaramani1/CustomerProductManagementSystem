package View.Purchase;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class PurchaseTablePanel extends JPanel {
    ArrayList<JButton> purchase_buttons = new ArrayList<>();
    public PurchaseTablePanel(){super();}
    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.yellow);
            b.setSize(500,50);
            purchase_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no,String button_txt){purchase_buttons.get(button_no).setText(button_txt);}
    public ArrayList<JButton> getAllButtons(){return purchase_buttons;}
}

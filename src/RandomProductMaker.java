import javax.swing.*;
import java.awt.*;

public class RandomProductMaker extends JFrame {
    JPanel productInputFields, footer;
    JTextField productID, productName, productDescription, productPrice;
    public RandomProductMaker(){
        super("Random Objects.Product Maker");
        super.setSize(500, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupProductInputFields();

    }
    private void setupProductInputFields(){
        productInputFields = new JPanel();

        productID = new JTextField(6);
        productName = new JTextField(35);
        productDescription = new JTextField(75);
        productPrice = new JTextField(10);
        productInputFields.add(productID);
        productInputFields.add(productName);
        productInputFields.add(productDescription);
        productInputFields.add(productPrice);

        super.add(productInputFields, BorderLayout.CENTER);
    }
    private void SetupFooter(){
        footer = new JPanel();
        JButton addButton = new JButton("Add Objects.Product");
        addButton.addActionListener(e -> {

        });
        footer.add(addButton);

        super.add(footer, BorderLayout.SOUTH);
    }
}

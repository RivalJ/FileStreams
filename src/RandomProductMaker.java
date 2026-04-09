import Objects.Product;
import ProductTools.ProductFileSaver;

import javax.swing.*;
import java.awt.*;

public class RandomProductMaker extends JFrame {
    JPanel productInputFields, footer, center;
    JTextField productID, productName, productPrice, productCnt;
    JTextArea productDescription;
    public RandomProductMaker(){
        super("Random Objects.Product Maker");
        super.setSize(525, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        SetupProductInputFields();
        SetupFooter();

        super.add(center, BorderLayout.CENTER);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            System.exit(0);
        });
        super.add(quitButton, BorderLayout.SOUTH);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }
    private void SetupProductInputFields(){
        productInputFields = new JPanel();

        productID = new JTextField(6);
        productID.setBorder(BorderFactory.createTitledBorder("ID - " + Product.ID_LENGTH));

        productName = new JTextField(35);
        productName.setBorder(BorderFactory.createTitledBorder("Name - " + Product.NAME_LENGTH));

        productDescription = new JTextArea(3, 25);
        productDescription.setBorder(BorderFactory.createTitledBorder("Description - " + Product.DESCRIPTION_LENGTH));

        productPrice = new JTextField(10);
        productPrice.setBorder(BorderFactory.createTitledBorder("Price"));


        productInputFields.add(productID);
        productInputFields.add(productName);
        productInputFields.add(productDescription);
        productInputFields.add(productPrice);

        center.add(productInputFields, BorderLayout.CENTER);
    }
    private void SetupFooter(){
        footer = new JPanel();

        productCnt = new JTextField(10);
        productCnt.setText("0");
        productCnt.setBorder(BorderFactory.createTitledBorder("Product Count"));
        productCnt.setEditable(false);


        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(e -> {
            OnAddButtonClick();
        });
        footer.add(addButton);

        footer.add(productCnt);

        center.add(footer, BorderLayout.SOUTH);
    }

    private void OnAddButtonClick(){
        if(productID.getText().isEmpty() ||
                productName.getText().isEmpty() ||
                productDescription.getText().isEmpty() ||
                productPrice.getText().isEmpty()
        ){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
            return;
        }
        else{
            if(productID.getText().length() > Product.ID_LENGTH){
                JOptionPane.showMessageDialog(null, "ID cannot be longer than " + Product.ID_LENGTH + " characters.");
                return;
            }
            else if(productName.getText().length() > Product.NAME_LENGTH){
                JOptionPane.showMessageDialog(null, "Name cannot be longer than " + Product.NAME_LENGTH + " characters.");
                return;
            }
            else if(productDescription.getText().length() > Product.DESCRIPTION_LENGTH){
                JOptionPane.showMessageDialog(null, "Description cannot be longer than " + Product.DESCRIPTION_LENGTH + " characters.");
            }
            else{
                Product p = new Product(
                        productID.getText(),
                        productName.getText(),
                        productDescription.getText(),
                        Double.parseDouble(productPrice.getText())
                );
                ProductFileSaver.WriteProductToFile(p);
                productCnt.setText(Integer.toString(Integer.parseInt(productCnt.getText()) + 1));
                productID.setText("");
                productName.setText("");
                productDescription.setText("");
                productPrice.setText("");
            }
        }
    }
}

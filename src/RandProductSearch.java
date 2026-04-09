import Objects.Product;
import ProductTools.ProductNameSearch;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class RandProductSearch extends JFrame{
    JPanel productInputFields, footer, center;
    JTextField productName;
    JTextArea resultsArea;
    public RandProductSearch(){
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

        productName = new JTextField(35);
        productName.setBorder(BorderFactory.createTitledBorder("Name - " + Product.NAME_LENGTH));

        resultsArea = new JTextArea(5, 35);
        resultsArea.setBorder(BorderFactory.createTitledBorder("Results"));
        resultsArea.setEditable(false);

        productInputFields.add(productName);

        center.add(productInputFields, BorderLayout.NORTH);
        center.add(resultsArea, BorderLayout.CENTER);
    }
    private void SetupFooter(){
        footer = new JPanel();

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            OnAddButtonClick();
        });
        footer.add(searchButton);

        center.add(footer, BorderLayout.SOUTH);
    }

    private void OnAddButtonClick(){
        if(productName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
            return;
        }
        else{
            resultsArea.setText("");
            List<Product> results;
            results = ProductNameSearch.SearchByName(productName.getText());
            for(Product p : results){
                resultsArea.append(p.ToString() + "\n");
            }
        }
    }
}

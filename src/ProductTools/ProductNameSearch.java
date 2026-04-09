package ProductTools;

import FileTools.FileGrabber;
import Objects.Product;

import javax.swing.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public class ProductNameSearch {
    public static List<Product> SearchByName(String name){
        try{
            List<Product> productList = new java.util.ArrayList<>();
            File searchFile = FileGrabber.GetFileFromUser(JFileChooser.FILES_ONLY);
            RandomAccessFile raf = new RandomAccessFile(searchFile.getAbsolutePath(), "r");

            final int RECORD_LENGTH = Product.ID_LENGTH*2 + Product.NAME_LENGTH*2 + Product.DESCRIPTION_LENGTH*2 + 8;

            while(raf.getFilePointer() < raf.length()){
                String productID = "",
                        productName = "",
                        productDescription = "";
                double productPrice;

                for(int i = 0; i < Product.ID_LENGTH; i++){
                    productID += raf.readChar() + "";
                }
                for(int i = 0; i < Product.NAME_LENGTH; i++){
                    productName += raf.readChar() + "";
                }
                for(int i = 0; i < Product.DESCRIPTION_LENGTH; i++){
                    productDescription += raf.readChar() + "";
                }

                productPrice = raf.readDouble();
                if(productName.toLowerCase().contains(name.toLowerCase())){
                    productList.add(new Product(productID, productName, productDescription, productPrice));
                }
            }
            raf.close();
            return productList;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public class RandomProductMaker {
    public void WriteProductToFile(Product product) {
        try{
            File saveFile = FileSaver.GetSaveableFile();
            RandomAccessFile raf = new RandomAccessFile(saveFile.getAbsolutePath(), "rw");

            raf.seek(raf.length());//go to the end of the file
            raf.writeChars(product.GetID().Get());
            raf.writeChars(product.GetName().Get());
            raf.writeChars(product.GetDescription().Get());
            raf.writeDouble(product.GetPrice());
            raf.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void WriteProductToFile(Product product, RandomAccessFile file, boolean closeOnFinish) {
        try{
            file.seek(file.length());//go to the end of the file
            file.writeChars(product.GetID().Get());
            file.writeChars(product.GetName().Get());
            file.writeChars(product.GetDescription().Get());
            file.writeDouble(product.GetPrice());
            if(closeOnFinish){
                file.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void WriteProductListToFile(List<Product> productList){
        try{
            File saveFile = FileSaver.GetSaveableFile();
            RandomAccessFile raf = new RandomAccessFile(saveFile.getAbsolutePath(), "rw");

            for(Product p : productList){
                WriteProductToFile(p, raf, false);
            }
            raf.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

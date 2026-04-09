public class RandomProductMaker {
    public void WriteProductToFile() {
        try{
            //FIXME: replace example.txt with a changeable string variable
            RandomAccessFile raf = new RandomAccessFile("example.txt", "rw");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

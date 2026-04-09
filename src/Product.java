public class Product {

    private final String ID;
    private String name;
    private String description;
    private double price;

    public Product(String _IDNum){
        this.ID = _IDNum;
    }
    public Product(String _IDNum, String _firstName, String _lastName, double price){
        this.ID = _IDNum;
        this.name = _firstName;
        this.description = _lastName;
        this.price = price;
    }

    /**
     *
     * @return all data of this object
     *  as a string
     */
    public String ToString(){
        return "Person{"+
                "IDNum = " + ID + " \' " +
                "name = " + name + " \' " +
                "description = " + description + " \' " +
                "price = " + price + " \' " +
                "}";
    }

    /**
     *
     * @return all data of this object
     *  as a CSV data string
     */
    public String ToCSVDataString(){
        return ID + ", " + name + ", " + description + ", " + price;
    }


    //setters
    /**
     * FOR ALL SETTERS BELOW
     * there is comment below the following methods that tells you when this section ends
     * each setter takes in Param X as input and sets the given object variable to X,
     * see the example below
     *
     * @param _name
     * sets the name variable of this class to the same value as _name
     */
    public void SetName(String _name){
        this.name = _name;
    }
    public void SetDescription(String _description){
        this.description = _description;
    }
    public void SetPrice(Double _price){
        this.price = _price;
    }
    //end setters


    //getters
    /**
     * FOR ALL GETTERS BELOW
     * there is comment below the following methods that tells you when this section ends
     * each getter returns the value of the variable by the same name
     * see example below
     *
     * @return IDNum
     * returns the value of IDNum
     */
    public String GetIDNum(){
        return ID;
    }
    public String GetName(){
        return name;
    }
    public String GetDescription(){
        return description;
    }
    public double GetPrice(){
        return price;
    }
    //end getters
}

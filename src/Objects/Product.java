package Objects;

public class Product {

    private final FixedLengthString ID;
    private FixedLengthString name;
    private FixedLengthString description;
    private double price;

    public static final int ID_LENGTH = 6;
    public static final int NAME_LENGTH = 35;
    public static final int DESCRIPTION_LENGTH = 75;

    public Product(String _IDNum, String _name, String _desc, double price){
        this.ID = new FixedLengthString(_IDNum, ID_LENGTH, FixedLengthString.IS_FINAL);
        this.name = new FixedLengthString(_name, NAME_LENGTH);
        this.description = new FixedLengthString(_desc, DESCRIPTION_LENGTH);
        this.price = price;
    }

    /**
     *
     * @return all data of this object
     *  as a string
     */
    public String ToString(){
        return "Product{"+
                "IDNum = " + ID.GetRaw() + " \' " +
                "name = " + name.GetRaw() + " \' " +
                "description = " + description.GetRaw() + " \' " +
                "price = " + price + " \' " +
                "}";
    }

    /**
     *
     * @return all data of this object
     *  as a CSV data string
     */
    public String ToCSVDataString(){
        return ID.GetRaw() + ", " + name.GetRaw() + ", " + description.GetRaw() + ", " + price;
    }


    //setters
    public void SetPrice(Double _price){
        this.price = _price;
    }
    //end setters


    //getters
    public FixedLengthString GetID(){return ID;}
    public FixedLengthString GetName(){return name;}
    public FixedLengthString GetDescription(){return description;}
    public double GetPrice(){
        return price;
    }
    //end getters
}

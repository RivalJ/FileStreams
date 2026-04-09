package Objects;

public class FixedLengthString {
    private String str;
    private int length;
    public static final boolean IS_FINAL = true;
    private boolean isFinal = false;

    /***
     * creates a fixed length string
     * @param _str the string to be used
     * @param _length the length of the string
     */
    public FixedLengthString(String _str, int _length){
        this.str = _str.trim();
        this.length = _length;
        this.isFinal = false;
    }

    /***
     * creates a fixed length string
     * @param _str the string to be used
     * @param _length the length of the string
     * @param _isFinal whether or not this is a final string, it is preferable to use the static final boolean. This communicates intent the most clearly.
     */
    public FixedLengthString(String _str, int _length, boolean _isFinal){
        this.str = _str;
        this.length = _length;
        this.isFinal = _isFinal;
    }

    /***
     * gets the string with padding
     * @return the string with padding
     */
    public String Get(){
        String paddedString = str;
        if(str.length() < length){
            for(int i = 0; i < length - str.length(); i++){
                paddedString += " ";
            }
        }
        return paddedString;
    }

    /***
     * gets the raw string with no padding
     * @return the raw string
     */
    public String GetRaw(){
        return str;
    }

    /***
     * gets the fixed length of the string
     * @return the fixed length of the string
     */
    public int GetLength(){
        return length;
    }

    /***
     * sets the string and length of the string
     * @param _str the string to be used
     * @param _length the length of the string
     */
    public void Set(String _str, int _length){
        if(!isFinal){
            this.str = _str;
            this.length = _length;
        }
        else{
            System.out.println("This is a final string, it cannot be changed.");
        }
    }

    /***
     * sets the string of the string
     * @param _str the string to be used
     */
    public void Set(String _str){
        if(!isFinal){
            this.str = _str;
        }
        else{
            System.out.println("This is a final string, it cannot be changed.");
        }
    }

    /***
     * sets the length of the string
     * @param _length the length of the string
     */
    public void Set(int _length){
        if(!isFinal){
            this.length = _length;
        }
        else{
            System.out.println("This is a final string, it cannot be changed.");
        }
    }
}

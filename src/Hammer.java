public class Hammer extends Tool {
    
    private Head headType;
    private int age;
    private Condition condition;
    private boolean checkedOut;

    public Hammer(Condition condition, int age, boolean checkedOut, Head headType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
        this.headType = headType;

    }

    // enum for types of heads 
    public enum Head {

        Philips,
        Flat,
        Star,
        Square,
        Hexagon

    }

    /**
     * gets the maintanance for the tool 
     * 
     * @return maintenance
     */
    public String getMaintenance() {
        
        return null;

    }


    /**
     * gets the function
     * 
     * @return the function of the tool 
     */
    public String getFunction() {
    
        return null;

    }

    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return null;

    }

}

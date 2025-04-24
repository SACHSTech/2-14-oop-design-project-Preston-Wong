public class Screwdriver extends Tool {

    private Heads headType;
    private int age;
    private Condition condition;
    private boolean checkedOut;

    public Screwdriver(Condition condition, int age, boolean checkedOut, Heads headType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
        this.headType = headType;

    }

    // enum for types of heads 
    public enum Heads {

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

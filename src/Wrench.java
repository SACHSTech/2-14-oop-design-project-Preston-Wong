public class Wrench extends Tool {
 
    private Wrenches wrenchType;
    private int age;
    private Condition condition;
    private boolean checkedOut;

    public Wrench(Condition condition, int age, boolean checkedOut, Wrenches wrenchType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
        this.wrenchType = wrenchType;

    }

    // enum for types of wrenches 
    public enum Wrenches {

        Pipe,
        Allen,
        Socket

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

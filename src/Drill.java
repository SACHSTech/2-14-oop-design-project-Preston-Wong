public class Drill extends Tool {
    
    private Drills drillType;
    private int age;
    private Condition condition;
    private boolean checkedOut;

    public Drill(Condition condition, int age, boolean checkedOut, Drills drillType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
        this.drillType = drillType;

    }

    // enum for types of drills 
    public enum  Drills {

        Hammer,
        Impact,
        Core

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

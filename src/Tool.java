public abstract class Tool {
    
    private Condition condition;
    private int age;
    private boolean checkedOut;

    public Tool(Condition condition, int age, boolean checkedOut) {

        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;

    }

    // enum for conditions 
    public enum Condition {

        Perfect,
        Good,
        Average,
        Bad,
        Awful

    }

    /**
     * calculates how urgent a tool needs to be replaced 
     * 
     * @return how urgent the tool needs to be replaced 
     */
    public String getReplacementUrgency() {

        return null;

    }

    /**
     * checks if the tool is checked out 
     * 
     * @return true if it is checked out 
     */
    public boolean isCheckedOut() {

        return checkedOut;

    }

    // abstract classes
    public abstract String getMaintenance();
    public abstract String getFunction();
    public abstract String toString();

}

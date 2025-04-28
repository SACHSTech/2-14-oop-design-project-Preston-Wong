package Assignment;

/**
 * abstract tool class that keeps track of condition, age, and the checking status of the tool. 
 * It also contains an enum of all valid conditions that the tools can fall under, but allows for all 
 * child classes to specify their own tool further with any needed details 
 */
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
     * checks if the tool is checked out 
     * 
     * @return true if it is checked out 
     */
    public boolean isCheckedOut() {

        return checkedOut;

    }

    /**
     * takes the tool out of inventory while it is rented out 
     */
    public void rentOut() {

        checkedOut = true;

    }

    /**
     * adds the tool back into inventory to be rented out again 
     */
    public void returned() {

        checkedOut = false;

    }

    /**
     * gets condition of the tool 
     * 
     * @return condition of the tool 
     */
    public Condition getCondition() {

        return condition;

    }

    /**
     * gets the age of the tool 
     * 
     * @return the age of the tool 
     */
    public int getAge() {

        return age;

    }

    // abstract classes
    public abstract String getReplacementUrgency();
    public abstract String getMaintenance();
    public abstract String toString();
    public abstract String getName();
    public abstract double getRentalPrice();
    public abstract double getAdditionalFees(Condition condition);
    public abstract double getCurrentValue();
    

}

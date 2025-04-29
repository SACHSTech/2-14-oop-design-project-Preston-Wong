package Assignment;

/**
 * child class of tool, includes an ENUM of all valid drills and keeps track of each specific drills, 
 * age, maintenance, checking status, condition, if the drill is cordless or not, renting price, current value
 * and any additional fees that are associated with renting 
 */
public class Drill extends Tool {
    
    private Drills drillType;
    private int age;
    private double price = 100;
    private double rentalPrice;
    private Condition condition;
    private boolean isCordless;
    private final String cordlessMaintanence = "keep clean, dry, and well lubricated. Ensure that the battery terminal is clean before placing in the battery, and always check battery health";
    private final String cordedMaintanence = "keep clean, dry, and well lubricated. Ensure that the wire does not get tangeled and is tear free";

    public Drill(Condition condition, int age, boolean checkedOut, Drills drillType, boolean isCordless) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.drillType = drillType;
        this.isCordless = isCordless;
        getRentalPrice();

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
        
        if (isCordless == true) {

            return cordlessMaintanence;

        } else {

            return cordedMaintanence;

        }

    }

    /**
     * returns how due the tool is for replacement
     * 
     * @return a string of how urgently the tool must be replaced 
     */
    public String getReplacementUrgency() {

        // based on age and condition, returns the urgency in which it needs to be replaced 
       if ((condition == Condition.Awful) || (age >= 5)) {

            return "Now";

        } else if ((condition == Condition.Awful) || (condition == Condition.Bad)) {

            return "Very Urgent";

        } else if ((condition == Condition.Average) || (condition == Condition.Good)) {

            return "Medium Priority";

        } else {

            return "Low Priority";

        } 


    }

    /**
     * the name of the drill 
     * 
     * @return the tool name
     */
    public String getName() {

        return drillType + " drill";

    }

    /**
     * checks to see if the drill is cordless or not 
     * 
     * @return a boolean value 
     */
    public boolean isCordless() {

        return isCordless;

    }

    /**
     * calculates the rental price
     * 
     * @return a double value of the renal price 
     */
    public double getRentalPrice() {

        getCurrentValue();

        // calculates the rental price based on age, condition, and current value 
        if ((condition == Condition.Perfect) && (age <= 5)) {

            rentalPrice = price * 5;
            return rentalPrice;

        } else if (((condition == Condition.Good) && (age > 5)) || (condition == Condition.Average && (age <= 5))) {

            rentalPrice = price * 4;
            return rentalPrice;

        } else if ((condition == Condition.Awful) || (condition == Condition.Bad)) {
         
            return 0.0;
        
        } else {

            rentalPrice = price * 2;
            return rentalPrice;

        }

    }

    /**
     * gets the current value of the drill
     * 
     * @return a double value of the current value of the drill 
     */
    public double getCurrentValue() {

        // increases the current valeu of the drill if it's a cordless drill 
        if (isCordless == true) {

            price = price + 20;

        }

        // calculates the current value based on condition and age 
        if ((condition == Condition.Perfect) && (age <= 5)) {

            price = price * 0.9;
            return price;

        } else if (((condition == Condition.Good) && (age > 5)) || (condition == Condition.Average && (age <= 5))) {

            price = price * 0.75;
            return price;

        } else if ((condition == Condition.Awful) || (condition == Condition.Bad)) {
         
            price = 0.0;
            return 0.0;
        
        } else {

            return price * .25;

        }


    }

    /**
     * calculates the additional fees that needs to be paid 
     * 
     * @return a double value of all additional fees that need to be paid 
     */
    public double getAdditionalFees(Condition returnCondition) {

        // checks to see if the returned condition mathces the condition when it left 
        if (!(condition.equals(returnCondition))) {

            // sets the current condition to match the returend condition 
            condition = returnCondition;

            // checks to see how poor of a condition it was returend and calculates the fee accordingly 
            switch (returnCondition) {

                case Good:
                    
                    return rentalPrice * .1;
            
                case Average:

                    return rentalPrice * .5;

                default:

                    return rentalPrice;

            }

        }

        return 0.0;

    }

    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return drillType + " drill - Rental Price: $" + Math.round(rentalPrice * 100.0) / 100.0 + " - Actual Value: $" + Math.round(price * 100.0) / 100.0 + "\n";

    }

}

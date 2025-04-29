package Assignment;

/**
 * child class of tool, includes an ENUM of all valid hammers and keeps track of each specific hammer,
 * age, maintenance, checking status, condition, renting price, current price, and any additaion fees from renting
 */
public class Hammer extends Tool {
    
    private Hammers hammerType;
    private int age;
    private Condition condition;
    private double price = 10;
    private double rentalPrice;
    private final String maintenance = "regulalry clean and and inspect for any damages on it";

    public Hammer(Condition condition, int age, boolean checkedOut, Hammers hammerType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.hammerType = hammerType;
        getRentalPrice();

    }

    // enum for types of heads 
    public enum Hammers {

        Rock,
        Hatchet,
        Blocking

    }

    /**
     * gets the maintanance for the tool 
     * 
     * @return maintenance
     */
    public String getMaintenance() {
        
        return maintenance;

    }

    /**
     * gets the replacement urgency for hammers 
     * 
     * @return the need to replace the tool 
     */
    public String getReplacementUrgency() {

        // based on age and condition, returns the urgency in which it needs to be replaced 
        if (condition == Condition.Awful && (age >= 10)) {

            return "Now";

        } else if ((condition == Condition.Awful && (age <= 10)) || (condition == Condition.Bad && (age >= 10))) {

            return "Very Urgent";

        } else if ((condition == Condition.Bad && (age <= 10)) || (condition == Condition.Average && (age >= 10))) {

            return "Urgent";

        } else if ((condition == Condition.Average && (age <= 10)) || (condition == Condition.Good && (age >= 10))) {

            return "Medium Priority";

        } else {

            return "Low Priority";

        } 

    }

    /**
     * gets the name of the hammer 
     * 
     * @return a string of the name 
     */
    public String getName() {

        return hammerType + " hammer";

    }

    /**
     * calculate sthe rental price of the hammer based on condition and age 
     * 
     * @return a double value fo the current rental price 
     */
    public double getRentalPrice() {

        getCurrentValue();

        // calculates rental price based on condition, age, and current value  
        if ((condition == Condition.Perfect) && (age <= 10)) {

            rentalPrice = price * 5;
            return rentalPrice;

        } else if (((condition == Condition.Good) && (age > 10)) || (condition == Condition.Average && (age <= 10))) {

            rentalPrice = price * 4;
            return rentalPrice;

        } else if (((condition == Condition.Average) && (age > 10))) {

            rentalPrice = price * 2;
            return rentalPrice;

        } else if (condition == Condition.Awful) {
         
            return 0.0;
        
        } else {

            rentalPrice = price * 1.4;
            return rentalPrice;

        }

    }

    /**
     * calculates the current value of the hammer
     * 
     * @return a double value of the hammer 
     */
    public double getCurrentValue() {

        // calculates the current value based on age and condition of the hammer 
        if ((condition == Condition.Perfect) && (age <= 10)) {

            price = price * 0.9;
            return price;

        } else if (((condition == Condition.Good) && (age > 10)) || (condition == Condition.Average && (age <= 10))) {

            price = price * 0.75;
            return price;

        } else if (((condition == Condition.Average) && (age > 10))) {

            price = price * 0.5;
            return price;

        } else if (condition == Condition.Awful) {
         
            price = 0.0;
            return 0.0;
        
        } else {

            return price * .25;

        }


    }

    /**
     * calculates the additional fees that need to be paid
     * 
     * @return a double value of the additional fees that needs to be paid 
     */
    public double getAdditionalFees(Condition returnCondition) {

        // checks to see if the returned condition is the same as the original 
        if (!(condition.equals(returnCondition))) {

            // sets the current condition to be the same as the returend condition 
            condition = returnCondition;

            // checks to see how poor shape it was returned and adds an additional fee accordingly 
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

        return hammerType + " hammer - Rental Price: $" + Math.round(rentalPrice * 100.0) / 100.0 + " - Actual Value: $" + Math.round(price * 100.0) / 100.0 + "\n";

    }

}

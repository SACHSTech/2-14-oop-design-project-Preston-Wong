package Assignment;

/**
 * child class of tool, includes an ENUM of all valid screwdriver heads and keeps track of each specific screwdriver, 
 * age, maintenance, checking status, rental price, additional fees associated with renting, and current value
 */
public class Screwdriver extends Tool {

    private Heads headType;
    private int age;
    private Condition condition;
    private double price = 10;
    private double rentalPrice;
    private final String maintanence = "Keep away from water and avoid bending the tip out of shape";

    public Screwdriver(Condition condition, int age, boolean checkedOut, Heads headType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.headType = headType;
        getRentalPrice();

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
        
        return maintanence;

    }

    /**
     * gets the replacement urgency of the tool 
     * 
     * @return how due the tool is to be replaced 
     */
    public String getReplacementUrgency() {

        // based on age and condition, it will returna replacement urgecy 
        if (condition == Condition.Awful && (age >= 20)) {

            return "Now";

        } else if ((condition == Condition.Awful && (age <= 20)) || (condition == Condition.Bad && (age >= 20))) {

            return "Very Urgent";

        } else if ((condition == Condition.Bad && (age <= 20)) || (condition == Condition.Average && (age >= 20))) {

            return "Urgent";

        } else {

            return "Low Priority";

        }

    }

    /**
     * returns the name of the screwdriver
     * 
     * @return the name of the screwdriver 
     */
    public String getName() {

        return headType + " head screwdriver";

    }

    /**
     * allows the user to get the current value of the tool 
     * 
     * @return a double value of the value of the object 
     */
    public double getPrice() {

        return price;

    }

    /**
     * allows the user to get the rental price of the screwdriver 
     * 
     * @return a double value of the rental price 
     */
    public double getRentalPrice() {
        
        getCurrentValue();
        if ((condition == Condition.Perfect) && (age <= 20)) {

            rentalPrice = price * 5;
            return rentalPrice;

        } else if (((condition == Condition.Good) && (age > 20)) || (condition == Condition.Average && (age <= 20))) {

            rentalPrice = price * 4;
            return rentalPrice;

        } else if (condition == Condition.Awful) {

            return 0.0;

        } else {

            rentalPrice = price * 2;
            return rentalPrice;

        }

    }

    /**
     * calculates the current value based on age and condition
     * 
     * @return a double value of the current value 
     * 
     */
    public double getCurrentValue() {

        if ((condition == Condition.Perfect) && (age <= 20)) {

            price = price * 0.9;
            return price;

        } else if (((condition == Condition.Good) || (condition == Condition.Good))) {

            price = price * 0.75;
            return price;

        } else if (condition == Condition.Awful) {

            price = 0.0;
            return price;

        } else {

            price = price * 0.5;
            return price;

        }

    }

    /**
     * calculates any additional fees if the product was damaged on return
     * 
     * @return the amount of additional fees that the user has to pay 
     */
    public double getAdditionalFees(Condition returnCondition) {

        if (!(condition.equals(returnCondition))) {

            condition = returnCondition;

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

        return headType + " head screwdriver - Rental Price: " + rentalPrice + " - Actual Value " + price + "\n";

    }

    
}

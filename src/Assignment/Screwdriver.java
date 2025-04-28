package Assignment;

/**
 * child class of tool, includes an ENUM of all valid screwdriver heads and keeps track of each specific screwdriver
 * function, age, maintenance, checking status, and condition
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

    public double getPrice() {

        return price;

    }

    public double getRentalPrice() {

        if ((condition == Condition.Perfect) && (age <= 20)) {

            rentalPrice = price * 5;
            return rentalPrice;

        } else if ((condition == Condition.Good) && (age > 20) || (condition == Condition.Average && (age <= 20))) {

            rentalPrice = price * 4;
            return rentalPrice;

        } else {

            return 0.0;

        }

    }

    public double getCurrentValue() {

        if (condition == Condition.Awful && (age >= 20)) {

            return 0.0;

        } else if ((condition == Condition.Awful && (age <= 20)) || (condition == Condition.Bad && (age >= 20))) {

            price = price * 0.5;
            return price;

        } else if ((condition == Condition.Bad && (age <= 20)) || (condition == Condition.Average && (age >= 20))) {

            price = price * 0.8;
            return price;

        } else {

            price = price * 0.9;
            return price;

        }

    }

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

        return headType + " head screwdriver - Rental Price: " + getRentalPrice() + " - Actual Value " + getCurrentValue() + "\n";

    }

    
}

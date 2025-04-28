package Assignment;

/**
 * child class of tool, includes an ENUM of all valid hammers and keeps track of each specific hammer
 * function, age, maintenance, checking status, and condition
 */
public class Hammer extends Tool {
    
    private Hammers hammerType;
    private int age;
    private Condition condition;
    private double price = 10;
    private double rentalPrice;
    // private final String rockHammerFunction = "break or split rocks";
    // private final String hatchetHammerFunction = "drive nails with a hatchet on the other side";
    // private final String blockingHammerFunction = "bend and shape metals";
    private final String maintenance = "regulalry clean and and inspect for any damages on it";

    public Hammer(Condition condition, int age, boolean checkedOut, Hammers hammerType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.hammerType = hammerType;

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


    // /**
    //  * gets the function
    //  * 
    //  * @return the function of the tool 
    //  */
    // public String getFunction() {
    
    //     switch(hammerType) {

    //         case Hammers.Rock:

    //             return rockHammerFunction;

    //         case Hammers.Hatchet:
            
    //             return hatchetHammerFunction;

    //         case Hammers.Blocking:

    //             return blockingHammerFunction;

    //         default:

    //             return "You don't have a hammer on hand";

    //     }

    // }

    /**
     * gets the replacement urgency for hammers 
     * 
     * @return the need to replace the tool 
     */
    public String getReplacementUrgency() {

        // based on age and condition, returns the urgency in which it needs to be replaced 
        if (condition == Condition.Awful && (age >= 10)) {

            return "Very Urgent";

        } else if ((condition == Condition.Awful && (age <= 10)) || (condition == Condition.Bad && (age >= 10))) {

            return "Urgent";

        } else if ((condition == Condition.Bad && (age <= 10)) || (condition == Condition.Average && (age >= 10))) {

            return "Soon";

        } else if ((condition == Condition.Average && (age <= 10)) || (condition == Condition.Good && (age >= 10))) {

            return "Not Soon";

        } else {

            return "Long Time";

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

    public double getPrice() {

        return price;

    }

    public double getRentalPrice() {

        if ((condition == Condition.Perfect) && (age <= 5)) {

            rentalPrice = 50.0;

        } else {

            rentalPrice = 30;

        }

        return rentalPrice;

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

        return hammerType + " hammer - Rental Price: " + getRentalPrice() + " - Actual Value " + getCurrentValue() + "\n";

    }

}

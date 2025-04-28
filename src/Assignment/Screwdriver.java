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
    // private final String philipsFunction = "screw in screws that have a cross on the top";
    // private final String flatFunction = "screw in screws that have a line on the top";
    // private final String starFunction = "screw in screws that have a star on the top";
    // private final String squareFunction = "screw in screws that have a square on the top";
    // private final String hexagonFunction = "screw in screws that have a hexagon on the top";
    private final String maintanence = "Keep away from water and avoid bending the tip out of shape";

    public Screwdriver(Condition condition, int age, boolean checkedOut, Heads headType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
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
        
        return maintanence;

    }


    // /**
    //  * gets the function
    //  * 
    //  * @return the function of the tool 
    //  */
    // public String getFunction() {
    
    //     switch(headType) {

    //         case Heads.Philips:

    //             return philipsFunction;

    //         case Heads.Flat:
            
    //             return flatFunction;

    //         case Heads.Star:

    //             return starFunction;

    //         case Heads.Square:

    //             return squareFunction;
            
    //         case Heads.Hexagon:

    //             return hexagonFunction;

    //         default:

    //             return "You don't have a screwdriver on hand";

    //     }

    // }

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

            return "Priority";

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

    public double calculateRentalPrice() {

        if ((condition == Condition.Perfect) && (age <= 5)) {

            rentalPrice = 50.0;

        }

        return rentalPrice;

    }

    public double getCurrentValue() {

        if (condition == Condition.Awful && (age >= 20)) {

            return 0.0;

        } else if ((condition == Condition.Awful && (age <= 20)) || (condition == Condition.Bad && (age >= 20))) {

            return price * 0.5;

        } else if ((condition == Condition.Bad && (age <= 20)) || (condition == Condition.Average && (age >= 20))) {

            return price * 0.8;

        } else {

            return price * 0.9;

        }


    }

    public double getAdditionalFees(Condition returnCondition) {

        if (!condition.equals(returnCondition)) {

            switch (returnCondition) {

                case Good:
                    
                    return rentalPrice * 1.1;
            
                case Average:

                    return rentalPrice * 1.5;

                default:

                    return rentalPrice * 2;

            }

        }

        return price;

    }

    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return headType + " head screwdriver - Condition: " + condition + " - Age: " + age + " years old \n";

    }

    
}

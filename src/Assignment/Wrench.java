package Assignment;

/**
 * child class of tool, includes an ENUM of all valid wrenches and keeps track of each specific wrenches
 * function, age, maintenance, checking status, condition, and size
 */
public class Wrench extends Tool {
 
    private Wrenches wrenchType;
    private int age;
    private double size;
    private double price = 10;
    private double rentalPrice;
    private Condition condition;
    // private final String pipeFunctioin = "grip and turn pipes";
    // private final String allenFunction = "install or remove fasteners with a hexagon head";
    // private final String socketFunction = "turn nuts and bolts";
    private final String maintanence = "regularly clean to remove debris and grease/lubricate moving parts if applicable";

    public Wrench(Condition condition, int age, boolean checkedOut, Wrenches wrenchType, double size) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.wrenchType = wrenchType;
        this.size = size;

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
        
        return maintanence;

    }


    // /**
    //  * gets the function
    //  * 
    //  * @return the function of the tool 
    //  */
    // public String getFunction() {
    
    //     switch(wrenchType) {

    //         case Wrenches.Pipe:

    //             return pipeFunctioin;

    //         case Wrenches.Allen:
            
    //             return allenFunction;

    //         case Wrenches.Socket:

    //             return socketFunction;

    //         default:

    //             return "You don't have a hammer on hand";

    //     }


    // }

    /**
     * replacement urgency of the tool
     * 
     * @return a string of the replacment urgency 
     */
    public String getReplacementUrgency() {

       // based on age and condition, returns the urgency in which it needs to be replaced 
       if (condition == Condition.Awful && (age >= 5)) {

            return "Very Urgent";

        } else if ((condition == Condition.Awful && (age <= 5)) || (condition == Condition.Bad && (age >= 5))) {

            return "Urgent";

        } else if ((condition == Condition.Bad && (age <= 5)) || (condition == Condition.Average && (age >= 5))) {

            return "Soon";

        } else if ((condition == Condition.Average && (age <= 5)) || (condition == Condition.Good && (age >= 5))) {

            return "Not Soon";

        } else {

            return "Long Time";

        } 


    }

    /**
     * gets the name of the wrench
     * 
     * @return the name of the wrench 
     */
    public String getName() {

        return wrenchType + " wrench";

    }

    /**
     * gets the wrench size 
     * 
     * @return a dobule value of the wrench size 
     */
    public double getSize() {

        return size;

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

        return wrenchType + " wrench - Rental Price: " + getRentalPrice() + " - Actual Value " + getCurrentValue() + "\n";

    }
    
}

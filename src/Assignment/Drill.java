package Assignment;

/**
 * child class of tool, includes an ENUM of all valid drills and keeps track of each specific drills
 * function, age, maintenance, checking status, condition, and if the drill is cordless or not 
 */
public class Drill extends Tool {
    
    private Drills drillType;
    private int age;
    private double price = 10;
    private double rentalPrice;
    private Condition condition;
    private boolean isCordless;
    private final String hammerFunctioin = "break up concreate or stones";
    private final String impactFunction = "installing bolts with higher torque";
    private final String coreFunction = "create a cylindrical hole in concreate or stone";
    private final String cordlessMaintanence = "keep clean, dry, and well lubricated. Ensure that the battery terminal is clean before placing in the battery, and always check battery health";
    private final String cordedMaintanence = "keep clean, dry, and well lubricated. Ensure that the wire does not get tangeled and is tear free";

    public Drill(Condition condition, int age, boolean checkedOut, Drills drillType, boolean isCordless) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.drillType = drillType;
        this.isCordless = isCordless;

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
     * gets the function
     * 
     * @return the function of the tool 
     */
    public String getFunction() {
    
        switch(drillType) {

            case Drills.Hammer:

                return hammerFunctioin;

            case Drills.Impact:
            
                return impactFunction;

            case Drills.Core:

                return coreFunction;

            default:

                return "You don't have a hammer on hand";

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

            return "Very Urgent";

        } else if ((condition == Condition.Awful) || (condition == Condition.Bad)) {

            return "Urgent";

        } else if ((condition == Condition.Average) || (condition == Condition.Good)) {

            return "Soon";

        } else {

            return "Long Time";

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

        return drillType + " drill - Condition: "  + condition + " - Age: " + age + " years old \n";

    }

}

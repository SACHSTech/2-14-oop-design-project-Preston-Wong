package Assignment;

/**
 * child class of tool, includes an ENUM of all valid wrenches and keeps track of each specific wrenches, 
 * age, maintenance, checking status, condition, size, rental price, current value, and any other additional fees associated form renting 
 */
public class Wrench extends Tool {
 
    private Wrenches wrenchType;
    private int age;
    private double price = 15;
    private double rentalPrice;
    private Condition condition;
    private final String maintanence = "regularly clean to remove debris and grease/lubricate moving parts if applicable";

    public Wrench(Condition condition, int age, boolean checkedOut, Wrenches wrenchType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.wrenchType = wrenchType;
        getRentalPrice();

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

    /**
     * replacement urgency of the tool
     * 
     * @return a string of the replacment urgency 
     */
    public String getReplacementUrgency() {

       // based on age and condition, returns the urgency in which it needs to be replaced 
       if (condition == Condition.Awful && (age >= 5)) {
            return "Now";
        } else if ((condition == Condition.Awful && (age <= 5)) || (condition == Condition.Bad && (age >= 5))) {
            return "Very Urgent";
        } else if ((condition == Condition.Bad && (age <= 5)) || (condition == Condition.Average && (age >= 5))) {
            return "Urgent";
        } else if ((condition == Condition.Average && (age <= 5)) || (condition == Condition.Good && (age >= 5))) {
            return "Medium Priority";
        } else {
            return "Low Priority";
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
     * calculates the rental price
     * 
     * @return a double value of the rental price 
     */
    public double getRentalPrice() {

        getCurrentValue();

        // calculates the rental priced based off the current value, condition, and age 
        if ((condition == Condition.Perfect) && (age <= 5)) {
            rentalPrice = price * .8;
            return rentalPrice;
        } else if (((condition == Condition.Good) && (age <= 5)) || (condition == Condition.Average && (age <= 5))) {
            rentalPrice = price * .6;
            return rentalPrice;
        } else if (((condition == Condition.Average) && (age > 5)) || (condition == Condition.Good && (age > 5))) {
            rentalPrice = price * .4;
            return rentalPrice;
        } else if (condition == Condition.Awful) {
            return 0.0;
        } else {
            rentalPrice = price * .24;
            return rentalPrice;
        }
    }

    /**
     * calculates and returns the current value
     * 
     * @return a double value of the current wrench value 
     */
    public double getCurrentValue() {

        // calculate the current value baesd on condition and age 
        if ((condition == Condition.Perfect) && (age <= 5)) {
            price = price * 0.9;
            return price;
        } else if (((condition == Condition.Good) && (age > 5)) || (condition == Condition.Average && (age <= 5))) {
            price = price * 0.75;
            return price;
        } else if (((condition == Condition.Average) && (age > 5)) || (condition == Condition.Bad && (age <= 5))) {
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
     * calculates if any additional fees needs to be paid 
     * 
     * @return a double value of the additional fees that needs to be paid 
     */
    public double getAdditionalFees(Condition returnCondition) {

        // checks to see if the returend condition is the same as it left the rental company
        if (!(condition.equals(returnCondition))) {

            // sets the current condition to be the same as the returend condition 
            condition = returnCondition;

            // checks to see how poor shape it was returend and calculatess fees accordingly 
            switch (returnCondition) {

                case Good:                    
                    return rentalPrice * .25;
                case Average:
                    return rentalPrice * .5;
                default:
                    return rentalPrice;
            }
        }
        return 0.0;
    }

    /**
     * calculate the price ot fix
     * 
     * @return a double value of how much it will cost of fix 
     */
    public double getPriceToFix() {

        double repairCost = 0.0;

        // checks to see how poor of a condition it was returend and calculates the repair fee accordingly 
        switch (condition) {

            case Good:
                repairCost = 10.0;
                return repairCost;
            case Average:
                repairCost = 15.0;
                return repairCost;
            case Bad:
                repairCost = 20.0;
                return repairCost;
            case Perfect:
                repairCost = 0.0;
                return repairCost;
            default: 
                repairCost = 50.0;
                return repairCost;
        }
    }

    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        if (isCheckedOut() == false) {
            return wrenchType + " wrench - Rental Price: $" + Math.round(getRentalPrice() * 100.0) / 100.0 + " - Avaliability: Avaliable" + "\n";
        } 

        return wrenchType + " wrench - Rental Price: $" + Math.round(getRentalPrice() * 100.0) / 100.0 + " - Avaliability: Unavaliable" + "\n";
    }
    
}

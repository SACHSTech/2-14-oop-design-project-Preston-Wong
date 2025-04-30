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
     * allows the user to get the rental price of the screwdriver 
     * 
     * @return a double value of the rental price 
     */
    public double getRentalPrice() {
        
        getCurrentValue();

        // clculates the rental price based on condition, age, and current value 
        if ((condition == Condition.Perfect) && (age <= 20)) {

            rentalPrice = price * .75;
            return rentalPrice;

        } else if (((condition == Condition.Good) && (age > 20)) || (condition == Condition.Average && (age <= 20))) {

            rentalPrice = price * .5;
            return rentalPrice;

        } else if (condition == Condition.Awful) {

            return 0.0;

        } else {

            rentalPrice = price * .3;
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

        // calculates the current valeu based on condition and age 
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

        // checks to see if the tool was returned in the original condition it left 
        if (!(condition.equals(returnCondition))) {

            // sets the condition to be the same as the returend condition 
            condition = returnCondition;

            // checks to see how bad it was returend and adds an additional priced based on it 
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

                repairCost = 30.0;
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

            return headType + " head screwdriver - Rental Price: $" + Math.round(getRentalPrice() * 100.0) / 100.0 + " - Actual Value: $" + Math.round(getCurrentValue() * 100.0) / 100.0 + 
            " - Avaliability: Avaliable" + "\n";

        } 

        return headType + " head screwdriver - Rental Price: $" + Math.round(getRentalPrice() * 100.0) / 100.0 + " - Actual Value: $" + Math.round(getCurrentValue() * 100.0) / 100.0 + 
        " - Avaliability: Unavaliable" + "\n";

    }

    
}

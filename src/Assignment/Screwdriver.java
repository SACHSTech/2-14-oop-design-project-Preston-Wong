package Assignment;
public class Screwdriver extends Tool {

    private Heads headType;
    private int age;
    private Condition condition;
    private boolean checkedOut;

    public Screwdriver(Condition condition, int age, boolean checkedOut, Heads headType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
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
        
        return null;

    }


    /**
     * gets the function
     * 
     * @return the function of the tool 
     */
    public String getFunction() {
    
        switch(headType) {

            case Heads.Philips:
                return headType + " head screwdriver, used to manually screw in screws that have a cross on the top";

            case Heads.Flat:
                return headType + " head screwdriver, used to manually screw in screws that have a line on the top";

            case Heads.Star:
                return headType + " head screwdriver, used to manually screw in screws that have a star on the top";

            case Heads.Square:
                return headType + " head screwdriver, used to manually screw in screws that have a square on the top";
            
            case Heads.Hexagon:
                return headType + " head screwdriver, used to manually screw in screws that have a hexagon on the top";

            default:

                return "You don't have a screwdriver on hand";

        }

    }

    public String getReplacementUrgency() {

        if (condition == Condition.Awful && (age >= 20)) {

            return "Very Urgent";

        } else if ((condition == Condition.Awful && (age <= 20)) || (condition == Condition.Bad && (age >= 20))) {

            return "Urgent";

        } else if ((condition == Condition.Bad && (age <= 20)) || (condition == Condition.Average && (age >= 20))) {

            return "Soon";

        } else {

            return "Long Time";

        }

    }

    public String getName() {

        return headType + " head screwdriver";

    }


    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return headType + " head screwdriver is in " + condition + " condition and is " + age + " years old \n";

    }
    
}

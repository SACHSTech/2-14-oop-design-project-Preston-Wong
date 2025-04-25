package Assignment;
public class Screwdriver extends Tool {

    private Heads headType;
    private int age;
    private Condition condition;
    private boolean checkedOut;
    private final String philipsFunction = "manually screw in screws that have a cross on the top";
    private final String flatFunction = "manually screw in screws that have a line on the top";
    private final String starFunction = "manually screw in screws that have a star on the top";
    private final String squareFunction = "manually screw in screws that have a square on the top";
    private final String hexagonFunction = "manually screw in screws that have a hexagon on the top";
    private final String maintanence = "Keep away from water and avoid bending the tip out of shape";

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
        
        return maintanence;

    }


    /**
     * gets the function
     * 
     * @return the function of the tool 
     */
    public String getFunction() {
    
        switch(headType) {

            case Heads.Philips:

                return philipsFunction;

            case Heads.Flat:
            
                return flatFunction;

            case Heads.Star:

                return starFunction;

            case Heads.Square:

                return squareFunction;
            
            case Heads.Hexagon:

                return hexagonFunction;

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

        return headType + " head screwdriver - Condition: " + condition + " - Age: " + age + " years old \n";

    }
    
}

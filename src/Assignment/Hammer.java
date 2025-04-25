package Assignment;

public class Hammer extends Tool {
    
    private Hammers hammerType;
    private int age;
    private Condition condition;
    private boolean checkedOut;
    private final String rockHammerFunction = "break or split rocks";
    private final String hatchetHammerFunction = "drive nails with a hatchet on the other side";
    private final String blockingHammerFunction = "bend and shape metals";
    private final String maintenance = "regulalry clean and and inspect for any damages on it";

    public Hammer(Condition condition, int age, boolean checkedOut, Hammers hammerType) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
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


    /**
     * gets the function
     * 
     * @return the function of the tool 
     */
    public String getFunction() {
    
        switch(hammerType) {

            case Hammers.Rock:

                return rockHammerFunction;

            case Hammers.Hatchet:
            
                return hatchetHammerFunction;

            case Hammers.Blocking:

                return blockingHammerFunction;

            default:

                return "You don't have a hammer on hand";

        }

    }

    public String getReplacementUrgency() {

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

    public String getName() {

        return hammerType + " hammer";

    }

    /**
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return hammerType + " hammer - Condition: "  + condition + " - Age: " + age + " years old \n";

    }

}

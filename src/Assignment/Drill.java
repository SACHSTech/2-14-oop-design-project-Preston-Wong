package Assignment;

public class Drill extends Tool {
    
    private Drills drillType;
    private int age;
    private Condition condition;
    private boolean checkedOut;
    private boolean isCordless;
    private final String hammerFunctioin = "break up concreate or stones";
    private final String impactFunction = "installing bolts with higher torque";
    private final String coreFunction = "create a cylindrical hole in concreate or stone";
    private final String cordlessMaintanence = "keep clean, dry, and well lubricated. Ensure that the battery terminal is clena before placing in the battery, and always check battery health";
    private final String cordedMaintanence = "keep clean, dry, and well lubricated. Ensure that the wire does not get tangeled and is tear free";

    public Drill(Condition condition, int age, boolean checkedOut, Drills drillType, boolean isCordless) {

        super(condition, age, checkedOut);
        this.condition = condition;
        this.age = age;
        this.checkedOut = checkedOut;
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
       if (condition == Condition.Awful && (age >= 5)) {

            return "Very Urgent";

        } else if ((condition == Condition.Awful && (age <= 5)) || (condition == Condition.Bad && (age >= 5))) {

            return "Urgent";

        } else if ((condition == Condition.Average && (age <= 5)) || (condition == Condition.Good && (age >= 5))) {

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
     * converts tool object ot a string
     * 
     * @return tool name and specs 
     */
    public String toString() {

        return drillType + " wrench - Condition: "  + condition + " - Age: " + age + " years old \n";

    }

}

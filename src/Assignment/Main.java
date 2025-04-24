package Assignment;

import Assignment.Tool.Condition;
import Assignment.Hammer.Hammers;
import Assignment.Screwdriver.Heads;
import Assignment.Drill.Drills;
import Assignment.Wrench.Wrenches;;


public class Main {
    
    
    public static void main(String[] args) {

        Tool hammer1 = new Hammer(Condition.Awful, 9, false , Hammers.Hatchet);
        Tool hammer2 = new Hammer(Condition.Perfect, 1, false , Hammers.Rock);
        Tool hammer3 = new Hammer(Condition.Average, 11, false , Hammers.Blocking); 

        ToolBox toolbox = new ToolBox();

        toolbox.addTool(hammer1);
        toolbox.addTool(hammer2);
        toolbox.addTool(hammer3);

        System.out.println(hammer1.getReplacementUrgency());
        System.out.println(hammer2.getReplacementUrgency());
        System.out.println(hammer3.getReplacementUrgency());
        System.out.println(toolbox.sortByMostDueForReplacement());
        System.out.println(toolbox.getOldestTool());

    }

}

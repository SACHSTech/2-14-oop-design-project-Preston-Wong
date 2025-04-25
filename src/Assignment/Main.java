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
        Tool SD1 = new Screwdriver(Condition.Awful, 19, false, Heads.Philips);
        Tool SD2 = new Screwdriver(Condition.Awful, 50, false, Heads.Philips);

        ToolBox toolbox = new ToolBox();

        toolbox.addTool(hammer1);
        toolbox.addTool(hammer2);
        toolbox.addTool(hammer3);
        toolbox.addTool(SD1);
        toolbox.addTool(SD2);

        // System.out.println(hammer1.getReplacementUrgency());
        // System.out.println(SD1.getReplacementUrgency());
        // System.out.println(SD2.getReplacementUrgency());

        // for (Tool tool : toolbox.sortByMostDueForReplacement()) {

        //     System.out.println(tool.getName() + " is in " + tool.geCondition() + " condition");

        // }

        // System.out.println(toolbox.getOldestTool());
        
        // for (Tool tool : toolbox.getToolsThatNeedToBeReplaced("urgent")) {

        //     System.out.println(tool.getName());

        // }

        // System.out.println(toolbox.getTool("rock hammer"));
        System.out.println(toolbox.getTool("Philips head screwdriver"));
       
        // for (String string : toolbox.getAllToolMaintenance()) {

        //     System.out.println(string);

        // }

        System.out.println(toolbox.getMaintenance("philips head screwdriver"));

        System.out.println(toolbox.getToolForOcssion("bend and shape metals"));

    }

}

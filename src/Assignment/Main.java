package Assignment;

import Assignment.Tool.Condition;
import Assignment.Hammer.Hammers;
import Assignment.Screwdriver.Heads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Assignment.Drill.Drills;
import Assignment.Wrench.Wrenches;;


public class Main {
    
    
    public static void main(String[] args) throws IOException{

        Tool hammer1 = new Hammer(Condition.Awful, 9, false , Hammers.Hatchet);
        Tool hammer2 = new Hammer(Condition.Perfect, 1, false , Hammers.Rock);
        Tool hammer3 = new Hammer(Condition.Average, 11, false , Hammers.Blocking); 
        Tool SD1 = new Screwdriver(Condition.Awful, 19, false, Heads.Philips);
        Tool SD2 = new Screwdriver(Condition.Awful, 50, false, Heads.Flat);

        ToolBox toolbox = new ToolBox();

        toolbox.addTool(hammer1);
        toolbox.addTool(hammer2);
        toolbox.addTool(hammer3);
        toolbox.addTool(SD1);
        toolbox.addTool(SD2);

        while (getUserInput(toolbox) != 7) {



        }



    }

    public static int getUserInput(ToolBox toolbox) throws IOException{


        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        String userInput2 = "";

        System.out.println("What do you want to do? ");
        System.out.println("1: Get oldest tool");
        System.out.println("2: Get replacement urgency for tool");
        System.out.println("3: Recommend tool for occasion");
        System.out.println("4: Get tool maintenance");
        System.out.println("5: Get all tool maintenance");
        System.out.println("6: Print a list of each tool by a certain replacement urgency");
        System.out.println("7: Exit");
        System.out.print("Input: ");
        userInput = Integer.parseInt(userInputReader.readLine());

        switch(userInput) {

            case 1:

                System.out.println(toolbox.getOldestTool());
                break;

            case 2:

                System.out.print("What is the tool you want the replacement urgency? ");
                userInput2 = userInputReader.readLine();
                System.out.println(toolbox.getToolReplacementUrgency(userInput2));
                break;

            case 3:

                System.out.print("Describe the occasion. ");
                userInput2 = userInputReader.readLine();
                System.out.println(toolbox.getToolForOcssion(userInput2));
                break;

            case 4:

                System.out.print("What is the tool you want to get the maintenance of? ");
                userInput2 = userInputReader.readLine();
                System.out.print(toolbox.getMaintenance(userInput2));
                break;

            case 5:

                for (String maintenance : toolbox.getAllToolMaintenance()) {

                    System.out.println(maintenance);

                }
                break;

            case 6:

                System.out.print("What urgency of replacement of tools do you want to see? ");
                userInput2 = userInputReader.readLine();
                for (Tool tool : toolbox.getToolsThatNeedToBeReplaced(userInput2)) {

                    System.out.println(tool.toString());

                }
                break;

        }

        return userInput;
   
 
    }

}


package Assignment;

import Assignment.Tool.Condition;
import Assignment.Hammer.Hammers;
import Assignment.Screwdriver.Heads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.classfile.ClassFile.ConstantPoolSharingOption;

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

        while (getUserInput(toolbox) != 9) {



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
        System.out.println("7: Add tool");
        System.out.println("8: Remove tool");
        System.out.println("9: Exit");
        System.out.print("Input: ");
        userInput = Integer.parseInt(userInputReader.readLine());

        // switch case for user input 
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

            case 7:

                toolbox.addTool(addToolToToolbox(toolbox));
                break;
                
            case 8:

                System.out.print("What is the tool that you want to remove? ");
                userInput2 = userInputReader.readLine();
                toolbox.removeTool(userInput2);
                break;

        }

        return userInput;
   
 
    }

    public static Tool addToolToToolbox(ToolBox toolbox) throws IOException {

        BufferedReader toolInputReader = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        int userInputForTypeOfTool = 0;
        int toolConditionInput = 0;
        int toolAgeInput = 0;
        Tool newTool;
        

        System.out.println("What type of tool do you want to add?");
        System.out.println("1: Screwdriver");
        System.out.println("2: Hammer");
        System.out.println("3: Wrench");
        System.out.println("4: Drill");
        System.out.print("Input: ");
        userInput = Integer.parseInt(toolInputReader.readLine());

        System.out.print("How old is your tool? ");
        toolAgeInput = Integer.parseInt(toolInputReader.readLine());

        System.out.println("What condition is your tool in currently? ");
        System.out.println("1: Awful");
        System.out.println("2: Bad");
        System.out.println("3: Average");
        System.out.println("4: Good");
        System.out.println("5: Perfect");
        toolConditionInput = Integer.parseInt(toolInputReader.readLine());

        switch(userInput) {

            default :

                System.out.println("What type of screwdriver?");
                System.out.println("1: Philips");
                System.out.println("2: Flat");
                System.out.println("3: Star");
                System.out.println("4: Square");
                System.out.println("5: Hexagon");
                System.out.print("Input: ");
                userInputForTypeOfTool = Integer.parseInt(toolInputReader.readLine());

                newTool  = new Screwdriver(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToHeadType(userInputForTypeOfTool));
                return newTool;

        }


    }

    public static Condition convertIntToCondition(int input) {

        switch (input) {

            case 1:

                return Condition.Awful;

            case 2:

                return Condition.Bad;

            case 3:

                return Condition.Average;

            case 4:

                return Condition.Good;

            default:

                return Condition.Perfect;

        }


    }

    public static Heads convertIntToHeadType(int input) {

        switch (input) {

            case 1:

                return Heads.Philips;

            case 2:

                return Heads.Flat;

            case 3:

                return Heads.Star;

            case 4:

                return Heads.Square;

            default:

                return Heads.Hexagon;

        }


    }
    public static Condition convertIntToHammerType(int input) {

        switch (input) {

            case 1:

                return Condition.Awful;

            case 2:

                return Condition.Bad;

            case 3:

                return Condition.Average;

            case 4:

                return Condition.Good;

            default:

                return Condition.Perfect;

        }


    }
    public static Condition convertIntToWrenchType(int input) {

        switch (input) {

            case 1:

                return Condition.Awful;

            case 2:

                return Condition.Bad;

            case 3:

                return Condition.Average;

            case 4:

                return Condition.Good;

            default:

                return Condition.Perfect;

        }


    }
    
    public static Condition convertIntToDrillType(int input) {

        switch (input) {

            case 1:

                return Condition.Awful;

            case 2:

                return Condition.Bad;

            case 3:

                return Condition.Average;

            case 4:

                return Condition.Good;

            default:

                return Condition.Perfect;

        }


    }

}


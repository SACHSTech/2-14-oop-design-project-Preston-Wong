package Assignment;

import Assignment.Tool.Condition;
import Assignment.Hammer.Hammers;
import Assignment.Screwdriver.Heads;
import Assignment.Drill.Drills;
import Assignment.Wrench.Wrenches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    
    public static void main(String[] args) throws IOException{

        // testing tools that are preloaded for now 
        Tool hammer1 = new Hammer(Condition.Awful, 9, false , Hammers.Hatchet);
        Tool hammer2 = new Hammer(Condition.Perfect, 1, false , Hammers.Rock);
        Tool hammer3 = new Hammer(Condition.Average, 11, false , Hammers.Blocking); 
        Tool SD1 = new Screwdriver(Condition.Good, 4, false, Heads.Philips);
        Tool SD2 = new Screwdriver(Condition.Perfect, 1, true, Heads.Flat);
        ToolBox toolbox = new ToolBox();

        toolbox.addTool(hammer1);
        toolbox.addTool(hammer2);
        toolbox.addTool(hammer3);
        toolbox.addTool(SD1);
        toolbox.addTool(SD2);

        while (getUserInput(toolbox) != 100) {

        }



    }

    /**
     * gets what the user wants to do with their toolbox
     * 
     * @param toolbox toolbox, which is a list of all the tools inside it 
     * @return an int of the value of the user input 
     * @throws IOException
     */
    public static int getUserInput(ToolBox toolbox) throws IOException{

        // setting up varaibles 
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        int toolConditionInput = 0;
        int userInput = 0;
        String userInput2 = "";

        // asks thee user for what they want to do 
        System.out.println("What do you want to do? ");
        System.out.println("1: Get oldest tool");
        System.out.println("2: Get replacement urgency for tool");
        //System.out.println("3: Recommend tool for occasion");
        System.out.println("3: Get tool maintenance");
     //   System.out.println("5: Get all tool maintenance");
        System.out.println("4: Print a list of each tool by a certain replacement urgency");
        System.out.println("5: Add tool");
        System.out.println("6: Remove tool");
        System.out.println("7: Get total rental tool value");
        System.out.println("8: Get tool rental price");
        System.out.println("9: Return rental");
        System.out.println("10: Get all avaliable tools");
        System.out.println("11: Rent out a tool");
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

                System.out.print("What is the tool you want to get the maintenance of? ");
                userInput2 = userInputReader.readLine();
                System.out.print(toolbox.getMaintenance(userInput2));
                break;

            case 4:

                System.out.print("What urgency of replacement of tools do you want to see? ");
                userInput2 = userInputReader.readLine();
                for (Tool tool : toolbox.getToolsThatNeedToBeReplaced(userInput2)) {

                    System.out.println(tool.toString());

                }

                break;

            case 5:

                toolbox.addTool(addToolToToolbox(toolbox));
                break;
                
            case 6:

                System.out.print("What is the tool that you want to remove? ");
                userInput2 = userInputReader.readLine();
                toolbox.removeTool(userInput2);
                break;
            
            case 7:

                System.out.println(toolbox.getTotalValue());     
                break;          

            case 8:

                System.out.println("What is the tool? ");
                userInput2 = userInputReader.readLine();
                System.out.println(toolbox.getTool(userInput2).getRentalPrice());
                break;

            case 9:

                System.out.println("What is the tool you are returning? ");
                userInput2 = userInputReader.readLine();
                System.out.println("What is the return condition? ");
                System.out.println("1: Awful");
                System.out.println("2: Bad");
                System.out.println("3: Average");
                System.out.println("4: Good");
                System.out.println("5: Perfect");
                System.out.print("Input: ");
                toolConditionInput = Integer.parseInt(userInputReader.readLine());
                System.out.println("$" + 
                (toolbox.getTool(userInput2).getRentalPrice() + 
                toolbox.getTool(userInput2).getAdditionalFees(convertIntToCondition(toolConditionInput))));
                toolbox.getTool(userInput2).returned();
                break;
            
            case 10:

                System.out.println(toolbox.getAllToolsAvalaible());
                break;

            case 11:
                
                System.out.println("Which tool do you want to rent out? ");
                userInput2 = userInputReader.readLine();
                toolbox.getTool(userInput2).rentOut();
                break;



        }

        return userInput;
   
 
    }

    /**
     * helper method to add a tool into the tool box
     * 
     * @param toolbox the same toolbox object from the main class
     * @return a Tool object 
     * @throws IOException
     */
    public static Tool addToolToToolbox(ToolBox toolbox) throws IOException {

        // setting up variables 
        BufferedReader toolInputReader = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        int userInputForTypeOfTool = 0;
        int toolConditionInput = 0;
        int toolAgeInput = 0;
        int isDrillCordless = 0;
        double toolSize = 0.0;
        Tool newTool;
        
        // asks the user for what type of tool they want to add
        System.out.println("What type of tool do you want to add?");
        System.out.println("1: Screwdriver");
        System.out.println("2: Hammer");
        System.out.println("3: Wrench");
        System.out.println("4: Drill");
        System.out.print("Input: ");
        userInput = Integer.parseInt(toolInputReader.readLine());

        // asks for tool age
        System.out.print("How old is your tool? ");
        toolAgeInput = Integer.parseInt(toolInputReader.readLine());

        // asks for the condition of the tool 
        System.out.println("What condition is your tool in currently? ");
        System.out.println("1: Awful");
        System.out.println("2: Bad");
        System.out.println("3: Average");
        System.out.println("4: Good");
        System.out.println("5: Perfect");
        System.out.print("Input: ");
        toolConditionInput = Integer.parseInt(toolInputReader.readLine());

        // switch case for different types of tools 
        switch(userInput) {

            case 1:

                // asks the user for what type of screwdriver 
                System.out.println("What type of screwdriver?");
                System.out.println("1: Philips");
                System.out.println("2: Flat");
                System.out.println("3: Star");
                System.out.println("4: Square");
                System.out.println("5: Hexagon");
                System.out.print("Input: ");
                userInputForTypeOfTool = Integer.parseInt(toolInputReader.readLine());

                newTool = new Screwdriver(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToHeadType(userInputForTypeOfTool));
                return newTool;
            
            case 2:

                // asks the user what type of wrench 
                System.out.println("What type of Wrench?");
                System.out.println("1: Pipe");
                System.out.println("2: Allen");
                System.out.println("3: Socket");
                System.out.print("Input: ");
                userInputForTypeOfTool = Integer.parseInt(toolInputReader.readLine());

                newTool = new Hammer(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToHammerType(userInputForTypeOfTool));
                return newTool;

            case 3:

                // asks the user for what type of hammer 
                System.out.println("What type of Hammer?");
                System.out.println("1: Rock");
                System.out.println("2: Hatchet");
                System.out.println("3: Blocking");
                System.out.print("Input: ");
                userInputForTypeOfTool = Integer.parseInt(toolInputReader.readLine());

                System.out.print("What is the size of your wrench? ");
                toolSize = Double.parseDouble(toolInputReader.readLine());

                newTool = new Wrench(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToWrenchType(userInputForTypeOfTool), toolSize);
                return newTool;

            case 4:

                // asks the user for what type of drill 
                System.out.println("What type of Drill?");
                System.out.println("1: Hammer");
                System.out.println("2: Impact");
                System.out.println("3: Core");
                System.out.print("Input: ");
                userInputForTypeOfTool = Integer.parseInt(toolInputReader.readLine());

                // asks the user if the drill is cordless 
                System.out.println("Is your drill cordless? ");
                System.out.println("1: True");
                System.out.println("2: False");
                isDrillCordless = Integer.parseInt(toolInputReader.readLine());

                // creates a different drill depending on if the drill is cordless or not 
                switch (isDrillCordless) {

                    case 1:
                        
                        newTool = new Drill(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToDrillType(userInputForTypeOfTool), true);
                        return newTool;
                
                    default:

                        newTool = new Drill(convertIntToCondition(toolConditionInput), toolAgeInput, false, convertIntToDrillType(userInputForTypeOfTool), false);
                        return newTool;
              
                }


        }

        return null;


    }

    // helper method to conert the user int input to a condition value 
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

    // helper method to convert the user int input to a screw driver head type 
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

    // helper method to convert the user int input to a hammer type 
    public static Hammers convertIntToHammerType(int input) {

        switch (input) {

            case 1:

                return Hammers.Rock;

            case 2:

                return Hammers.Hatchet;

            default:

                return Hammers.Blocking;

        }


    }

    // helper method to convert the user int value to a wrench type 
    public static Wrenches convertIntToWrenchType(int input) {

        switch (input) {

            case 1:

                return Wrenches.Pipe;

            case 2:

                return Wrenches.Allen;

            default:

                return Wrenches.Socket;

        }


    }
    
    // helper method to convert the user int input to a drill type 
    public static Drills convertIntToDrillType(int input) {

        switch (input) {

            case 1:

                return Drills.Hammer;

            case 2:

                return Drills.Impact;

            default:

                return Drills.Core;

        }


    }

}


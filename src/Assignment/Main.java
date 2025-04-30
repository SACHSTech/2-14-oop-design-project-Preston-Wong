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
    
    public static void main(String[] args) throws IOException {

        // testing tools that are preloaded for now 
        ToolBox toolbox = new ToolBox();
        Tool hammer1 = new Hammer(Condition.Awful, 9, false , Hammers.Hatchet);
        Tool hammer2 = new Hammer(Condition.Perfect, 1, false , Hammers.Rock);
        Tool hammer3 = new Hammer(Condition.Average, 11, false , Hammers.Blocking); 
        Tool SD1 = new Screwdriver(Condition.Good, 4, false, Heads.Philips);
        Tool SD2 = new Screwdriver(Condition.Perfect, 1, true, Heads.Flat);
        Tool drill1 = new Drill(Condition.Average, 4, false, Drills.Impact, true);
        Tool drill2 = new Drill(Condition.Perfect, 4, false, Drills.Hammer, true);
        Tool wrench1 = new Wrench(Condition.Awful, 10, false, Wrenches.Allen, 2.0);
        Tool wrench2 = new Wrench(Condition.Good, 10, false, Wrenches.Pipe,5.0);

        toolbox.addTool(hammer1);
        toolbox.addTool(hammer2);
        toolbox.addTool(hammer3);
        toolbox.addTool(SD1);
        toolbox.addTool(SD2);
        toolbox.addTool(drill1);
        toolbox.addTool(drill2);
        toolbox.addTool(wrench1);
        toolbox.addTool(wrench2);

        // keeps running until the user enters the value to exit 
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
    public static int getUserInput(ToolBox toolbox) throws IOException {

        // setting up varaibles 
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        int userInput = 0;
        String secondUserInput = "";
        String condition = "";
        int thirdUserInput = 0;

        // asks thee user for what they want to do 
        System.out.println("What do you want to do? ");
        System.out.println("1: Get Cheapest tool");
        System.out.println("2: Get replacement urgency for tool");
        System.out.println("3: Get tool maintenance");
        System.out.println("4: Print a list of each tool by a certain replacement urgency");
        System.out.println("5: Add tool");
        System.out.println("6: Remove tool");
        System.out.println("7: Get total toolbox value");
        System.out.println("8: Get tool rental price");
        System.out.println("9: Get all avaliable tools");
        System.out.println("10: Get all checked out tools ");
        System.out.println("11: Return rental");
        System.out.println("12: Rent out a tool");
        System.out.println("13: Get price to fix a certain tool");
        System.out.println("14: Should you keep or throw out a tool?");
        System.out.println("9: Exit");
        System.out.print("Input: ");
        userInput = Integer.parseInt(userInputReader.readLine());
        System.out.println();

        // switch case for user input 
        switch(userInput) {

            case 1:

                System.out.println("The cheapest tool in our toolbox is " + toolbox.getCheapestTool().getName() + " at a price of $" + toolbox.getCheapestTool().getRentalPrice() + "\n");
                break;

            case 2:

                System.out.print("What is the tool you want the replacement urgency? ");
                secondUserInput = userInputReader.readLine();
                System.out.println(toolbox.getToolReplacementUrgency(secondUserInput) + "\n");
                break;

            case 3:

                System.out.print("What is the tool you want to get the maintenance of? ");
                secondUserInput = userInputReader.readLine();
                System.out.print(toolbox.getMaintenance(secondUserInput) + "\n");
                break;

            case 4:

                System.out.print("What urgency of replacement of tools do you want to see? ");
                secondUserInput = userInputReader.readLine();

                // loops through all tools 
                for (Tool tool : toolbox.getToolsThatNeedToBeReplaced(secondUserInput)) {

                    System.out.println(tool.toString());

                }
                System.out.println();
                break;

            case 5:

                toolbox.addTool(addToolToToolbox(toolbox));
                System.out.println("Tool was successfully added to toolbox \n");
                break;
                
            case 6:

                System.out.print("What is the tool that you want to remove? ");
                secondUserInput = userInputReader.readLine();
                toolbox.removeTool(secondUserInput);
                System.out.println(secondUserInput + " was removed from the toolbox \n");
                break;
            
            case 7:

                System.out.println("The entire toolbox is worth $" + toolbox.getTotalValue() + "\n");     
                break;          

            case 8:

                System.out.println("What is the tool? ");
                secondUserInput = userInputReader.readLine();

                // checks to see if the inputted name is valid, if not, it will tell the user
                if ((toolbox.getTool(secondUserInput) != null)) {

                    System.out.println("$" + Math.round(toolbox.getTool(secondUserInput).getRentalPrice() * 100.0) / 100.0 + " is the rental price for the " + secondUserInput + "\n");

                } else {

                    System.out.println("Not a valid tool name \n");

                }
                break;

            case 9:

                // loops through all tools 
                for (Tool tool : toolbox.getAllToolsAvaliable()) {

                    System.out.print(tool.toString());
                }
                System.out.println();
                break;

            case 10:

                for (Tool tool : toolbox.getCheckedOutTools()) {

                    System.out.print(tool.toString());

                }
                System.out.println();
                break;

            case 11:

                System.out.println("What is the tool you are returning? ");
                secondUserInput = userInputReader.readLine();

                System.out.println("What is the return condition? ");
                System.out.println("1. Awful");
                System.out.println("2. Bad");
                System.out.println("3. Average");
                System.out.println("4. Good");
                System.out.println("5. Perfect");
                System.out.print("Input: ");
                thirdUserInput = Integer.parseInt(userInputReader.readLine());

                // sets the condition to the value that the user wants 
                switch (thirdUserInput) {

                    case 1:
                        
                        condition = "Awful";
                        break;
                
                    case 2:

                        condition = "Bad";
                        break;

                    case 3:

                        condition = "Average";
                        break;

                    case 4:

                        condition = "Good";
                        break;

                    case 5:

                        condition = "Perfect";
                        break;
                }

                // checks to see if the inputted name is valid, if not, it will tell the user
                if ((toolbox.getTool(secondUserInput) != null)) {

                    double rentalPrice = (Math.round((toolbox.getTool(secondUserInput).getRentalPrice() * 100.0))) / 100.0;
                    double additionalFees = (Math.round(((toolbox.getTool(secondUserInput).getAdditionalFees(Condition.valueOf(condition))) * 100.0)) / 100.0);

                    System.out.println("The rental price  is: $" + rentalPrice + " - additional fees is $" + additionalFees + " - Total $" + (rentalPrice + additionalFees));
                    toolbox.getTool(secondUserInput).returned();

                } else {

                    System.out.println("Not a valid tool name");

                }
                break;

            case 12:
                
                System.out.println("Which tool do you want to rent out? ");
                secondUserInput = userInputReader.readLine();
                
                // checks to see if the inputted name is valid, if not, it will tell the user
                if (toolbox.getTool(secondUserInput) != null) {

                    toolbox.getTool(secondUserInput).rentOut();

                } else {

                    System.out.println("Not a valid tool name");

                }
                break;

            case 13:

                System.out.println("What tool do you want to find the repair cost of? ");
                System.out.print("Tool Name: ");
                secondUserInput = userInputReader.readLine();
                if (toolbox.getRepairCost(secondUserInput) == -1) {

                    System.out.println("Not a valid tool name"); 

                } else {

                    System.out.println("To repair this tool fully, it will cost $" + toolbox.getRepairCost(secondUserInput) + "\n");

                }
                break;

            case 14:

                System.out.println("What is the tool that you want to know if you should repair or throw out?");
                System.out.print("Tool Name: ");
                secondUserInput = userInputReader.readLine();
                System.out.println(toolbox.shouldRemove(secondUserInput) + "\n");
                break;

            default:

                System.out.println("Not a valid option, please input a VALID option \n");

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
        String toolType = "";
        int userInput = 0;
        int isDrillCordless = 0;
        int toolTypeInput = 0;
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

        // switch case for different types of tools 
        switch(userInput) {

            case 1:

                // asks the user for what type of screwdriver 
                System.out.println("What type of screwdriver?");
                System.out.println("1. Philips");
                System.out.println("2. Flat");
                System.out.println("3. Star");
                System.out.println("4. Square");
                System.out.println("5. Hexagon");
                System.out.print("Input: ");
                toolTypeInput = Integer.parseInt(toolInputReader.readLine());

                // sets the string to be a certian screwdriver type
                switch(toolTypeInput) {

                    case 1:

                        toolType = "Philips";
                        break;

                    case 2:

                        toolType = "Flat";
                        break;

                    case 3:

                        toolType = "Star";
                        break;

                    case 4:

                        toolType = "Square";
                        break;

                    case 5:

                        toolType = "Hexagon";
                        break;

                }

                newTool = new Screwdriver(Condition.Perfect, 0, false, Heads.valueOf(toolType));
                return newTool;
            
            case 2:

                // asks the user for what type of hammer 
                System.out.println("What type of Hammer?");
                System.out.println("1. Rock");
                System.out.println("2. Hatchet");
                System.out.println("3. Blocking");
                System.out.print("Input: ");
                toolTypeInput = Integer.parseInt(toolInputReader.readLine());

                // sets the string to be a certian hammer type
                switch(toolTypeInput) {

                    case 1:

                        toolType = "Rock";
                        break;

                    case 2:

                        toolType = "Hatchet";
                        break;

                    case 3:

                        toolType = "Blocking";
                        break;

                }

                newTool = new Hammer(Condition.Perfect, 0, false, Hammers.valueOf(toolType));
                return newTool;

            case 3:

                // asks the user what type of wrench 
                System.out.println("What type of Wrench?");
                System.out.println("1. Pipe");
                System.out.println("2. Allen");
                System.out.println("3. Socket");
                System.out.print("Input: ");
                toolTypeInput = Integer.parseInt(toolInputReader.readLine());

                // sets the string to be a certian wrench type
                switch(toolTypeInput) {

                    case 1:

                        toolType = "Pipe";
                        break;

                    case 2:

                        toolType = "Allen";
                        break;

                    case 3:

                        toolType = "Socket";
                        break;

                }

                System.out.print("What is the size of your wrench? ");
                toolSize = Double.parseDouble(toolInputReader.readLine());

                newTool = new Wrench(Condition.Perfect, 0, false, Wrenches.valueOf(toolType), toolSize);
                return newTool;

            case 4:

                // asks the user for what type of drill 
                System.out.println("What type of Drill?");
                System.out.println("1: Hammer");
                System.out.println("2: Impact");
                System.out.println("3: Core");
                System.out.print("Input: ");
                toolTypeInput = Integer.parseInt(toolInputReader.readLine());

                // sets the string to be a certian drill type
                switch(toolTypeInput) {

                    case 1:

                        toolType = "Hammer";
                        break;

                    case 2:

                        toolType = "Impact";
                        break;

                    case 3:

                        toolType = "Core";
                        break;

                }

                // asks the user if the drill is cordless 
                System.out.println("Is your drill cordless? ");
                System.out.println("1: Yes");
                System.out.println("2: No");
                isDrillCordless = Integer.parseInt(toolInputReader.readLine());

                // creates a different drill depending on if the drill is cordless or not 
                switch (isDrillCordless) {

                    case 1:
                        
                        newTool = new Drill(Condition.Perfect, 0, false, Drills.valueOf(toolType), true);
                        return newTool;
                
                    default:

                        newTool = new Drill(Condition.Perfect, 0, false, Drills.valueOf(toolType), false);
                        return newTool;
              
                }


        }

        return null;

    }

}
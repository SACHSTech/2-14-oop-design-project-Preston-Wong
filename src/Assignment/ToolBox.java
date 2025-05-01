package Assignment;
import java.util.ArrayList;

import Assignment.Tool.Condition;

/**
 * contians a list of tools and is what the user interacts with to get specific tools or details about them.
 * Allows the user to sort tools by most urgent to be repalced, find a certain tool by name, add or remove tools,
 * get oldest, checked out tools 
 */
public class ToolBox {
    
    ArrayList<Tool> tools = new ArrayList<>();

    public ToolBox() {

    }

    /**
     * get a tool by name
     * 
     * @param name name of the tool
     * @return the tool 
     */
    public Tool getTool(String toolName) {

        for (Tool tool : tools) {

            // checks tool name, not case sensitive 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {
                return tool;
            }
        }
        return null;
    }

    /**
     * adds a tool to the toolbox
     * 
     * @param tool tool that is added
     */
    public void addTool(Tool tool) {

        tools.add(tool);

    }

    /**
     * removes a tool from the toolbox
     * 
     * @param String tool name wants to be removed that is removed 
     */
    public void removeTool(String toolName) {

        for (Tool tool : tools) {

            // checks the tool name, not case sensitive 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {
                tools.remove(tool);
                break;
            }
        }
    }

    /**
     * finds all tools that are checked out 
     * 
     * @return an organized list of all tools that are checked out 
     */
    public ArrayList<Tool> getCheckedOutTools() {

        ArrayList<Tool> checkedOutTools = new ArrayList<>();

        for (Tool tool : tools) {

            if (tool.isCheckedOut() == true) {
                checkedOutTools.add(tool);
            }
        }
        return checkedOutTools;
    }

    /**
     * finds the tool that needs to be replaced the most 
     * 
     * @return the tool that needs to be replaced 
     */
    public ArrayList<Tool> getToolsThatNeedToBeReplaced(String urgency) {

        ArrayList<Tool> filteredTool = new ArrayList<>();

        for (Tool tool : tools) {

            if (tool.getReplacementUrgency().toUpperCase().equals(urgency.toUpperCase())) {
                filteredTool.add(tool);
            }            
        }
        return filteredTool;
    }

    /**
     * gets the maintenance for one tool 
     * 
     * @param toolName tool name
     * @return maintenance for one tool 
     */
    public String getMaintenance(String toolName) {

        // cycles through each tool 
        for (Tool tool : tools) {

            // checks to see if the tool name matches with the inputted one 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {
                return "to maintain a " + tool.getName() + " - " + tool.getMaintenance();
            }
        }
        return "that is not a valid tool name";
    }

    /**
     * gets the replacement urgecy for one tool 
     * 
     * @param toolName name of tool 
     * @return the urgency to replace that tool 
     */
    public String getToolReplacementUrgency(String toolName) {

        // loops through all tools
        for (Tool tool : tools) {

            // checks to see if the names match 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {
                return tool.getReplacementUrgency();
            }
        }
        return "not a valid tool name";
    }

    /**
     * gets the total value of the toolbox
     * 
     * @return a double value of the total value of the tools in the toolbox
     */
    public double getTotalValue() {

        double totalValue = 0;

        // loops through all the tools in the toolbox
        for (Tool tool : tools) {
            totalValue += tool.getCurrentValue();
        }
        return Math.round(totalValue * 100.0) / 100.0;
    }

    /**
     * gets all tools that can be rented out 
     * 
     * @return a list of all tools that can be rented out 
     */
    public ArrayList<Tool> getAllToolsAvaliable() {

        ArrayList<Tool> toBeReturend = new ArrayList<>();

        // loops through all the tools in the toolbox
        for (Tool tool : tools) {

            // can only be rented if the condtiion is above awful and if its currently in inventory 
            if ((tool.isCheckedOut() != true) && (tool.getCondition() != Condition.Awful)) {
                toBeReturend.add(tool);
            }

        }
        return toBeReturend;
    }

    /**
     * gets the repair cost for a tool 
     * 
     * @param toolName name of the tool 
     * @return a double value of how much it will take to repair it 
     */
    public double getRepairCost(String toolName) {

        for (Tool tool : tools) {

            // checks the name, not case sensitive 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {
                return tool.getPriceToFix();
            }

        }
        return 0.0;
    }

    /**
     * determines if you should repair the tool or just throw it away 
     * 
     * @param toolName
     * @return a string of if you should remove the tool or repair it 
     */
    public String shouldRemove(String toolName) {

        for (Tool tool: tools) {

            // checks the tool name, not case sensitive 
            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {

                // checks to see if the value of the tool is greater than the pride to fix it, and if hte condition is within a certain range 
                if ((tool.getCurrentValue() >= tool.getPriceToFix()) && ((tool.getCondition() != Condition.Good) || (tool.getCondition() != Condition.Perfect))) {
                    return "You should repair it and not throw it away. ";
                } else if (tool.getCurrentValue() < tool.getPriceToFix()) {
                    return "You should just throw it away, the price to fix it is higher than the rental price, it's not worth fixing.";
                }
            }
        }
        return "No need to fix or throw away the tool, the tool is fine as is.";
    }

    /**
     * gets the cheapest tool 
     * 
     * @return the tool that is the cheapest 
     */
    public Tool getCheapestTool() {

        // the double value is set to the first tool in the toolbox 
        double currentCheapestTool = tools.get(0).getRentalPrice();
        int index = 0;

        for (int i = 0; i < tools.size(); i++) {

            if (tools.get(i).getRentalPrice() < currentCheapestTool) {
                index = i;
            }

        }
        return tools.get(index);
    }

    /**
     * checks to see if the inputted tool name is a valid name 
     * 
     * @param toBeChecked name of the tool 
     * @return true or false depending on if the tool is valid 
     */
    public boolean isValid(String toBeChecked) {

        for (Tool tool : tools) {

            // checks to see if the name inputted is valid, removing the need to check for casing 
            if (tool.getName().toUpperCase().equals(toBeChecked.toUpperCase())) {
                return true;
            }

        }
        return false;
    }

}

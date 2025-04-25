package Assignment;
import java.util.ArrayList;

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
    public String getTool(String toolName) {

        for (Tool tool : tools) {

            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {

                return tool.getFunction();

            }

        }

        return "You don't have a tool by that name";

    }

    /**
     * get the correct tool for the job 
     * 
     * @param occasion the scenario that the user needs the tool for 
     * @return the tool that fits the scenario 
     */
    public Tool getToolForOcssion(String occasion) {

        for (Tool tool : tools) {

            if (tool.getFunction().toUpperCase().equals(occasion.toUpperCase())) {

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
     * @param tool tool that is removed 
     */
    public void removeTool(Tool tool) {

        tools.remove(tool);

    }

    /**
     * sort by tools that need to be repalced the most
     * 
     * @return an organized list of tools 
     */
    public ArrayList<Tool> sortByMostDueForReplacement() {

        ArrayList<Tool> filteredToolList = new ArrayList<>();
        String[] urgency = {"Very Urgent", "Urgent", "Soon", "Not Soon", "Long Time"};

        for (int i = 0; i < urgency.length; i++) {

            for (Tool filterTool : tools) {

                if (filterTool.getReplacementUrgency().toUpperCase().equals(urgency[i].toUpperCase())) {

                    filteredToolList.add(filterTool);

                }

            }

        }

        return filteredToolList;

    }

    /**
     * finds all tools that are checked out 
     * 
     * @return an organized list of all tools that are checked out 
     */
    public ArrayList<Tool> getCheckedOutTools() {

        return null;

    }

    /**
     * gets the oldest tool in the toolbox
     * 
     * @return the oldest tool 
     */
    public Tool getOldestTool() {

        int index = 0;
        int oldestAge = 0;

        for (int i = 0; i < tools.size(); i++) {

            if (tools.get(i).getAge() > oldestAge) {

                oldestAge = tools.get(i).getAge();
                index = i;

            }

        }

        return tools.get(index);

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

    public ArrayList<String> getAllToolMaintenance() {

        ArrayList<String> maintenance = new ArrayList<>();

        for (Tool tool : tools) {

            maintenance.add(tool.getMaintenance());

        }

        return maintenance;

    }

    public String getMaintenance(String name) {

        for (Tool tool : tools) {

            if (tool.getName().toUpperCase().equals(name.toUpperCase())) {

                return "to maintain a " + tool.getName() + " - " + tool.getMaintenance();

            }

        }

        return "that is not a valid tool name";

    }

    public String getToolReplacementUrgency(String toolName) {

        for (Tool tool : tools) {

            if (tool.getName().toUpperCase().equals(toolName.toUpperCase())) {

                return tool.getReplacementUrgency();

            }

        }

        return "not a valid tool name";

    }

}

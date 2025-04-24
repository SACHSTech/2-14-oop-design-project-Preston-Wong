import java.util.ArrayList;

public class ToolBox {
    
    ArrayList<Tool> tool = new ArrayList<>();

    public ToolBox() {



    }

    /**
     * get a tool by name
     * 
     * @param name name of the tool
     * @return the tool 
     */
    public Tool getTool(String name) {

        return null;

    }

    /**
     * get the correct tool for the job 
     * 
     * @param occasion the scenario that the user needs the tool for 
     * @return the tool that fits the scenario 
     */
    public Tool getToolForOcssion(String occasion) {

        return null;

    }

    /**
     * adds a tool to the toolbox
     * 
     * @param tool tool that is added
     */
    public void addTool(Tool tool) {



    }

    /**
     * removes a tool from the toolbox
     * 
     * @param tool tool that is removed 
     */
    public void removeTool(Tool tool) {



    }

    /**
     * sort by tools that need to be repalced the most
     * 
     * @return an organized list of tools 
     */
    public ArrayList<Tool> sortByMostDueForReplacement() {

        ArrayList<Tool> filteredToolList = new ArrayList<>();
        String[] urgency = {"Very Urgent", "Urgent", "Soon", "Not Soon", "Long Time"};

        for (Tool filterTool : tool) {

            for (int i = 0; i < urgency.length; i++) {

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

        return null;

    }

    /**
     * finds the tool that needs to be replaced the most 
     * 
     * @return the tool that needs to be replaced 
     */
    public Tool getMostUrgentToBeReplacedTool() {

        return null;

    }

}

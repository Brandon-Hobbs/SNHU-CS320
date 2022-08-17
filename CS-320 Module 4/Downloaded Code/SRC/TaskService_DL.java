/* Brandon Hobbs
 * CS-320
 * 7/20/2022
 */

import java.util.HashMap;

public class TaskService_DL {
	
	int currentIDNum = 0; //pseudo GUID
	
	public static HashMap<String, Task_DL> tasks = new HashMap<String, Task_DL>();
	
	public void addUniqueTask(String _name, String _description) {

		String stringID = Integer.toString(currentIDNum);		
		Task_DL tempTask = new Task_DL (stringID, _name, _description);
		tasks.put(stringID, tempTask);	

		++currentIDNum;		
	}
	
	public void deleteTasks(String _ID) {
		
		if(tasks.containsKey(_ID)) {			
			tasks.remove(_ID);
		}		
	}
	
	public void updateTasks(String _ID, String _newName, String _newDescription) {
		
		if(tasks.containsKey(_ID)) {
			
			tasks.get(_ID).setName(_newName);
			tasks.get(_ID).setDescription(_newDescription);
		}
		
	}
}


package project2omeros;

/**
 * This class is a User with extra rights.
 * He can create a new hall or edit existing ones
 * @author GeorgeKirm
 * @author GT
 */
public class Admins extends Users{
  
    /**
     * This method checks if the user has permission from another admin to register as a new
     * @param adminName the name of the admin that gave permission to the user
     * @param adminPassword the password of that admin
     * @return 
     */
    public boolean adminChecker(String adminName, String adminPassword){
        if(userMap.containsKey(adminName)){ //briskei ama ta stixia pou dothikan uparxoun sto UserMap
            if(userMap.get(adminName).get(0).equals(adminPassword)&&userMap.get(adminName).get(1).equals("A")){
                return true;
            }
        }
        return false;
    }
}
    
    
    
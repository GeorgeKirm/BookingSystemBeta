package project2omeros;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class shows lists of events and book/cancels an event veriable
 * @author GeorgeKirm
 * @author GT
 */
public class Users {
    Map<String,List<String>> userMap = new HashMap<String,List<String>>();
    public Users(){
        userMap = new HashMap<>();
        try (BufferedReader theFile = new BufferedReader(new FileReader("UserMap.txt"))) { //anoigei to arxeio gia diabasma
            String InfoFromFileLine; //auto to string tha apothikeuei kathe gramh tou arxeiou
            int i=0;
            while ((InfoFromFileLine = theFile.readLine()) != null) { //diabazei mia mia tis grames tou arxeiou
                String[] InfoFromFileAll = InfoFromFileLine.split(" "); //otan uparxei keno sthn kathe seira tote sumenei oti meta to keno einai h epomenh metablith
                List<String> variableFromFile = new ArrayList<String>(); //edw xorizonte h kathe metablith apo to InfoFromFileAll
                variableFromFile.add(InfoFromFileAll[1]); //apothikeuete to password
                variableFromFile.add(InfoFromFileAll[2]); // apothikeuonte ta rights
                userMap.put(InfoFromFileAll[0], variableFromFile);
            }
        } catch (Exception e) { //to arxeio exei kapoio lathos mesa (to lathos sunithos dimiourgite ama ginei editing tou arxeiou ektos programatos kai mpei kapoio parapono keno h' kati analogo
             JOptionPane.showMessageDialog(null, "It apears to be a problem with the program file.\n"
                     + "If the problem continue please replace\n\"UserMapErrorHelper.txt with\" "
                     + "\"UserMap.txt\".", "Error message", JOptionPane.PLAIN_MESSAGE);
//            NewJFrame temp = new NewJFrame();
//            temp.setLocationRelativeTo(null);
//            temp.setVisible(true);
        }
    }
    
    /**
     * This method register an admin or a user to the program.
     * @param newName is the username that the user wants to have to his account
     * @param newPassword1 is the password that user gives to his account
     * @param newPassword2 checks if the user put the newPassword1 that he wants
     * @param rights if its "U" its user if its "A" its admin
     */
    public void registerNewUser(String newName, String newPassword1, String newPassword2, String rights){
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("UserMap.txt", true)))) { //anoigei to arxeio gia egrafh sthn teleutea sira
            if (!(userMap.containsKey(newName))){ //elenxoume ama to onoma me to opoio thelei o neos xristis na kanei register uparxei idi
                if(newPassword1.equals(newPassword2)){ //elegxos gia ama ta 2 passwords pou edose o xristis einai idia
                    theFile1.println(newName+" "+newPassword1+" "+rights); //grafonte oi metablites sto arxeio me ena keno anamesa gia na diaxorizonte meta3u tous
                    Account.cName = newName; //o xristis ekane log in ara oi 3 global metablites prepei na paroun times
                    Account.cPasswordAndRights[0] = newPassword1;
                    Account.cPasswordAndRights[1] = rights;
                    GUIforUser temp = new GUIforUser(); //o xristis ekane register ara kai log in kai giauto sundeete me to kurio programma tou sustimatos
                    temp.setLocationRelativeTo(null); //to neo GUI emfanizete sto kentro
                    temp.setVisible(true); // to neo GUI ginete orato
                    JOptionPane.showMessageDialog(null, "Your account has been registered successfully!\n"
                            + "You are now loged in.", "Hello "+ newName, JOptionPane.PLAIN_MESSAGE);                     
                }else{ //oi duo kodikoi den itan idioi kai giauto emfanizete 3ana to parathiro tou register
                    GUIforLogIn_Register temp = new GUIforLogIn_Register('r');
                    temp.setLocationRelativeTo(null);
                    temp.setVisible(true);
                    JOptionPane.showMessageDialog(null, "The two passwords are not the same, please try agien.", 
                       "Error message", JOptionPane.PLAIN_MESSAGE);
                }       
            }else{ //to onoma uparxei idi kai giauto emfanizete 3ana to patathiro tou register
                GUIforLogIn_Register temp = new GUIforLogIn_Register('r');
                temp.setLocationRelativeTo(null);
                temp.setVisible(true);
                JOptionPane.showMessageDialog(null, "The user name is already in use, please put different user name.", 
                        "Error message", JOptionPane.PLAIN_MESSAGE);
            }
        }catch (IOException e) { //uparxei problime me to .txt file (auto to problima den dimiourgithike apo to programa)
            JOptionPane.showMessageDialog(null, "It apears to be a problem with the program files.", 
                    "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }    
    
    /**
     * This method "log in" the user/admin.
     * @param logInName is the name of the users account
     * @param logInPassword is the password of the users account
     */
    public void logIn (String logInName, String logInPassword){ //users+admins
        if(userMap.containsKey(logInName)){ // Users ellenxei ama uparxei name
            List<String> infoFromUserMap = new ArrayList<String>();
            infoFromUserMap = userMap.get(logInName); // pairnei ta stixeia apo to hash map
            if (logInPassword.equals(infoFromUserMap.get(0))){ // Ellenxei to password
                Account.cName = logInName; //apothikeuei ta stixia stis global metablites
                Account.cPasswordAndRights[0] = logInPassword;
                if(infoFromUserMap.get(1).equals("U")){ //elegxei ama o xristis pou ekane log in einai apothikeumenos os user h' admin
                    Account.cPasswordAndRights[1] = "U"; //ama einai user ta rights tou pairnoun thn timi "U"
                    JOptionPane.showMessageDialog(null, "You have succesfully loged in as a user.", 
                            "Hello "+ logInName, JOptionPane.PLAIN_MESSAGE);
                }else if(infoFromUserMap.get(1).equals("A")){
                    Account.cPasswordAndRights[1] = "A"; //antistixa gia to ama einai admin
                    JOptionPane.showMessageDialog(null, "You have succesfully loged in as an admin.", 
                            "Hello "+ logInName, JOptionPane.PLAIN_MESSAGE);
                }
                GUIforUser temp = new GUIforUser(); //ekana log in ara emfanizete to parathiro tou kurios parathirou
                temp.setLocationRelativeTo(null);
                temp.setVisible(true);
            }else{ // To password den einai sosto
                JOptionPane.showMessageDialog(null, "You have put wrong username or password.", 
                        "Security check "+ logInName, JOptionPane.PLAIN_MESSAGE);
                GUIforLogIn_Register temp = new GUIforLogIn_Register('l'); //3anaemfanizete to parathiro gia na kanei log in
                temp.setLocationRelativeTo(null);
                temp.setVisible(true);
            }
        }else{ // Den uparxei tetoio Onoma apothikeumeno sto userMap
            JOptionPane.showMessageDialog(null, "You have put wrong username or password.", 
                    "Security check "+ logInName, JOptionPane.PLAIN_MESSAGE);
            GUIforLogIn_Register temp = new GUIforLogIn_Register('l');  //3anaemfanizete to parathiro gia na kanei log in
            temp.setLocationRelativeTo(null);
            temp.setVisible(true);
        }   
    }
    

    
    /**
     * This method changes the password of a user
     * @param givenPassword is the password that the user wants to change. It is for security check
     * @param newPassword1 is the password that the user wants to change to
     * @param newPassword2 is for checking if the user put as new password the password he wants
     */
    public void changePassword(String givenPassword, String newPassword1, String newPassword2){
        int check = 0; //ama einai 2 mpenei mesa sto if kai emfanizei 3ana to GUI gia hange password
        if(Account.cPasswordAndRights[0].equals(givenPassword)){ // To password pou mas edose den einai idio me to cPassword
            if(newPassword1.equals(newPassword2)){ // Ta 2 passwords einai omoia  
                List<String> updateUserMap = new ArrayList<String>(); //me authn thn metablith tha ginei update sto userMap
                updateUserMap.add(newPassword1); //tis prosthetoume to neo password
                updateUserMap.add(Account.cPasswordAndRights[1]);// kai ta palia dikeomata tou xristi
                userMap.put(Account.cName, updateUserMap); //Sto hashmap mpenei to neo password
                try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("UserMap.txt", false)))) { //3anagrafete olo to arxeio apo thn arxh
                    for (Map.Entry<String, List<String>> entry : userMap.entrySet()) {
                        String key = entry.getKey();
                        List<String> values = entry.getValue();
                        theFile1.println(key+" "+values.get(0)+" "+values.get(1));
                    }
                    JOptionPane.showMessageDialog(null, "The password has successfully change to the new one.", 
                            "User message", JOptionPane.PLAIN_MESSAGE);
                    Account.cPasswordAndRights[0] = newPassword1; //ginete update kai h global metablith
                }catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "It apears to be a problem with the program files.", 
                            "Error message", JOptionPane.PLAIN_MESSAGE);
                    check = 2;
                }
            }else{
                JOptionPane.showMessageDialog(null, "The two passwords are not the same, please try agien.", 
                        "Error message", JOptionPane.PLAIN_MESSAGE);
                check = 2;
            }
        }else{
            JOptionPane.showMessageDialog(null, "You have inserted a wrong password, please try agien.", 
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            check = 2;
        }
        if(check == 2){
            GUIforChangePassword temp1 = new GUIforChangePassword(); //edose kapoio lathos o xristis kai giauto 3anaemfanizete to GUIforChagePassword parathiro
            temp1.setLocationRelativeTo(null);
            temp1.setVisible(true);
        }
    }
    
    /**
     * This method deletes an account and returns the user to the first GUI panel
     */
    public void deleteAccount(){
        userMap.remove(Account.cName); //ginete remove apo to userMap to account
        Account.cName = null; // pairnoun null oles oi global metablites (etsi stin ousia o xristis den einai sundedemenos)
        Account.cPasswordAndRights[0] = null;
        Account.cPasswordAndRights[1] = null;
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("UserMap.txt", false)))) { //3anagrafete apo thn arxh to arxeio xoris to account
            for (Map.Entry<String, List<String>> entry : userMap.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                theFile1.println(key+" "+values.get(0)+" "+values.get(1));
            }
            JOptionPane.showMessageDialog(null, "Your account has been successfully deleted.", 
                    "User message", JOptionPane.PLAIN_MESSAGE);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "It apears to be a problem with the program files.", 
                    "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * This method "logs out" the user and returns him to the first GUI panel
     */
    public void logOut(){
        Account.cName = null; //pairnoun null oi global metablites
        Account.cPasswordAndRights[0] = null;
        Account.cPasswordAndRights[1] = null;
        JOptionPane.showMessageDialog(null, "You have successfully log out.", 
                "User message", JOptionPane.PLAIN_MESSAGE);
    }
    

}

package project2omeros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * This class creates the rooms of the cinema/theater
 * @author GeorgeKirm
 * @author GT
 * v1
 */
public class HallSeats {
    Map<String, List<String>> cinemaMap = new HashMap<String, List<String>>();
    Map<String, List<String>> theaterMap = new HashMap<String, List<String>>();
    Map<String, List<String>> eventHallMap = new HashMap<String, List<String>>();
    
    public HallSeats(){
        cinemaMap = new HashMap<>();
        theaterMap = new HashMap<>();
        try (BufferedReader theFile = new BufferedReader(new FileReader("HallsMap.txt"))) {
            String InfoFromFile;
            while ((InfoFromFile = theFile.readLine()) != null) {
                String[] InfoFromFileAll = InfoFromFile.split(">~~Dnt@Dlt~~<");
                List<String> valSetOne = new ArrayList<String>();
                valSetOne.add(InfoFromFileAll[1]);
                valSetOne.add(InfoFromFileAll[2]);
                valSetOne.add(InfoFromFileAll[3]);
                valSetOne.add(InfoFromFileAll[4]);
                valSetOne.add(InfoFromFileAll[5]);
                if(InfoFromFileAll[1].equals("C")){
                    cinemaMap.put(InfoFromFileAll[0], valSetOne);
                }else if(InfoFromFileAll[1].equals("T")){
                    theaterMap.put(InfoFromFileAll[0], valSetOne);
                }
            }
        } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "It apears to be a problem with the program file.", "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public List getCinemaHalls(){
        List<String> cinemaHalls = new ArrayList<String>();
        for ( String key : cinemaMap.keySet() ) {
            cinemaHalls.add(key);
        }
        return cinemaHalls;
    }
    
    public List getTheaterHalls(){
        List<String> theaterHalls = new ArrayList<String>();
        for ( String key : theaterMap.keySet() ) {
            theaterHalls.add(key);
        }
        return theaterHalls;
    }
    
     /**
     * This method gives the description of the selected hall
     */
    public List showHall(String nameOfHall, boolean itIsCinema){
        List<String> info = new ArrayList<String>();
        if(itIsCinema){
            info = cinemaMap.get(nameOfHall);
        }else{
            info = theaterMap.get(nameOfHall);
        }
        return info;
    }
    
    public void editHalls(String nameOfHall, List info, Boolean itIsCinema){
        if(itIsCinema){
            cinemaMap.put(nameOfHall, info);
        }else{
            theaterMap.put(nameOfHall, info);
        }
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("HallsMap.txt", false)))) {
            for (Map.Entry<String, List<String>> entry : theaterMap.entrySet()) {
               String key = entry.getKey();
               List<String> values = entry.getValue();
               theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            for (Map.Entry<String, List<String>> entry : cinemaMap.entrySet()) {
               String key = entry.getKey();
               List<String> values = entry.getValue();
               theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            JOptionPane.showMessageDialog(null, "The event has successfully updated.", 
                    "User message", JOptionPane.PLAIN_MESSAGE);
        }catch (IOException e) {
                JOptionPane.showMessageDialog(null, "It apears to be a problem with the program file.", "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * this method deletes an existing event
     */
    public void deleteHall(String NameOfHall, boolean itIsCinema){
        if(itIsCinema){
            cinemaMap.remove(NameOfHall);
        }else{
            theaterMap.remove(NameOfHall);
        }
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("EventMap.txt", false)))) {
            for (Map.Entry<String, List<String>> entry : cinemaMap.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            for (Map.Entry<String, List<String>> entry : theaterMap.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            JOptionPane.showMessageDialog(null, "The event has successfully been deleted.", 
                    "User message", JOptionPane.PLAIN_MESSAGE);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "It apears to be a problem with the program files.", 
                    "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    
    /**
     * this method asks the admin for the shape of the room he wants and
     * returns true/false accordingly
     * @return 
     */
    public boolean shapeOfRoom(){
        //2 shapes orthogonia/kuklikh
        return true;
    }
    
    /**
     * this method adds seats to the hall
     */
    public void addSeats(){
        //++simple/lux theseis
    }
}

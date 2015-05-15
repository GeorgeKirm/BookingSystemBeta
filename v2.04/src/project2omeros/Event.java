
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
 * This class can be accessed by admins only
 * It can create new events or edit them.
 * @author GeorgeKirm
 * @author GT
 */
public class Event {
    Map<String, List<String>> movieMap = new HashMap<String, List<String>>();
    Map<String, List<String>> performanceMap = new HashMap<String, List<String>>();
    
    /**
     * The constructor of this class. Creates the event.
     */
    public Event() {
        movieMap = new HashMap<>();
        performanceMap = new HashMap<>();
        try (BufferedReader theFile = new BufferedReader(new FileReader("EventMap.txt"))) {
            String InfoFromFile;
            while ((InfoFromFile = theFile.readLine()) != null) {
                String[] InfoFromFileAll = InfoFromFile.split(">~~Dnt@Dlt~~<");
                List<String> valSetOne = new ArrayList<String>();
                valSetOne.add(InfoFromFileAll[1]);
                valSetOne.add(InfoFromFileAll[2]);
                valSetOne.add(InfoFromFileAll[3]);
                valSetOne.add(InfoFromFileAll[4]);
                valSetOne.add(InfoFromFileAll[5]);
                int movieOrPerformance = Integer.parseInt(InfoFromFileAll[1]);
                if(movieOrPerformance>=0){
                    movieMap.put(InfoFromFileAll[0], valSetOne);
                }else if(movieOrPerformance<0){
                    performanceMap.put(InfoFromFileAll[0], valSetOne);
                }
            }
        } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "It apears to be a problem with the program file.\n"
                         + "If the problem continue please replace\n\"EventMapErrorHelper.txt with\" "
                         + "\"EventMap.txt\".", "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public List getNamesOfMovies(){
        List<String> namesOfMovies = new ArrayList<String>();
        for ( String key : movieMap.keySet() ) {
            namesOfMovies.add(key);
        }
        return namesOfMovies;
    }
    
    public List getNamesOfPerformances(){
        List<String> namesOfPerformances = new ArrayList<String>();
        for ( String key : performanceMap.keySet() ) {
            namesOfPerformances.add(key);
        }
        return namesOfPerformances;
    }
    
    
    /**
     * This method gives the description of the selected event
     */
    public List showEvent(String nameOfEvent, boolean itIsMovie){
        List<String> info = new ArrayList<String>();
        if(itIsMovie){
            info = movieMap.get(nameOfEvent);
        }else{
            info = performanceMap.get(nameOfEvent);
        }
        return info;
    }
    
    public void editEvent(String nameOfEvent, List info, Boolean itIsMovie){
        if(itIsMovie){
            movieMap.put(nameOfEvent, info);
        }else{
            performanceMap.put(nameOfEvent, info);
        }
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("EventMap.txt", false)))) {
            for (Map.Entry<String, List<String>> entry : performanceMap.entrySet()) {
               String key = entry.getKey();
               List<String> values = entry.getValue();
               theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            for (Map.Entry<String, List<String>> entry : movieMap.entrySet()) {
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
                JOptionPane.showMessageDialog(null, "It apears to be a problem with the program file.\n"
                        + "If the problem continue please replace\n\"EventMapErrorHelper.txt with\" "
                        + "\"EventMap.txt\".", "Error message", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * this method deletes an existing event
     */
    public void deleteEvent(String NameOfEvent, boolean itIsMovie){
        if(itIsMovie){
            movieMap.remove(NameOfEvent);
        }else{
            performanceMap.remove(NameOfEvent);
        }
        try(PrintWriter theFile1 = new PrintWriter(new BufferedWriter(new FileWriter("EventMap.txt", false)))) {
            for (Map.Entry<String, List<String>> entry : movieMap.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                theFile1.println(key+">~~Dnt@Dlt~~<"+values.get(0)+
                       ">~~Dnt@Dlt~~<"+values.get(1)
                       +">~~Dnt@Dlt~~<"+values.get(2)+">~~Dnt@Dlt~~<"
                       +values.get(3)+">~~Dnt@Dlt~~<"+values.get(4));
            }
            for (Map.Entry<String, List<String>> entry : performanceMap.entrySet()) {
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
}

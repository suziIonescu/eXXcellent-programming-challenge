
package exxcellentprogrammingchallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Utilities {
    public static void readDataFromCSVFile(String csvFile, String inputType) 
                                throws FileNotFoundException, IOException {
        String cvsSplitBy = ",";
        String [] patterns;
        String line;
        DailyTemp oldEntity1 = new DailyTemp();
        oldEntity1.setMaxValue(1000);
        oldEntity1.setMinValue(0);
        oldEntity1.setSpread();
        TeamScore oldEntity2 = new TeamScore();
        oldEntity2.setMaxValue(1000);
        oldEntity2.setMinValue(0);
        oldEntity2.setSpread();
        BufferedReader in= new BufferedReader(new FileReader(csvFile));
        int count = 0;   
        while ((line = in.readLine()) != null) {
            count++;
            if(count==1) continue;
            patterns = line.split(cvsSplitBy);
            if(inputType.equals("weather")) {
                DailyTemp newEntity = new DailyTemp();
                newEntity.setDayOfMonth(Integer.parseInt(patterns[0]));
                newEntity.setMaxValue(Integer.parseInt(patterns[1]));
                newEntity.setMinValue(Integer.parseInt(patterns[2]));
                newEntity.setSpread();
                if(oldEntity1.compareTo(newEntity) > 0) {
                   oldEntity1 = newEntity; 
                }
                
            } else if (inputType.equals("football")) {
                TeamScore newEntity = new TeamScore();
                newEntity.setTeamName(patterns[0]);
                newEntity.setMaxValue(Integer.parseInt(patterns[5]));
                newEntity.setMinValue(Integer.parseInt(patterns[6]));
                newEntity.setSpread();
                if(oldEntity2.compareTo(newEntity) > 0) {
                   oldEntity2 = newEntity; 
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        if(inputType.equals("weather")) {
            System.out.println(oldEntity1);
        } else {
            System.out.println(oldEntity2);
        }
        
    }

        public static void readDataFromJsonFile(String fileName, String inputType) 
                                throws ParserConfigurationException, IOException, SAXException {
        EntityDetails entity = new EntityDetails();
//       JSONParser parser = new JSONParser();
       
//  here schoud come continue of input JSON file parsing
    }
}

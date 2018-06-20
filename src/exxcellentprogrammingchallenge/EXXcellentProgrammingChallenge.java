
package exxcellentprogrammingchallenge;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class EXXcellentProgrammingChallenge {

    public static void main(String[] args) {
        
        String workingDir = System.getProperty("user.dir");
        
        String [] csvFileList = {
                                "\\infiles\\weather.csv", 
                                "\\infiles\\football.csv"
                                };
        String fileName = null;
        String inputType = null;
        
        for (String csvFile : csvFileList) {
            fileName = csvFile.substring(csvFile.lastIndexOf("\\")+1).toLowerCase();
            inputType = getType(fileName);
            String fullPath = workingDir.concat(csvFile);
            if (getExtension(fileName).equals("csv")) {
                try {
                    Utilities.readDataFromCSVFile(fullPath,inputType);
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (getExtension(fileName).equals("json")) {
                try {
                    Utilities.readDataFromJsonFile(fullPath,inputType);
                } catch (ParserConfigurationException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SAXException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Wrong file type is supplied");
            }
        }
    }
      
    public static String getExtension(String fileName) {
        String ext = null;
        int pos = fileName.lastIndexOf('.');
        if(pos==-1) {
            ext = "nope";
        } else {
            ext = fileName.substring(pos+1).toLowerCase();
        }

        return ext;
    }
    
    public static String getType(String fileName) {
        String type = null;
        int pos = fileName.lastIndexOf('.');
        if(pos==-1) {
            type = "nope";
        } else {
            type = fileName.substring(0,pos).toLowerCase();
        }

        return type;
    }
    
}

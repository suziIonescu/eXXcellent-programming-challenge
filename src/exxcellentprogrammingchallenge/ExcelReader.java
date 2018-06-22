
package exxcellentprogrammingchallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader implements FileReader{

    private FileDescriptor fileDescriptor;
    
    public ExcelReader(FileDescriptor fDesc) {
        this.fileDescriptor = fDesc;
    }

    @Override
    public void readFile() {
        String cvsSplitBy = ",";
        String [] patterns;
        String line;
        EntityDetails entityWithMinSpread = new EntityDetails();
        EntityDetails newEntity = new EntityDetails();
        
        switch (fileDescriptor.getContentType()) {
            case WEATHER:
                DailyTemp oldEntity1 = new DailyTemp();
                oldEntity1.setMaxValue(1000);
                oldEntity1.setMinValue(0);
                oldEntity1.setSpread();
                entityWithMinSpread = oldEntity1;
                break;
            case FOOTBALL:
                TeamScore oldEntity2 = new TeamScore();
                oldEntity2.setMaxValue(1000);
                oldEntity2.setMinValue(0);
                oldEntity2.setSpread();
                entityWithMinSpread = oldEntity2;
                break;
            case NONE:
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new java.io.FileReader(fileDescriptor.getFullFilePath()));
            int count = 0;   
            while ((line = in.readLine()) != null) {
                count++;
                if(count==1) continue;
                patterns = line.split(cvsSplitBy);
                switch (fileDescriptor.getContentType()) {
                    case WEATHER:
                        DailyTemp newEntity1 = new DailyTemp();
                        newEntity1.setDayOfMonth(Integer.parseInt(patterns[0]));
                        newEntity1.setMaxValue(Integer.parseInt(patterns[1]));
                        newEntity1.setMinValue(Integer.parseInt(patterns[2]));
                        newEntity1.setSpread();
                        newEntity = newEntity1;
                        break;
                    case FOOTBALL:
                        TeamScore newEntity2 = new TeamScore();
                        newEntity2.setTeamName(patterns[0]);
                        newEntity2.setMaxValue(Integer.parseInt(patterns[5]));
                        newEntity2.setMinValue(Integer.parseInt(patterns[6]));
                        newEntity2.setSpread();
                        newEntity = newEntity2;
                        break;
                    case NONE:
                        throw new IllegalArgumentException();
                }
                if(entityWithMinSpread.compareTo(newEntity) > 0) {
                           entityWithMinSpread = newEntity; 
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR while opening the in-file : " + 
                                    fileDescriptor.getFullFilePath() + "\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR while reading from the in-file : " + 
                                    fileDescriptor.getFullFilePath() + "\n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.out.println("ERROR while closing the in-file : " + 
                                    fileDescriptor.getFullFilePath() + "\n" + ex.getMessage());
            }
        }
        System.out.println(entityWithMinSpread);
    }
}

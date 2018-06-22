
package exxcellentprogrammingchallenge;

public class EXXcellentProgrammingChallenge {

    public static void main(String[] args) {
        
        String [] csvFileList = {
                                "\\infiles\\weather.csv", 
                                "\\infiles\\football.csv"
                                };
        
        for (String csvFile : csvFileList) {
            FileDescriptor fileDesc = new FileDescriptor(csvFile);
            switch (fileDesc.getFileType()) {
                case CSV:
                    new Context(new ExcelReader(fileDesc)).executeRead();
                    break;
                case JSON:
                    new Context(new JSONReader(fileDesc)).executeRead();
                    break;
                case XML:
                    break;
                case NONE:
                    System.out.println("Wrong file type is supplied");
            }
        }
    }
}

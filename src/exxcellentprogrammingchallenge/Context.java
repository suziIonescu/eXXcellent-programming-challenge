
package exxcellentprogrammingchallenge;

public class Context {
    FileReader reader ;

    public Context(FileReader reader) {
        this.reader = reader;
    }

    public void executeRead(){
         reader.readFile();
     }
}

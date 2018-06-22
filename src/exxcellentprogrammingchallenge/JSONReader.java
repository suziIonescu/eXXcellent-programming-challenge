
package exxcellentprogrammingchallenge;

public class JSONReader implements FileReader{
    
    private FileDescriptor fileDescriptor;
    
    public JSONReader(FileDescriptor fDesc) {
        this.fileDescriptor = fDesc;
    }

    @Override
    public void readFile() {
    }

}

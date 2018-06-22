
package exxcellentprogrammingchallenge;

public class FileDescriptor {
    private ContentType contentType;
    private FileType fileType;
    private String fullFilePath;
    
    public FileDescriptor(String inFileName) {
        String fileName = getFileName(inFileName);
        fileName = fileName.substring(fileName.lastIndexOf("\\")+1).toUpperCase();
        this.contentType = detectContentType(fileName);
        this.fileType = detectFileType(fileName);
        this.fullFilePath = generateFullFilePath(inFileName);
    }

    private String getFileName(String inFileName) {
        return inFileName.substring(inFileName.lastIndexOf("\\")+1).toUpperCase();
    }
    
    private FileType detectFileType(String fileName) {
        FileType extantion = FileType.NONE;
        int pos = fileName.lastIndexOf('.');
        if(pos!=-1) {
            String ext = fileName.substring(pos+1).toUpperCase();
            for(FileType ft : FileType.values()){
                if( ft.toString().equals(ext)){
                   extantion = ft;
                }
            }  
        }

        return extantion;
    }
    
    private ContentType detectContentType(String fileName) {
        ContentType contType = ContentType.NONE;
        int pos = fileName.lastIndexOf('.');
        if(pos!=-1) {
            String type = fileName.substring(0,pos).toUpperCase();
            for(ContentType ct : ContentType.values()){
                if( ct.toString().equals(type)){
                   contType = ct;
                }
            }  
        }

        return contType;
    }
    
    private String generateFullFilePath(String fileName) {
        String workingDir = System.getProperty("user.dir");
        return workingDir.concat(fileName);
    }

    public ContentType getContentType() {
        return contentType;
    }

    public FileType getFileType() {
        return fileType;
    }

    public String getFullFilePath() {
        return fullFilePath;
    }
    
}

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private final ArrayList<String> newFileNames=new ArrayList<>();

    public void parseCsvFile(File csv) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(csv.getAbsoluteFile()));
        String current = reader.readLine();

        while (current != null) {
            newFileNames.add(current);
            current = reader.readLine();
        }
        reader.close();
    }
    public void rename(File file, String name){
        if(file.renameTo(new File(file.getAbsolutePath()+name+".jpg"))){
            System.out.println("success");
        }
       System.out.println(file+" -> "+name);
    }

    public void renameFiles(File[] a,File csv){
        try {
            parseCsvFile(csv);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        int i=0;
        for (File f: a ) {
            try {
                rename(f, newFileNames.get(i));
            }catch (IndexOutOfBoundsException exception){
                exception.printStackTrace();
            }

            i++;
        }
    }
}

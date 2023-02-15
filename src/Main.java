import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String filePath = "src/file.txt";
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if(file.exists()){
            System.out.println("The file already exists. Do you want to overwrite it? YES/NO");
            String input = reader.readLine();
            if(input.equals("NO")){
                System.out.println("Operation terminated");
                return;
            }else{
                System.out.println("File overwritten");
            }
        }else{
            System.out.println("File created");
        }

        try(FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(currentTime.format(dateTimeFormatter));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

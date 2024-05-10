import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class email {

    private static boolean isRightFormat(String s){
    
        String emailRegexFormats = "^[a-zA-Z\\d]+@[A-Za-z]+\\.[a-zA-Z]+$";
        if(s.matches(emailRegexFormats)){
            return true;
        }
        
        return false;
    
    }
    
    public static void main(String[] args) {
    
        BufferedReader reader;
        ArrayList<String> dates = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader("test.txt"));
			String line = reader.readLine();

			while (line != null) {
				dates.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        for(int i = 0; i < dates.size(); i++){
            System.out.println(dates.get(i) + "<<"+isRightFormat(dates.get(i) ));
        }

    }

}
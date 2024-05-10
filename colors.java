import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class colors {

    private static boolean isRightFormat(String s){
    
        String emailRegexFormats = "(^rgb\\((2[0-5][0-5]|1[0-9][0-9]|[0-9]?[0-9]),\\s?(2[0-5][0-5]|1[0-9][0-9]|[0-9]?[0-9]),\\s?(2[0-5][0-5]|1[0-9][0-9]|[0-9]?[0-9])\\)$)"+
        "|(^rgb\\((100|[0-9]?[0-9])%,\\s?(100|[0-9]?[0-9])%,\\s?(100|[0-9]?[0-9])%\\)$)"+
        "|(^#[A-Fa-f\\d]{6}$)|(^#[A-Fa-f\\d]{3}$)|(^hsl\\((360|3[0-5][0-9]|(1|2)[0-9][0-9]|[0-9]?[0-9]),\\s?(100|[0-9]?[0-9])%,\\s?(100|[0-9]?[0-9])%\\)$)";
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
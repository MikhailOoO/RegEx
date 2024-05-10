import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class passwords {

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d])[a-zA-Z0-9^$%@#&*!?]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        String SpecSymbols = "^$%@#&*!?";
        int countSpecSymbs = 0;
        if (matcher.matches()) {
            for (int i = 0; i < password.length() - 1; i++) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    return false;
                }
            }
            for (int i = 0; i < password.length(); i++) {
                if (SpecSymbols.indexOf(password.charAt(i))!=-1) {
                    countSpecSymbs++;
                }
            }
            if(countSpecSymbs>1){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<String> pass = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader("test.txt"));
			String line = reader.readLine();

			while (line != null) {
				pass.add(line);
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        for(int i = 0; i < pass.size(); i++){
            System.out.println(pass.get(i) + "<<"+isValidPassword(pass.get(i)));
        }
    }
}
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class tokens {
    public static void main(String[] args) {
    
            String tokensRegex = "(sin|cos|tg|ctg|tan|cot|sinh|cosh|th|cth|tanh|coth|ln|lg|log|exp|sqrt|cbrt|abs|sign|pi|e|sqrt2|ln2|ln10|[a-zA-Z_][a-zA-Z0-9_]*|\\d+\\.\\d+|\\d+|\\+|\\-|\\*|/|\\^|\\(|\\))";
            
            BufferedReader reader;
            ArrayList<String> tokens = new ArrayList<String>();
    		try {
    			reader = new BufferedReader(new FileReader("test.txt"));
    			String line = reader.readLine();
    
    			while (line != null) {
    				tokens.add(line);
    				line = reader.readLine();
    			}
    
    			reader.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            
            
            for(int i = 0; i < tokens.size(); i++){
                Pattern p = Pattern.compile(tokensRegex);
                Matcher m = p.matcher(tokens.get(i));
                int lastMatchPos = 0;
                while (m.find()) {
                String token = m.group();
                if (token.matches("^pi|e|sqrt2|ln2|ln10$")) {
                    System.out.println(token + "\t <- is a constant");
                } else if (token.matches("\\d+\\.\\d+") || token.matches("\\d+")) {
                    System.out.println(token + "\t <- is a number");
                } else if (token.matches("^sin|cos|tg|ctg|tan|cot|sinh|cosh|th|cth|tanh|coth|ln|lg|log|exp|sqrt|cbrt|abs|sign$")) {
                    System.out.println(token + "\t <- is a function");
                } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                    System.out.println(token + "\t <- is a variable");
                } else if (token.matches("\\+|\\-|\\*|/|\\^")) {
                    System.out.println(token + "\t <- is an operator");
                } else if (token.equals("(")) {
                    System.out.println(token + "\t <- is a left parenthesis");
                } else if (token.equals(")")) {
                    System.out.println(token + "\t <- is a right parenthesis");
                }
                }
                System.out.println("______________________\n");
            }

        }
    }
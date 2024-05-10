import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class dates {


    private static int indexOfElement(String[] sM, String s){
        for(int i = 0; i < sM.length; i++){
            if(sM[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
    private static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int maxDays = getMaxDaysInMonth(month, year);

        return day <= maxDays;
    }
    private static int getMaxDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year)? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }
    private static boolean splitStringIntoNumsAndCheckIt(String s, int mode){
        Matcher mrhcr;
        String token;
        int d = 0, m = 0, y = 0;
        if(mode==0 || mode == 1 || mode == 2){
            mrhcr = Pattern.compile("[0-9]{1,4}").matcher(s);
            mrhcr.find();
            d = Integer.parseInt(mrhcr.group());
            mrhcr.find();
            m = Integer.parseInt(mrhcr.group());
            mrhcr.find();
            y = Integer.parseInt(mrhcr.group());
            return isValidDate(d,m,y);
        }
        if(mode == 3 || mode == 4 || mode == 5){
            mrhcr = Pattern.compile("[0-9]{1,4}").matcher(s);
            mrhcr.find();
            y = Integer.parseInt(mrhcr.group());
            mrhcr.find();
            m = Integer.parseInt(mrhcr.group());
            mrhcr.find();
            d = Integer.parseInt(mrhcr.group());
            return isValidDate(d,m,y);
        }
        if(mode == 6){
            String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня",
                   "июля", "августа", "сентября", "октября", "ноября", "декабря"};
            mrhcr = Pattern.compile("[0-9]{1,4}|[а-я]{3,8}").matcher(s);
            mrhcr.find();
            d = Integer.parseInt(mrhcr.group());
            mrhcr.find();
            token = mrhcr.group();
            m = indexOfElement(months, token)+1;
            mrhcr.find();
            y = Integer.parseInt(mrhcr.group());
            return isValidDate(d,m,y);
        }
        if(mode == 7){
            String[] monthsFullNames = {"January", "February", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December"};
            String[] monthsAbbreviated = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                              "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            mrhcr = Pattern.compile("[0-9]{1,4}|[A-z]{3,9}").matcher(s);
            
            mrhcr.find();
            token = mrhcr.group();
            m = indexOfElement(monthsFullNames, token)+1;
            if(m==0){
                m = indexOfElement(monthsAbbreviated, token)+1;
            }
            mrhcr.find();
            d = Integer.parseInt(mrhcr.group());
            
            mrhcr.find();
            y = Integer.parseInt(mrhcr.group());
            return isValidDate(d,m,y);
        }
        if(mode == 8){
            String[] monthsFullNames = {"January", "February", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December"};
            String[] monthsAbbreviated = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                              "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            mrhcr = Pattern.compile("[0-9]{1,4}|[A-z]{3,9}").matcher(s);
            
            mrhcr.find();
            y = Integer.parseInt(mrhcr.group());
            
            mrhcr.find();
            token = mrhcr.group();
            m = indexOfElement(monthsFullNames, token)+1;
            if(m==0){
                m = indexOfElement(monthsAbbreviated, token)+1;
            }
            mrhcr.find();
            d = Integer.parseInt(mrhcr.group());
            
            
            return isValidDate(d,m,y);
        }
        
        
        return false;
    }
    private static boolean isRightFormat(String s){
    
        String[] dateRegexFormats = {
        "^[0-3]?[0-9]\\.[01]?[0-9]\\.[0-9]{1,4}$",
        "^[0-3]?[0-9]/[01]?[0-9]/[0-9]{1,4}$",
        "^[0-3]?[0-9]-[01]?[0-9]-[0-9]{1,4}$",
        "^[0-9]{1,4}\\.[01]?[0-9]\\.[0-3]?[0-9]$", 
        "^[0-9]{1,4}/[01]?[0-9]/[0-3]?[0-9]$",
        "^[0-9]{1,4}-[01]?[0-9]-[0-3]?[0-9]$",
        "^[0-3]?[0-9]\\s(января|февраля|марта|апреля|мая|июня|июля|августа|сентября|октября|ноября|декабря)\\s[0-9]{1,4}$",
        "^(January|February|March|April|May|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s[0-3]?[0-9],\\s[0-9]{1,4}$",
        "^[0-9]{1,4},\\s(January|February|March|April|May|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s[0-3]?[0-9]$"};
        
        for(int i = 0; i < dateRegexFormats.length; i++){
            if(s.matches(dateRegexFormats[i])){
                return splitStringIntoNumsAndCheckIt(s, i);
            }
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
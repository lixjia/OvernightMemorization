
package memory.practice;

/**
 *
 * @author JiaLi
 */

import java.time.*;
import java.time.format.*;
import java.time.LocalDateTime;
import java.io.*;
import java.util.*;

public class MemoryPractice {

    
    public static void main(String[] args) {
        
        try {
            Scanner fileScnr = new Scanner(new File("save.txt"));
            String line;
            line = fileScnr.nextLine();
            String[] list = line.split("-");
            int saveDay = Integer.parseInt(list[2]);
            int saveMonth = Integer.parseInt(list[1]);
            int saveYear = Integer.parseInt(list[0]);
            
            int num;
            num = fileScnr.nextInt();
            //java.time.LocalDate[] curDate = {java.time.LocalDate.now().getMonth(),};
            
            int curMonth = java.time.LocalDate.now().getMonthValue();
            int curDay = java.time.LocalDate.now().getDayOfMonth();
            int curYear = java.time.LocalDate.now().getYear();
            
            if((saveDay == curDay) && (curMonth == saveMonth)) {
                System.out.println("Still current day, "
                        + "\nPlease wait till tomorrow");
            }
            
            else if(((saveDay) < curDay) || ((curDay < saveDay) && (curMonth > saveMonth))) {
                Scanner scnr = new Scanner(System.in);
                System.out.println("What was yesterday's number?");
                int input = scnr.nextInt();
                
                
                if(input == num) {
                    System.out.println("Well done!");
                        
                    int random = (int) (((Math.random() * 900) + 100));
                    java.time.LocalDate date = java.time.LocalDate.now();
                    
                    System.out.println("\nTODAYS DATE");
                    System.out.println(java.time.LocalDate.now());
                    System.out.println("\nTONIGHTS NUMBER");
                    System.out.println(random);
                    System.out.println();
                    try {
                        FileOutputStream exit = new FileOutputStream(("save.txt"));
                        PrintWriter write = new PrintWriter(exit);
                        write.println(date);
                        write.println(random);

                        write.close();
                        exit.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("Caught FileNotFound for outputData.txt"
                                + "\n make sure file name and paths are correct");
                    } catch (IOException e) {
                        System.out.println("Caught IOException when closign output stream"
                                + "\n try again");
                    }
                    
                }
                else if(input != num) {
                    System.out.println("please try again later.");
                }
            } else if((curMonth < saveMonth) && (curYear == saveYear)) {
                System.out.println("Theres an error in the saved or current Month");
                System.out.println("Are you sure you're not a time traveler?");
            } else if((curDay < saveDay) && (curMonth == saveMonth) && (curYear == saveYear)) {
                System.out.println("Theres an error in the saved or current day");
                System.out.println("Are you sure you're not a time traveler?");
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("File not found, try agian.");
        }
        
        
    }
    
}

import java.util.Scanner;

import java.util.ArrayList;

public class StudentGradeBook {
    public static void main(String... args){
        Scanner input = new Scanner(System.in);
        StudentGradeBookFunctions gradeBook = new StudentGradeBookFunctions();
        
        String gradeBookMenu = """
===================================================
STUDENT GRADE BOOK
===================================================
TO ENTER SCORES                         -> PRESS 1
TO DISPLAY SCORES                       -> PRESS 2
TO CHECK AVERAGE                        -> PRESS 3
TO CHECK HIGHEST SCORES                 -> PRESS 4
TO CHECK LOWEST SCORE                   -> PRESS 5
TO CHECK NUMBER OF STUDENT PASS (50)    -> PRESS 6
TO FIND SCORE                           -> PRESS 7
===================================================
TO EXIT                                 -> PRESS 99 
        """;
        
        int userMenuChoice = 0;
        while(userMenuChoice != 99){
            IO.println();
            IO.println(gradeBookMenu);
            String userMenuSelection = input.next();
            
            switch(userMenuSelection){
                case "1":
                    IO.println();
                    String enterScoreMenu = """
==================================
TO ENTER ONE SCORE      -> PRESS 1
TO KEEP ENTERING SCORE  -> PRESS 2
TO EXIT                 -> PRESS 0
==================================
                    """;
                    int userEnterScoreSelection = -1;
                    while(userEnterScoreSelection != 0){
                        IO.println(enterScoreMenu);
                        String userEnterScoreChoice = input.next();
                        
                        switch(userEnterScoreChoice){
                            case "1": 
                                IO.println();
                                IO.println("Enter score: ");
                                int userScore = input.nextInt();
                                gradeBook.addScore(userScore);
                                break;
                            case "2":
                                IO.println();
                                while(true){
                                    IO.print("Enter Score: ");
                                    IO.println();
                                    IO.println("To exit Enter -1");
                                    int scoreEntry = input.nextInt();
                                    if(scoreEntry == -1){
                                        break;
                                    }
                                    gradeBook.addScore(scoreEntry);
                                }
                                break;
                            case "0":
                                userEnterScoreSelection = 0;
                                break;
                            default:
                                IO.println("Invalid Input");
                                break;
                        }
                    }
                case "2":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        ArrayList <Integer> scoresEntered = gradeBook.checkScores();
                        IO.println("=====================================");
                        for(int index = 0; index < scoresEntered.size(); index++){
                            IO.println("Score " + (index + 1) + " -> " + scoresEntered.get(index));
                        }
                        IO.println("=====================================");
                    }
                    break;
                case "3":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        IO.println("The Average -> " + gradeBook.getAverage());
                    }                    
                    break;
                case "4":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        IO.println("The Highest Score -> " + gradeBook.getHighestScore());
                    }                    
                    break;
                case "5":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        IO.println("The Lowest Score -> " + gradeBook.getLowestScore());
                    }                    
                    break;
                case "6":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        IO.println("PASS MARK = 50 ");
                        IO.println("The Number Of Student that Passed -> " + gradeBook.scoresAboveAverage());
                    }
                    break;
                case "7":
                    if(gradeBook.isScoreArrayEmpty()){
                        IO.println();
                        IO.println("No Scores Aded Yet.");
                    }else{
                        IO.println();
                        IO.println("Locate Score");
                        IO.println("Enter Score Position: ");
                        int userSearch = input.nextInt();
                        IO.println("The score is at spot" + userSearch + " -> "+ gradeBook.locateScore(userSearch));
                    }
                    break;
                case "99":
                    userMenuChoice = 99;
                    break;
                default:
                    IO.println();
                    IO.println("Invalid Input");
                    break;
            } 
        }
    }   
}

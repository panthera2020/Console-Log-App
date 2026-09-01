import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentGradeBookFunctions {
    private StudentGradeBookFunctions gradeBook;

    @BeforeEach
    void createObject(){
        gradeBook = new StudentGradeBookFunctions();
    }
    
    @Test
    void testThatWhenCheckScoreArrayItIsEmpty(){
        ArrayList <Integer> scores = gradeBook.checkScores();
        assertEquals(0,scores.size());
    }
    
    @Test
    void testThatWhenIAddScoreItIsAddedToTheArray(){
        //Given
        int score = 50;
        
        //When
        gradeBook.addScore(score);
        ArrayList <Integer> scores = gradeBook.checkScores();
        
        //Check
        assertEquals(1,scores.size());        
    }
    
    @Test
    void testThatWhenIAddANegativeNumberItDoesNotAddToTheScores(){
        //Given
        int score = -1;
        
        //When
        gradeBook.addScore(score);
        ArrayList <Integer> scores = gradeBook.checkScores();
        
        //Check
        assertEquals(0,scores.size()); 
    }
    
    @Test
    void testThatWhenIAddAScoreGreaterThanHunderdItDoNotAddToArray(){
        //Given
        int score = 200;
        
        //When
        gradeBook.addScore(score);
        ArrayList <Integer> scores = gradeBook.checkScores();
        
        //Check
        assertEquals(0,scores.size());
    }
    
    @Test
    void testThatWhenICheckScoreItIsSortedAndArranged(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 55;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        
        ArrayList<Integer> actualScores = gradeBook.checkScores();
        ArrayList<Integer> expectedScores = new ArrayList<>();
        expectedScores.add(20);
        expectedScores.add(55);
        expectedScores.add(90);
        
        //Check
        assertEquals(expectedScores, actualScores);
    }
    
    @Test
    void testThatWhenICheckForTheHighestScoreIGetTheHighestScore(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 55;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        
        int actualHighestScore = gradeBook.getHighestScore();
        int expectedHighestScore = 90;
        
        //Check
        assertEquals(expectedHighestScore, actualHighestScore);
    }
    
    @Test
    void testThatWhenICheckForLowestScoreIGetTheLowestScore(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 55;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        
        int actualLowestScore = gradeBook.getLowestScore();
        int expectedLowestScore = 20;
        
        //Check
        assertEquals(expectedLowestScore, actualLowestScore);
    }
    
    @Test
    void testThatWHenTheScoreArrayIsEmptyItReturnsTrueWhenNoScoreHasBeenAdded(){
        boolean actualAnswer = gradeBook.isScoreArrayEmpty();
        boolean expectedAnswer = true;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer);
    }
    
    @Test
    void testThatWhenIAskForAverageIGetTheAverageOfAllTheScores(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 40;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        
        int actualAverage = gradeBook.getAverage();
        int expectedAverage = 50;
        
        //Check
        assertEquals(expectedAverage,actualAverage);
        
    }
    
    @Test
    void testThatWhenIAsForScoresAboveFiftyItReturnsTheNumberOfScoresAboveFifty(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 40;
        int fourthScore = 55;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        gradeBook.addScore(fourthScore);
        
        int actualAnswer = gradeBook.scoresAboveAverage();
        int expectedAnswer = 2;
        
        //Check
        assertEquals(expectedAnswer,actualAnswer);
    }
    
    @Test
    void testThatWhenIRequestForAScoreAtCertainIndexItGivesMeTheScoreAtThatIndex(){
        //Given
        int firstScore = 20;
        int secondScore = 90;
        int thirdScore = 40;
        int fourthScore = 55;
        
        int scorePostion = 3;
        
        //When
        gradeBook.addScore(firstScore);
        gradeBook.addScore(secondScore);
        gradeBook.addScore(thirdScore);
        gradeBook.addScore(fourthScore);
        
        int actualAnswer = gradeBook.locateScore(scorePostion);
        int expectedAnswer = 55;
        
        //Check
        assertEquals(expectedAnswer, actualAnswer);
    }
}















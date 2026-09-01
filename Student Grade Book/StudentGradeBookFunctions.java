import java.util.ArrayList;

public class StudentGradeBookFunctions {
    private ArrayList<Integer> scores = new ArrayList<>();
    
    public  ArrayList<Integer> checkScores(){
        arrangeScores();
        return scores;
    }
    
    public void addScore(int score){
        if(score >= 0 && score <= 100){
            scores.add(score);
        }
    }
    
    public void arrangeScores(){
        int store = 0;
        for(int index = 0; index < scores.size(); index++){
            for(int count = 0; count < scores.size(); count++){
                if(scores.get(index) < scores.get(count)){
                    store = scores.get(index);
                    scores.set(index, scores.get(count));
                    scores.set(count, store);
                }
            }
        }
    }
    
    public boolean isScoreArrayEmpty(){
        boolean isEmpty = false;
        if(scores.size() == 0){
            isEmpty = true;
        }
        return isEmpty;
    }
    
    public int getHighestScore(){
        arrangeScores();
        int highestScore = scores.get((scores.size() - 1));
        return highestScore;
    }
    
    public int getLowestScore(){
        arrangeScores();
        int lowestScore = scores.get(0);
        return lowestScore;
    }
    
    public int getAverage(){
        int sum = 0;
        for(int index = 0; index < scores.size(); index++){
            sum += scores.get(index);
        }
        
        int average = sum / scores.size();
        
        return average;
    }
    
    public int scoresAboveAverage(){
        int counter = 0;
        for(int index = 0; index < scores.size(); index++){
            if(scores.get(index) >= 50){
                counter++;
            }
        }
        return counter;
    }
    
    public int locateScore(int scorePostion){
        arrangeScores();
        int scoreFound = scores.get(scorePostion - 1);
        return scoreFound;
    }
}






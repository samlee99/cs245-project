/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs245.project;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author amnipp
 */
public class HangMan implements Runnable{
    private final String[] WORD_LIST = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private boolean running;
    private String selectedWord;
    private char selectedChar;
    private int attempt;
    private int score = 100;
    private Thread t;
    private String threadName = "hangman";
    HighScoreScreen hs = new HighScoreScreen();
    private PlayScreen ps;
    private int badGuess = 1;
    
    private void initGame(){
        running = true;
        score = 100;
        selectedChar = ' ';
        //Select a word
        int randIndex = new Random().nextInt(WORD_LIST.length);
        selectedWord = WORD_LIST[randIndex];
    }
    
    public void setPlayScreen(PlayScreen ps){
        this.ps = ps;
    }
    
    private void gameLoop() throws InterruptedException {
        while(running){
            while(selectedChar == ' ' && running == true){
                Thread.sleep(100);
            }            
            if(checkCharacter(selectedChar)) {
                System.out.println("Found " + selectedChar);
                selectedChar = ' ';
            }else{
                System.err.println("Did not find " + selectedChar);
                ps.hideKey(selectedChar);
                selectedChar = ' ';
                badGuess += 1;
                changeImage(badGuess);
                changeScore();
            }
        }
    }
    
    public void changeScore()
    {
        score -= 10;
        ps.gameScore.setText("Score: " + score);
    }
    
    public void  changeImage(int badGuess)
    {
        String imageName = "/cs245/project/trooper_images/trooper" + badGuess + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imageName));
        ps.Image.setIcon(icon);
    }
    
    public void loadEndPage()
    {
        hs.setVisible(true);
        hs.setPlayerScore(score);
        hs.Back.setVisible(false);
        hs.End.setVisible(true);
        hs.Player_Score.setVisible(true);
        hs.Player_Score.setText("Your Score: " + score);
    }
    public void selectCharacter(char letter){
        selectedChar = letter;
    }
     
    public void exitGame(){
        running = false;
    }
    
    private boolean checkCharacter(char letter){
        return selectedWord.toLowerCase().indexOf(Character.toLowerCase(letter)) > -1;
    }
    
    public String getSelectedWord(){
        return selectedWord;
    }
    
    public int getScore(){
        return score;
    }

    @Override
    public void run() {
        try{
            initGame();
            gameLoop();
        }catch(InterruptedException e){
            System.out.println("Interrupted Thread!");
        }
    }
    
    public void start() {
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

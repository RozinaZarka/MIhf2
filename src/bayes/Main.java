package bayes;
import java.util.*;
import java.util.Scanner;

public class Main {
    private static int n = 80000;
    private static int m = 20000;
    private static ArrayList<storedSentence> trainingData = new ArrayList<>(n);
    private static ArrayList<VocabElement> vocabulary= new ArrayList<>(13054);
    private static  ArrayList<String> wordsInVocab = new ArrayList<>(13504);
    private static ArrayList <storedSentence> testingData = new ArrayList<>(m);

    public static void main(String[] args){
        readInput();
        makeVocab(trainingData,vocabulary,wordsInVocab);
        bayesAlgorithm(vocabulary, testingData);

    }

    /**
     * Reading the input, and storing the lines.
     */
    private static void readInput(){

        Scanner s = new Scanner(System.in);
        String str1 ;

        for(int i = 0;i<n;i++){
            storedSentence sen = new storedSentence();
            str1 =  s.nextLine();
            sen.base_sentence = str1;
            trainingData.add(sen);
        }

        for(int i = 0;i<n;i++){
            str1 =  s.nextLine();
            storedSentence j = trainingData.get(i);
            j.sentiment = Integer.parseInt(str1);

        }

        for(int i = 0;i<m;i++){
            storedSentence sen = new storedSentence();
            str1 =  s.nextLine();
            sen.base_sentence = str1;
            testingData.add(sen);
        }

        for(int i = 0;i<n;i++){
            trainingData.get(i).split_data(",");
        }
        for(int i = 0;i<m;i++){
            testingData.get(i).split_data(",");
        }

        s.close();
    }

    /**
     * creates a vocabulary out of the original dataset
     * @param trainingData the data on which the algorithm will base its guesses
     * @param vocabulary the vocab that is to be filled
     */
 private static void makeVocab (ArrayList<storedSentence> trainingData, ArrayList<VocabElement> vocabulary, ArrayList<String> wordsInVocab){

     for(int i = 0;i<n;i++) {
         for (int j = 0; j < trainingData.get(i).splitted_data.length; j++) {
             // System.out.print(trainingData.get(i).splitted_data[j]+' ');
             VocabElement temp = new VocabElement();
             temp.word = trainingData.get(i).splitted_data[j];
             //System.out.println(temp.word);
             if (trainingData.get(i).sentiment == 1) {
                 temp.positive_sentiment_count += 1;
             } else temp.negative_sentiment_count += 1;

             /** Find out if the word is already in the vocab or not.
              * If no, set the vocab element to temp.
              * If yes, set the temp element sentiment counts to the new count, and set the vocab element to the word.
              */
             int containsAt = wordsInVocab.indexOf(temp.word);

             if (containsAt >= 0) {
                 temp.negative_sentiment_count += (vocabulary.get(containsAt).negative_sentiment_count - 1);
                 temp.positive_sentiment_count += (vocabulary.get(containsAt).positive_sentiment_count - 1);
                 vocabulary.set(containsAt, temp);
                 //System.out.print("Sentiment count changed \t");
             } else {
                 wordsInVocab.add(vocabulary.size(), temp.word);
                 vocabulary.add(vocabulary.size(),temp);
                 // System.out.print("new item,");
             }
         }
           System.out.println("Stored sentence added to vocab "+i);
     }
 }

    /**
     * Evaluates the given test data according to the Naive Bayes Algorithm
     * @param vocabulary the vocab
     * @param  testingdata data to be evaluated
     */
 private static void bayesAlgorithm (ArrayList<VocabElement> vocabulary,ArrayList<storedSentence> testingdata){

 }

}

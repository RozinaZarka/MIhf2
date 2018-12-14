package bayes;
import java.util.*;
import java.util.Scanner;

public class Main {
    private static int n = 80000;
    private static int m = 20000;
    private static HashMap<String,VocabElement> vocabulary = new HashMap<>();
    private static ArrayList<storedSentence> trainingData = new ArrayList<>(n);
    private static ArrayList <storedSentence> testingData = new ArrayList<>(m);
    private static int allPositive = 0;
    private static int allNegative = 0;

    public static void main(String[] args){
        readInput();
        makeVocab(trainingData,vocabulary);
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
 private static void makeVocab (ArrayList<storedSentence> trainingData, HashMap<String,VocabElement> vocabulary){

     for(int i = 0;i<n;i++) {
         for (int j = 0; j < trainingData.get(i).splitted_data.length; j++) {

             String  temp =  trainingData.get(i).splitted_data[j];;
             int sentiment = trainingData.get(i).sentiment;

             /** Find out if the word is already in the vocab or not.
              * If no, set the vocab element to temp.
              * If yes, set the temp element sentiment counts to the new count, and set the vocab element to the word.
              */


             if (vocabulary.containsKey(temp)) {
                 VocabElement tempvocabelement = vocabulary.get(temp);
                 if (sentiment == 1) {
                     if (tempvocabelement.negative_sentiment_count > tempvocabelement.positive_sentiment_count) {
                         allNegative--;
                         allPositive++;
                         tempvocabelement.positive_sentiment_count++;
                     }

                 } else {

                     if (tempvocabelement.positive_sentiment_count > tempvocabelement.negative_sentiment_count) {
                         allNegative++;
                         allPositive--;
                         tempvocabelement.negative_sentiment_count++;
                     }

                 }
                 vocabulary.replace(temp,tempvocabelement);

             } else {
                 VocabElement tempvocabelement = new VocabElement();
                 if (sentiment == 1) {
                         allPositive++;
                         tempvocabelement.positive_sentiment_count++;

                 } else {
                     allNegative++;
                     tempvocabelement.negative_sentiment_count++;
                 }
                 vocabulary.put(temp,tempvocabelement);

             }
         }
     }

 }


    /**
     * Evaluates the given test data according to the Naive Bayes Algorithm
     * @param vocabulary the vocab
     * @param  testingdata data to be evaluated
     */
 private static void bayesAlgorithm (HashMap<String,VocabElement> vocabulary,ArrayList<storedSentence> testingdata){

     for ( int i = 0; i<m; i++ ){


         for ( int j = 0; j<testingdata.get(i).splitted_data.length; j++) {

             String word = testingdata.get(i).splitted_data[j];

             if ( vocabulary.containsKey(word)) {




             } else {

             }


         }


     }
 }

}

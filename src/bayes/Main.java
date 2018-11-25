package bayes;
import java.util.*;
import java.util.Scanner;

public class Main {
    static int n = 80000;
    static int m = 20000;
    static ArrayList<storedSentence> trainigdata = new ArrayList<storedSentence>();
    static ArrayList<VocabElement> vocabulary= new ArrayList<VocabElement>();
    static  ArrayList<String> wordsInVocab = new ArrayList<String>();
    static ArrayList <storedSentence> testingdata = new ArrayList<storedSentence>();

    public static void main(String[] args){
        readInput();
        makeVocab(trainigdata,vocabulary,wordsInVocab);
     //   bayesAlgorithm(vocabulary);

         /*
        for(int i = 0;i<n;i++){
            for(int b = 0;b < trainigdata.get(i).splitted_data.length;b++){
                System.out.print(trainigdata.get(i).splitted_data[b]+' ');
            }
            System.out.print('\n');
        }
        */

    }

    // reading the input, and making a file of the lines
    public static void readInput(){

        Scanner s = new Scanner(System.in);
        String str1 ;

        for(int i = 0;i<n;i++){
            storedSentence sen = new storedSentence();
            str1 =  s.nextLine();
            sen.base_sentence = str1;
            trainigdata.add(sen);
        }

        for(int i = 0;i<n;i++){
            str1 =  s.nextLine();
            storedSentence j = trainigdata.get(i);
            j.sentiment = Integer.parseInt(str1);

        }

        for(int i = 0;i<m;i++){
            storedSentence sen = new storedSentence();
            str1 =  s.nextLine();
            sen.base_sentence = str1;
            testingdata.add(sen);
        }

        for(int i = 0;i<n;i++){
            trainigdata.get(i).split_data(",");
        }
        for(int i = 0;i<m;i++){
            testingdata.get(i).split_data(",");
        }

        s.close();
    }

    /**
     * creates a vocabulary out of the original dataset
     * @param tariningdata
     * @param vocabulary
     */
 public static void makeVocab (ArrayList<storedSentence> tariningdata, ArrayList<VocabElement> vocabulary, ArrayList<String> wordsInVocab){

     for(int i = 0;i<n;i++) {
         for (int j = 0; j < tariningdata.get(i).splitted_data.length; j++) {
             // System.out.print(trainigdata.get(i).splitted_data[j]+' ');
             VocabElement temp = new VocabElement();
             temp.word = tariningdata.get(i).splitted_data[j];
             //System.out.println(temp.word);
             if (tariningdata.get(i).sentiment == 1) {
                 temp.positive_sentiment_count += 1;
             } else temp.negative_sentiment_count += 1;

             /** Find out if the word is already in the vocab or not.
              * If no, set the vocab element to temp.
              * If yes, set the temp element sentiment counts to the new count, and set the vocab element to the word.
              */
             int containsAt = wordsInVocab.indexOf(temp.word);
            /* String thisString;
             for (int k = 0; k < vocabulary.size(); k++){
                 thisString = vocabulary.get(k).word;
                 //System.out.print(thisString + " " + k +"\t");
                 if (temp.word == thisString)
                 {
                     containsAt = k;
                     i = vocabulary.size();
                 }
             } */


             if (containsAt >= 0) {
                 temp.negative_sentiment_count += (vocabulary.get(i).negative_sentiment_count - 1);
                 temp.positive_sentiment_count += (vocabulary.get(i).positive_sentiment_count - 1);
                 vocabulary.set(containsAt, temp);
               //  System.out.print("Sentiment count changed \t");
             } else {
                 wordsInVocab.add(vocabulary.size(), temp.word);
                 vocabulary.add(vocabulary.size(),temp);
                 /// System.out.print("new item,");
             }
         }
           System.out.println("Stored sentence added to vocab"+i);
     }
 }

    /**
     * Evaluates the given trainigdata according to the Naive Bayes Algorithm
     * @param vocabulary the vocab
     */
 public static void bayesAlgorithm (ArrayList<VocabElement> vocabulary){

 }
}

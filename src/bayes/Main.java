package bayes;
import java.util.*;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    static int n = 80000;
    static int m = 20000;
    static ArrayList<storedSentence> data = new ArrayList<storedSentence>();
    static ArrayList<VocabElement> vocabulary= new ArrayList<>();

    public static void main(String[] args){
        readInput();
        makeVocab(data,vocabulary);
     //   bayesAlgorithm(vocabulary);

         /*
        for(int i = 0;i<n;i++){
            for(int b = 0;b < data.get(i).splitted_data.length;b++){
                System.out.print(data.get(i).splitted_data[b]+' ');
            }
            System.out.print('\n');
        }
        */

    }

    // reading the input, and making a file of the lines
    public static void readInput(){

        Scanner s = new Scanner(System.in);
        String k ;

        for(int i = 0;i<n;i++){
            storedSentence sen = new storedSentence();
            k =  s.nextLine();
            sen.base_sentence = k;
            data.add(sen);
        }

        for(int i = 0;i<n;i++){
            k =  s.nextLine();
            storedSentence j = data.get(i);
            j.sentiment = Integer.parseInt(k);

        }
        for(int i = 0;i<n;i++){
            data.get(i).split_data(",");

        }

        for(int i = 0;i<m;i++){
            k =  s.nextLine();
            // System.out.println(k);
        }
        s.close();
    }

    /**
     * creates a vocabulary out of the original dataset
     * @param data
     * @param vocabulary
     */
 public static void makeVocab (ArrayList<storedSentence> data, ArrayList<VocabElement> vocabulary){

     for(int i = 0;i<n;i++) {
         for (int j = 0; j < data.get(i).splitted_data.length; j++) {
             // System.out.print(data.get(i).splitted_data[j]+' ');
             VocabElement temp = new VocabElement();
             temp.word = data.get(i).splitted_data[j];
             if (data.get(i).sentiment == 1) {
                 temp.positive_sentiment_count += 1;
             } else temp.negative_sentiment_count += 1;

             /** Find out if the word is already in the vocab or not.
              * If no, set the vocab element to temp.
              * If yes, set the temp element sentiment counts to the new count, and set the vocab element to the word.
              */
             if (vocabulary.contains(temp)) {
                 int vocabLine = vocabulary.indexOf(temp);
                 temp.negative_sentiment_count += (vocabulary.get(i).negative_sentiment_count - 1);
                 temp.positive_sentiment_count += (vocabulary.get(i).positive_sentiment_count - 1);
                 vocabulary.set(vocabLine, temp);
                 System.out.println("Sentiment count changed for" + temp);
             } else {
                 vocabulary.add(temp);
                 System.out.println("New item in vocab");
             }
         }
         System.out.println("Stored sentence vocabized");
     }
 }

    /**
     * Evaluates the given data according to the Naive Bayes Algorithm
     * @param vocabulary the vocab
     */
 public static void bayesAlgorithm (ArrayList<VocabElement> vocabulary){

 }
}

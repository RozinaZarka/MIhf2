package bayes;
import java.util.*;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    static int n = 80000;
    static int m = 20000;
    static ArrayList<storedSentence> data = new ArrayList<storedSentence>();

    public static void main(String[] args){
        readInput();
        //    System.out.println(data);
        for(int i = 0;i<n;i++){
            for(int b = 0;b < data.get(i).splitted_data.length;b++){
                System.out.print(data.get(i).splitted_data[b]+' ');
            }
            System.out.print('\n');
        }
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

}

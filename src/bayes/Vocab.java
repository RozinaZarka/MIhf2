package bayes;

import java.util.ArrayList;

public class Vocab{

    ArrayList<VocabElement> vocabElements = new ArrayList<>() ;

    public VocabElement find( String word){

        int i =0;
        while ( i< vocabElements.size()){
            if (vocabElements.get(i).word == word )
                return vocabElements.get(i);
            i++;
        }
        return new VocabElement();
    }

}
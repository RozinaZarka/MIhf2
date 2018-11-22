package bayes;

public class VocabElement {
    String word;
    int positive_sentiment_count;
    int negative_sentiment_count;

    public void VocabElement(String word, int positive, int negative ){
        this.word =word;
        this.positive_sentiment_count = positive;
        this.negative_sentiment_count = negative;

    }

    public void VocabElement(){
        this.word = "";
        this.positive_sentiment_count = 1;
        this.negative_sentiment_count = 1;

    }

}

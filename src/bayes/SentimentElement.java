package bayes;

public class SentimentElement {
    int positive_sentiment_count;
    int negative_sentiment_count;

    public void VocabElement(int positive, int negative ){
        this.positive_sentiment_count = positive;
        this.negative_sentiment_count = negative;

    }

    public void VocabElement(){
        this.positive_sentiment_count = 0;
        this.negative_sentiment_count = 0;

    }

}

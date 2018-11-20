package bayes;


public class storedSentence{
int sentiment;
String base_sentence;
String[] splitted_data;
void split_data(String delim){
// I am aware that spitted is not a word
    this.splitted_data = this.base_sentence.split(delim,-1);


}
}

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// idea? save the wordPosition of document is called either way?

// A Document is created from a string, which consists of multiple, space-separated words.
public class Document {
    private String text;

    // Returns the byte offsets into the document text for the start of each occurrence of the word, in increasing order.
    public Document(String text){
        this.text = text;
    }


    public List<Integer> wordPosition(String word){
        Pattern pattern = Pattern.compile("\\b"+word+"\\b");
        Matcher matcher = pattern.matcher(text);

        List<Integer> wordPositions = new ArrayList<Integer>();
         while (matcher.find()) {
             wordPositions.add(matcher.start());
         }
        return wordPositions;
    }

    public List<Integer> manualSearchWordPosition(String word) {
        String[] textSplit = text.split("\\s+");
        char firstChar = word.charAt(0);
        int totalLength = 0;
        List<Integer> wordPositions = new ArrayList<Integer>();
        for(String wordInText : textSplit){
            // Check if the first characters are the same as the word
            if(wordInText.charAt(0) == firstChar){
                // Check if the word is the same as the word
                if(wordInText.equals(word)){
                    wordPositions.add(totalLength);
                }
            }
            totalLength += wordInText.length() + 1;
        }
        return wordPositions;
    }

    public String getText() {
        return text;
    }

}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// idea? multiprocessing
// idea? regex


// A SearchEngine starts empty, but will eventually store information about many documents.
public class SearchEngine {
    private List<Document> documents;
    public SearchEngine(){
        this.documents = new ArrayList<>();
    }

    // Returns all documents containing the given query word.
    public Set<Document> query(String word){
        Set<Document> documentsWithWord = new HashSet<>();
        Pattern pattern = Pattern.compile("\\b"+word+"\\b");

        for(Document document : this.documents){
            Matcher matcher = pattern.matcher(document.getText());
            if (matcher.find()) documentsWithWord.add(document);
        }
        return documentsWithWord;
    }

    // Allows the document to be returned upon later queries about words contained in its text.
    public void add(Document document){
        this.documents.add(document);
    }
}

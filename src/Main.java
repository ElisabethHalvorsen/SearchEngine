import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;

import java.util.List;
import java.util.Random;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Document doc1 = new Document(textGenerator(50_000)); //"the quick brown fox quickly jumped");
        Document doc2 = new Document(textGenerator(1_000_000));//"the lazy brown lamb wore a brown hat");
        SearchEngine engine = new SearchEngine();
        engine.add(doc1);
        engine.add(doc2);

//      return [4]
        long startTime10k = System.nanoTime();
        String matchDoc1 = "quick";
        List<Integer> pos1 = doc1.wordPosition(matchDoc1);
        long endTime10k = System.nanoTime();
        long duration10k = (endTime10k - startTime10k) / 1_000_000;

        System.out.println("Found " + pos1.size() + " matches for the word \"" + matchDoc1 + "\"");
        System.out.println("Time taken: " + duration10k + " ms");

        // return [9,27]
        String matchDoc2 = "brown";
        long startTime20k = System.nanoTime();
        List<Integer> pos2 = doc2.wordPosition(matchDoc2);
        long endTime20k = System.nanoTime();
        long duration20k = (endTime20k - startTime20k) / 1_000_000;


        System.out.println("Found " + pos2.size() + " matches for the word \"" + matchDoc2 + "\"");
        System.out.println("Time taken: " + duration20k + " ms");

        // return doc1, doc2
        Set<Document> q1 = engine.query("brown");

        //return doc2
        Set<Document> q2 = engine.query("the");

        System.out.println(q1);
        System.out.println(q2);


    }


    private static String textGenerator(int targetWordCount){
        // List of common words to use in the text
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog", "and", "cat", "runs", "fast", "slow", "red", "blue", "green", "yellow", "big", "small", "happy", "sad"};

        // Create a Random object to pick words randomly
        Random random = new Random();


        // StringBuilder to efficiently build the large text
        StringBuilder largeText = new StringBuilder();

        // Generate the text
        for (int i = 0; i < targetWordCount; i++) {
            // Pick a random word from the list
            String word = words[random.nextInt(words.length)];
            largeText.append(word).append(" ");

            // Add a period and space every ~20 words to simulate sentences
            if (i % 20 == 0 && i != 0) {
                largeText.append(". ");
            }
        }

        // Convert to a final string
        String text = largeText.toString();

        // Print the length of the generated text (for verification)
        System.out.println("Generated text length: " + text.length() + " characters");
        return  text;
    }
}
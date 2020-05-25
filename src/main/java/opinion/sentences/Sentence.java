package opinion.sentences;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private final List<Word> words;

    public Sentence(String strSentence) {
        words = new ArrayList();
        final SentenceParser sentenceParser = new SentenceParser(strSentence);
        while (sentenceParser.hasNext()) {
            addWord(sentenceParser.next());
        }
    }

    List<Word> getWords() {
        return words;
    }

    private void addWord(String strWord) {

    }
}
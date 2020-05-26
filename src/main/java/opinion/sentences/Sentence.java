package opinion.sentences;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private final List<Word> mWords;

    public Sentence(String strSentence) {
        mWords = new ArrayList();
        final SentenceParser sentenceParser = new SentenceParser(strSentence);
        while (sentenceParser.hasNext()) {
            addWord(sentenceParser.next());
        }
    }

    public List<Word> getWords() {
        return mWords;
    }

    private void addWord(String strWord) {
        mWords.add(new Word(strWord));
    }
}
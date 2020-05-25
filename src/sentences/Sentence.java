package src.sentences;

public class Sentence {

    private final List<Word> words;

    public Sentence(String strSentence) {
        words = new ArrayList<>();
        final SentenceParser sentenceParser = new SentenceParser(strSentence);
        while (sentenceParser.hasNext()) {
            words.add(sentenceParser.next());
        }
    }

    List<Word> getWords() {
        return words;
    }
}
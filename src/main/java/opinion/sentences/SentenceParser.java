package opinion.sentences;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

/**
 * Implements Iterator interface to iterate over words in a sentence
 */
class SentenceParser implements Iterator<String> {

    private String[] mWords; // array of each word in sentence
    private int mWordIndex; // index of current word in mWords array

    /**
     * Initializes member variables
     * @param strSentence sentence to be parsed
     */
    public SentenceParser(String strSentence) {
        // places all words in sentence into an array by splitting sentence on any non-word character
        mWords = strSentence.trim().split("\\W+"); // need to trim whitespace first
        mWordIndex = 0;
    }

    @Nullable
    @Override
    /**
     * returns next word in sentence, null if there is no next word
     */
    public String next() {
        if (!hasNext()) {
            return null;
        }

        return mWords[mWordIndex++]; // get next word in sentence
    }

    @Override
    /**
     * returns true if there are still words left in sentence to be processed
     */
    public boolean hasNext() {
        return mWordIndex < mWords.length;
    }
}
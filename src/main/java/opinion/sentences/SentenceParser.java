package opinion.sentences;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

class SentenceParser implements Iterator<String> {

    private String[] mWords;
    private int mWordIndex;


    public SentenceParser(String strSentence) {
        mWords = strSentence.split("\\s+");
        mWordIndex = 0;
        for (int i = 0; i < mWords.length; i++) {
            // TODO(anna): improve this when it breaks
            mWords[i] = mWords[i].replaceAll("[^\\w]", "");
        }
    }

    @Nullable
    @Override
    public String next() {
        if (!hasNext()) {
            return null;
        }

        return mWords[mWordIndex++];
    }

    @Override
    public boolean hasNext() {
        return mWordIndex < mWords.length;
    }
}
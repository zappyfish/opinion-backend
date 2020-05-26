package opinion.sentences;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SentenceParserTest {

    @Test
    public void testHasNext() {
        SentenceParser sp = new SentenceParser("hello my name is anna. ");
        final int numExpectedWords = 5;
        for (int i = 0; i < numExpectedWords; i++) {
            Assert.assertTrue(sp.hasNext());
            sp.next();
        }
        Assert.assertFalse(sp.hasNext());
    }

    @Test
    public void testNext() {
        SentenceParser sp = new SentenceParser(" hello . my name. is anna. ");
        String[] expectedWords = {"hello", "my", "name", "is", "anna"};
        for (int i = 0; i < expectedWords.length; i++) {
            Assert.assertEquals(expectedWords[i], sp.next());
        }

        Assert.assertNull(sp.next());
    }

}
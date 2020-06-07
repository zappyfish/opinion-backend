package opinion.evaluators;

import opinion.evaluators.impls.ContainsShouldEvaluator;
import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;

public class ContainsShouldEvaluatorTest {

    @Test
    public void testGetEvaluatorExplanation() {
        ContainsShouldEvaluator shouldEvaluator = new ContainsShouldEvaluator();
        Assert.assertEquals(shouldEvaluator.getEvaluatorExplanation(), "this evaluator says that a sentence is opinionated if it contains the word \"should\"");
    }

    @Test
    public void testGetEvaluatorType() {
        ContainsShouldEvaluator shouldEvaluator = new ContainsShouldEvaluator();
        Assert.assertEquals(shouldEvaluator.getEvaluatorType(), EvaluatorResult.EvaluatorType.OPINION);
    }

    @Test
    public void testEvaluatorApplies() {
        ContainsShouldEvaluator shouldEvaluator = new ContainsShouldEvaluator();

        Sentence mTestSentence1 = new Sentence("We should do this.");
        Sentence mTestSentence2 = new Sentence("They shouldn't go to the park today.");
        Sentence mTestSentence3 = new Sentence("He should've played for Chelsea instead.");
        Sentence mTestSentence4 = new Sentence("Should.");
        Sentence mTestSentence5 = new Sentence("I like grapes.");
        Sentence mTestSentence6 = new Sentence("Seltzer is my favorite drink.");

        Assert.assertTrue(shouldEvaluator.evaluatorApplies(mTestSentence1));
        Assert.assertTrue(shouldEvaluator.evaluatorApplies(mTestSentence2));
        Assert.assertTrue(shouldEvaluator.evaluatorApplies(mTestSentence3));
        Assert.assertTrue(shouldEvaluator.evaluatorApplies(mTestSentence4));

        Assert.assertFalse(shouldEvaluator.evaluatorApplies(mTestSentence5));
        Assert.assertFalse(shouldEvaluator.evaluatorApplies(mTestSentence6));
    }

}
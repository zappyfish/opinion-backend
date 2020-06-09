package opinion.evaluators;

import opinion.evaluators.impls.ContainsShouldEvaluator;
import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;

public class ContainsShouldEvaluatorTest {

    @Test
    public void testGetEvaluatorDescription() {
        ContainsShouldEvaluator shouldEvaluator = new ContainsShouldEvaluator();
        Assert.assertEquals(shouldEvaluator.getEvaluatorDescription(), "this evaluator says that a sentence is an OPINION if it contains the word \"should\"");
    }

    @Test
    public void testGetEvaluation(){
        ContainsShouldEvaluator shouldEvaluator = new ContainsShouldEvaluator();

        Sentence mTestSentence1 = new Sentence("We should do this.");
        Sentence mTestSentence2 = new Sentence("They shouldn't go to the park today.");
        Sentence mTestSentence3 = new Sentence("He should've played for Chelsea instead.");
        Sentence mTestSentence4 = new Sentence("Should.");
        Sentence mTestSentence5 = new Sentence("I like grapes.");
        Sentence mTestSentence6 = new Sentence("Seltzer is my favorite drink.");

        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence1), EvaluatorResult.Evaluation.OPINION);
        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence2), EvaluatorResult.Evaluation.OPINION);
        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence3), EvaluatorResult.Evaluation.OPINION);
        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence4), EvaluatorResult.Evaluation.OPINION);
        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence5), EvaluatorResult.Evaluation.NO_RESULT);
        Assert.assertEquals(shouldEvaluator.getEvaluation(mTestSentence6), EvaluatorResult.Evaluation.NO_RESULT);


    }

}
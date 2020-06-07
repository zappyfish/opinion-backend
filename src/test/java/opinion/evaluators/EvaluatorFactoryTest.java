package opinion.evaluators;

import opinion.evaluators.SentenceEvaluator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class EvaluatorFactoryTest {

    @Test
    public void testGetEvaluator() {
        String testEvaluatorName = "for_test";
        SentenceEvaluator evaluator = EvaluatorFactory.getEvaluator(testEvaluatorName);
        Assert.assertEquals(evaluator.getEvaluatorExplanation(), "this evaluator says that a sentence is factual if it contains the word \"fact\"");
    }

    @Test
    public void testAllEvaluatorsAddedCorrectly() {
        Set<Class<? extends SentenceEvaluator>> evaluatorTypes = null;
        try {
            evaluatorTypes = EvaluatorFactory.getEvaluatorTypes();
        } catch (ClassNotFoundException e) {
            Assert.fail(); // If this happens, you probably added your new evaluator to the factory incorrectly
        }
        for (String evaluatorName : EvaluatorFactory.sEvaluatorNames) {
            SentenceEvaluator evaluator = EvaluatorFactory.getEvaluator(evaluatorName);
            Assert.assertTrue(evaluatorTypes.contains(evaluator.getClass()));
            evaluatorTypes.remove(evaluator.getClass());
        }
        // We should have seen every evaluator type
        Assert.assertTrue(evaluatorTypes.isEmpty());
    }
}
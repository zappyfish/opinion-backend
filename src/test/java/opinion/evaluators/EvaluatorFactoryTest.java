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
        Assert.assertEquals(evaluator.getEvaluatorDescription(),
                "this evaluator says that a sentence is a FACT if it contains the word \"fact\"");
    }

    @Test
    public void testAllEvaluatorsAddedCorrectly() {
        Set<Class<? extends SentenceEvaluator>> evaluatorNames = null;
        try {
            evaluatorNames = EvaluatorFactory.getEvaluatorNames();
        } catch (ClassNotFoundException e) {
            Assert.fail(); // If this happens, you probably added your new evaluator to the factory incorrectly
        }
        for (String evaluatorName : EvaluatorFactory.sEvaluatorNames) {
            SentenceEvaluator evaluator = EvaluatorFactory.getEvaluator(evaluatorName);
            Assert.assertTrue(evaluatorNames.contains(evaluator.getClass()));
            evaluatorNames.remove(evaluator.getClass());
        }
        // We should have seen every evaluator name
        Assert.assertTrue(evaluatorNames.isEmpty());
    }
}
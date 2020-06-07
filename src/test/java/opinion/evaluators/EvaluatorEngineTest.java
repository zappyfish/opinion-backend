package opinion.evaluators;

import opinion.evaluators.EvaluatorResult;
import opinion.evaluators.EvaluatorEngine;
import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class EvaluatorEngineTest {

    private List<String> getTestEvaluatorList() {
        List<String> list = new LinkedList<>();
        list.add("for_test");
        return list;
    }

    @Test
    public void testApplyEvaluators() {
        EvaluatorEngine evaluatorEngine = new EvaluatorEngine(getTestEvaluatorList());
        Sentence sentence1 = new Sentence("this sentence contains the word fact");
        List<EvaluatorResult> evaluationResults1 = evaluatorEngine.applyEvaluators(sentence1);
        Assert.assertEquals(evaluationResults1.size(), 1);

        // The sentence contained "fact", so the evaluator should apply
        Assert.assertTrue(evaluationResults1.get(0).getEvaluatorApplies());

        Sentence sentence2 = new Sentence("this sentence does not contain that word");
        List<EvaluatorResult> evaluationResults2 = evaluatorEngine.applyEvaluators(sentence2);
        Assert.assertEquals(evaluationResults2.size(), 1);

        // The sentence did not contain "fact", so the evaluator should not apply
        Assert.assertFalse(evaluationResults2.get(0).getEvaluatorApplies());
    }
}
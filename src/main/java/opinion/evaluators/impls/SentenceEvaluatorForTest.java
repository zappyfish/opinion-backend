package opinion.evaluators.impls;

import opinion.evaluators.SentenceEvaluator;
import opinion.evaluators.EvaluatorResult;
import opinion.sentences.Sentence;
import opinion.sentences.Word;


/**
 * Test class implementing the SentenceEvaluator interface, used for testing other classes.
 */
public class SentenceEvaluatorForTest extends SentenceEvaluator {

    @Override
    public String getEvaluatorExplanation() {
        return "this evaluator says that a sentence is factual if it contains the word \"fact\"";
    }

    @Override
    public EvaluatorResult.EvaluatorType getEvaluatorType() {
        return EvaluatorResult.EvaluatorType.FACT;
    }

    @Override
    public boolean evaluatorApplies(Sentence sentence) {
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().equals("fact")) {
                return true;
            }
        }
        return false;
    }

}

package opinion.evaluators.impls;

import opinion.evaluators.EvaluatorResult;
import opinion.evaluators.SentenceEvaluator;
import opinion.sentences.Sentence;
import opinion.sentences.Word;


/**
 * Should evaluator -- if a sentence contains the word "should", it is an opinion
 */
public class ContainsShouldEvaluator extends SentenceEvaluator {

    @Override
    public String getEvaluatorExplanation() {
        return "this evaluator says that a sentence is opinionated if it contains the word \"should\"";
    }

    @Override
    public EvaluatorResult.EvaluatorType getEvaluatorType() {
        return EvaluatorResult.EvaluatorType.OPINION;
    }

    @Override
    public boolean evaluatorApplies(Sentence sentence) {
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().contains("should")) { // will also cover shouldn't
                return true;
            }
        }
        return false;
    }

}

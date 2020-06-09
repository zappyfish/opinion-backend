package opinion.evaluators;

import opinion.sentences.Sentence;

import java.util.LinkedList;
import java.util.List;

/**
 * An EvaluatorEngine contains a set of evaluators (i.e., rules) for determining whether a sentence is opinion or fact.
 * It will apply each evaluator and return their individual determinations.
 * However, the aggregate conclusion is not performed by the EvaluatorEngine.
 */
public class EvaluatorEngine {

    private List<SentenceEvaluator> mSentenceEvaluators;

    /**
     * Instantiate an EvaluatorEngine that will apply the evaluators described by evaluatorList
     */
    public EvaluatorEngine(List<String> evaluatorList) {
        mSentenceEvaluators = new LinkedList<SentenceEvaluator>();
        for (String evaluator : evaluatorList) {
            mSentenceEvaluators.add(EvaluatorFactory.getEvaluator(evaluator));
        }
    }

    /**
     * Apply each evaluator to a sentence
     * @param sentence - the Sentence to analyze
     * @return - the result of applying every evaluator contained in the evaluator engine
     */
    public List<EvaluatorResult> applyEvaluators(Sentence sentence) {
        List<EvaluatorResult> evaluationResults = new LinkedList<EvaluatorResult>();
        for (SentenceEvaluator sentenceEvaluator : mSentenceEvaluators) {
            evaluationResults.add(sentenceEvaluator.applyEvaluator(sentence));
        }
        return evaluationResults;
    }

}

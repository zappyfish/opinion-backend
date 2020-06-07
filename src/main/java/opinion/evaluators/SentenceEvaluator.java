package opinion.evaluators;

import opinion.sentences.Sentence;

public abstract class SentenceEvaluator {

    /**
     *
     * @return the result of applying this evaluator to a sentence
     */
    EvaluatorResult applyEvaluator(Sentence sentence) {
        return new EvaluatorResult.Builder()
                .setEvaluatorApplies(evaluatorApplies(sentence))
                .setEvaluatorDescription(getEvaluatorExplanation())
                .setEvaluatorType(getEvaluatorType())
                .build();
    }

    protected abstract String getEvaluatorExplanation();

    public abstract EvaluatorResult.EvaluatorType getEvaluatorType();

    public abstract boolean evaluatorApplies(Sentence sentence);
}
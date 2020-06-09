package opinion.evaluators;

import opinion.sentences.Sentence;

public abstract class SentenceEvaluator {

    /**
     *
     * @return the result of applying this evaluator to a sentence
     */
    EvaluatorResult applyEvaluator(Sentence sentence) {
        return new EvaluatorResult.Builder()
                .setEvaluatorDescription(getEvaluatorDescription())
                .setEvaluation(getEvaluation(sentence))
                .build();
    }

    protected abstract String getEvaluatorDescription();

    public abstract EvaluatorResult.Evaluation getEvaluation(Sentence sentence);
}
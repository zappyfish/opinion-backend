package opinion.evaluators;

/**
 * An EvaluatorResult contains the output of applying a single evaluator on a sentence.
 * There are three possible evaluations: opinion, fact, or no result.
 */
public class EvaluatorResult {

    public enum Evaluation {
        OPINION,
        FACT,
        NO_RESULT
    }

    private final Evaluation mEvaluation;
    private final String mEvaluatorDescription;

    private EvaluatorResult(Evaluation evaluation, String evaluatorDescription) {
        mEvaluation = evaluation;
        mEvaluatorDescription = evaluatorDescription;
    }

    public Evaluation getEvaluation() {
        return mEvaluation;
    }

    public String getEvaluatorDescription() {
        return mEvaluatorDescription;
    }

    public static class Builder {

        private String evaluatorDescription;
        private Evaluation evaluation;

        public Builder() {
        }

        public Builder setEvaluation(Evaluation evaluation) {
            this.evaluation = evaluation;
            return this;
        }

        public Builder setEvaluatorDescription(String evaluatorDescription) {
            this.evaluatorDescription = evaluatorDescription;
            return this;
        }


        public EvaluatorResult build() {
            return new EvaluatorResult(this.evaluation, this.evaluatorDescription);
        }
    }
}
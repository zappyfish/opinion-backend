package opinion.evaluators;

public class EvaluatorResult {
    public enum EvaluatorType {
        OPINION,
        FACT
    }

    private final EvaluatorType mEvaluatorType;
    private final String mEvaluatorDescription;
    private final boolean mEvaluatorApplies;

    private EvaluatorResult(EvaluatorType EvaluatorType, String EvaluatorDescription, boolean EvaluatorApplies) {
        mEvaluatorType = EvaluatorType;
        mEvaluatorDescription = EvaluatorDescription;
        mEvaluatorApplies = EvaluatorApplies;
    }

    public EvaluatorType getEvaluatorType() {
        return mEvaluatorType;
    }

    public String getEvaluatorDescription() {
        return mEvaluatorDescription;
    }

    public boolean getEvaluatorApplies() {
        return mEvaluatorApplies;
    }

    public static class Builder {

        private EvaluatorType evaluatorType;
        private String evaluatorDescription;
        private boolean evaluatorApplies;

        public Builder() {}

        public Builder setEvaluatorType(EvaluatorType evaluatorType) {
            this.evaluatorType = evaluatorType;
            return this;
        }

        public Builder setEvaluatorDescription(String evaluatorDescription) {
            this.evaluatorDescription = evaluatorDescription;
            return this;
        }

        public Builder setEvaluatorApplies(boolean evaluatorApplies) {
            this.evaluatorApplies = evaluatorApplies;
            return this;
        }

        public EvaluatorResult build() {
            return new EvaluatorResult(this.evaluatorType, this.evaluatorDescription, this.evaluatorApplies);
        }
    }
}
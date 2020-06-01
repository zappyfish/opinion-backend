package opinion.rules;

public class RuleResult {
    public enum RuleType {
        OPINION,
        FACT
    }

    private final RuleType mRuleType;
    private final String mRuleDescription;
    private final boolean mRuleApplies;

    private RuleResult(RuleType ruleType, String ruleDescription, boolean ruleApplies) {
        mRuleType = ruleType;
        mRuleDescription = ruleDescription;
        mRuleApplies = ruleApplies;
    }

    public RuleType getRuleType() {
        return mRuleType;
    }

    public String getRuleDescription() {
        return mRuleDescription;
    }

    public boolean getRuleApplies() {
        return mRuleApplies;
    }

    public static class Builder {

        private RuleType ruleType;
        private String ruleDescription;
        private boolean ruleApplies;

        public Builder() {}

        public Builder setRuleType(RuleType ruleType) {
            this.ruleType = ruleType;
            return this;
        }

        public Builder setRuleDescription(String ruleDescription) {
            this.ruleDescription = ruleDescription;
            return this;
        }

        public Builder setRuleApplies(boolean ruleApplies) {
            this.ruleApplies = ruleApplies;
            return this;
        }

        public RuleResult build() {
            return new RuleResult(this.ruleType, this.ruleDescription, this.ruleApplies);
        }
    }
}

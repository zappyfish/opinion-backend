package opinion.rules;

import opinion.sentences.Sentence;

public abstract class SentenceRule {

    /**
     *
     * @return the result of applying this rule to a sentence
     */
    RuleResult applyRule(Sentence sentence) {
        return new RuleResult.Builder()
                .setRuleApplies(ruleApplies(sentence))
                .setRuleDescription(getRuleExplanation())
                .setRuleType(getRuleType())
                .build();
    }

    protected abstract String getRuleExplanation();

    public abstract RuleResult.RuleType getRuleType();

    public abstract boolean ruleApplies(Sentence sentence);
}
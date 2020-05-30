package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleResultOuterClass.*;

public abstract class SentenceRule {

    /**
     *
     * @return the result of applying this rule to a sentence
     */
    RuleResult applyRule(Sentence sentence) {
        return RuleResult.newBuilder()
                .setRuleDescription(getRuleDescription())
                .setRuleApplies(ruleApplies(sentence))
                .build();
    }

    private RuleDescription getRuleDescription() {
        return RuleDescription.newBuilder()
                .setRuleType(getRuleType())
                .setRuleExplanation(getRuleExplanation())
                .build();
    }


    protected abstract String getRuleExplanation();

    public abstract RuleDescription.RuleType getRuleType();

    public abstract boolean ruleApplies(Sentence sentence);
}
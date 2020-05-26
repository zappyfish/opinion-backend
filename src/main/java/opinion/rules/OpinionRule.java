package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleResultOuterClass;

public interface OpinionRule {

    RuleResultOuterClass.RuleResult applyRule(Sentence sentence);

    String ruleExplanation();
}
package rules;

import sentences.Sentence;

public interface OpinionRule {

    RuleResult applyRule(Sentence sentence);

    String ruleExplanation();
}
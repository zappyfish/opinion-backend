package opinion.rules;

import opinion.sentences.Sentence;

public interface OpinionRule {

    RuleResult applyRule(Sentence sentence);

    String ruleExplanation();
}
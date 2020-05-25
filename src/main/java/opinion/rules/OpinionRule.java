package opinion.rules;

import main.java.opinion.sentences.Sentence;

public interface OpinionRule {

    RuleResult applyRule(Sentence sentence);

    String ruleExplanation();
}
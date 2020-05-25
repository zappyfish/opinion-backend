package src.rules;

public interface OpinionRule {

    RuleResult applyRule(Sentence sentence);

    String ruleExplanation();
}
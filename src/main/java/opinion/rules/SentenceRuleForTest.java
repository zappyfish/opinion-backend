package opinion.rules;

import opinion.sentences.Sentence;
import opinion.sentences.Word;
import proto.RuleResultOuterClass;

public class SentenceRuleForTest implements SentenceRule {

    @Override
    public RuleResultOuterClass.RuleResult applyRule(Sentence sentence) {
        boolean ruleApplies = false;
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().equals("fact")) {
                ruleApplies = true;
                break;
            }
        }

        RuleResultOuterClass.RuleDescription ruleDescription = RuleResultOuterClass.RuleDescription.newBuilder()
                .setRuleType(RuleResultOuterClass.RuleDescription.RuleType.FACT)
                .setRuleExplanation("the sentence is factual if it contains the word \"fact\"")
                .build();

        RuleResultOuterClass.RuleResult ruleResult = RuleResultOuterClass.RuleResult.newBuilder()
                .setRuleApplies(ruleApplies)
                .setRuleDescription(ruleDescription)
                .build();

        return ruleResult;
    }

    @Override
    public String getRuleName() {
        return "for_test";
    }

}

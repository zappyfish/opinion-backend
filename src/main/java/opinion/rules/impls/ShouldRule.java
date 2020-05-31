package opinion.rules.impls;

import opinion.rules.SentenceRule;
import opinion.sentences.Sentence;
import opinion.sentences.Word;
import proto.RuleResultOuterClass;


/**
 * Test class implementing the SentenceRule interface, used for testing other classes.
 */
public class ShouldRule extends SentenceRule {

    @Override
    public String getRuleExplanation() {
        return "this rule says that a sentence is opinionated if it contains the word \"should\"";
    }

    @Override
    public RuleResultOuterClass.RuleDescription.RuleType getRuleType() {
        return RuleResultOuterClass.RuleDescription.RuleType.OPINION;
    }

    @Override
    public boolean ruleApplies(Sentence sentence) {
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().contains("should")) {
                return true;
            }
        }
        return false;
    }

}

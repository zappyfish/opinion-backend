package opinion.rules.impls;

import opinion.rules.RuleResult;
import opinion.rules.SentenceRule;
import opinion.sentences.Sentence;
import opinion.sentences.Word;


/**
 * Test class implementing the SentenceRule interface, used for testing other classes.
 */
public class SentenceRuleForTest extends SentenceRule {

    @Override
    public String getRuleExplanation() {
        return "this rule says that a sentence is factual if it contains the word \"fact\"";
    }

    @Override
    public RuleResult.RuleType getRuleType() {
        return RuleResult.RuleType.FACT;
    }

    @Override
    public boolean ruleApplies(Sentence sentence) {
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().equals("fact")) {
                return true;
            }
        }
        return false;
    }

}

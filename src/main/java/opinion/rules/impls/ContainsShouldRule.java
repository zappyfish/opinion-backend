package opinion.rules.impls;

import opinion.rules.RuleResult;
import opinion.rules.SentenceRule;
import opinion.sentences.Sentence;
import opinion.sentences.Word;


/**
 * Should rule -- if a sentence contains the word "should", it is an opinion
 */
public class ContainsShouldRule extends SentenceRule {

    @Override
    public String getRuleExplanation() {
        return "this rule says that a sentence is opinionated if it contains the word \"should\"";
    }

    @Override
    public RuleResult.RuleType getRuleType() {
        return RuleResult.RuleType.OPINION;
    }

    @Override
    public boolean ruleApplies(Sentence sentence) {
        for (Word word : sentence.getWords()) {
            if (word.word().toLowerCase().contains("should")) { // will also cover shouldn't
                return true;
            }
        }
        return false;
    }

}

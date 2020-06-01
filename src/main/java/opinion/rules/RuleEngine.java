package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleListOuterClass.*;
import proto.RuleResultOuterClass.*;

import java.util.LinkedList;
import java.util.List;

/**
 * A RuleEngine contains a set of rules for determining whether a sentence is opinion or fact. It will apply each rule
 * and return their individual determinations. However, the aggregate conclusion is not performed by the RuleEngine.
 */
public class RuleEngine {

    private List<SentenceRule> mSentenceRules;

    /**
     * Instantiate a RuleEngine that will apply the rules described by ruleList
     */
    public RuleEngine(RuleList ruleList) {
        mSentenceRules = new LinkedList<SentenceRule>();
        for (Rule rule : ruleList.getRulesList()) {
            mSentenceRules.add(RuleFactory.getRule(rule.getRuleName()));
        }
    }

    /**
     * Apply every rule that is part of the rule engine to a sentence in order to get their results.
     * @param sentence - the Sentence to analyze
     * @return - the result of applyinig every rule contained in the rule engine
     */
    public List<RuleResult> applyRules(Sentence sentence) {
        List<RuleResult> ruleResults = new LinkedList<RuleResult>();
        for (SentenceRule sentenceRule : mSentenceRules) {
            ruleResults.add(sentenceRule.applyRule(sentence));
        }
        return ruleResults;
    }

}

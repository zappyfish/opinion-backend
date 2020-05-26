package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleListOuterClass;
import proto.RuleResultOuterClass;

import java.util.LinkedList;
import java.util.List;

public class RuleEngine {

    private List<SentenceRule> mSentenceRules;

    public RuleEngine(RuleListOuterClass.RuleList ruleList) {
        mSentenceRules = new LinkedList<SentenceRule>();
        for (RuleListOuterClass.Rule rule : ruleList.getRulesList()) {
            mSentenceRules.add(RuleFactory.getRule(rule.getRuleName()));
        }
    }

    public List<RuleResultOuterClass.RuleResult> applyRules(Sentence sentence) {
        List<RuleResultOuterClass.RuleResult> ruleResults = new LinkedList<RuleResultOuterClass.RuleResult>();
        for (SentenceRule sentenceRule : mSentenceRules) {
            ruleResults.add(sentenceRule.applyRule(sentence));
        }
        return ruleResults;
    }

}

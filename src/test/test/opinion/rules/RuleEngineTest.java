package opinion.rules;

import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;
import proto.RuleListOuterClass;
import proto.RuleResultOuterClass;

import java.util.List;

import static org.junit.Assert.*;

public class RuleEngineTest {

    RuleListOuterClass.RuleList getTestRuleList() {
        RuleListOuterClass.Rule testRule = RuleListOuterClass.Rule.newBuilder()
                .setRuleName("for_test")
                .build();
        RuleListOuterClass.RuleList ruleList = RuleListOuterClass.RuleList.newBuilder()
                .addRules(testRule)
                .build();
        return ruleList;
    }

    @Test
    public void testApplyRules() {
        RuleEngine ruleEngine = new RuleEngine(getTestRuleList());
        Sentence sentence1 = new Sentence("this sentence contains the word fact");
        List<RuleResultOuterClass.RuleResult> ruleResults1 = ruleEngine.applyRules(sentence1);
        Assert.assertEquals(ruleResults1.size(), 1);

        // The sentence contained "fact", so the rule should apply
        Assert.assertTrue(ruleResults1.get(0).getRuleApplies());

        Sentence sentence2 = new Sentence("this sentence does not contain that word");
        List<RuleResultOuterClass.RuleResult> ruleResults2 = ruleEngine.applyRules(sentence2);
        Assert.assertEquals(ruleResults2.size(), 1);

        // The sentence did not contain "fact", so the rule should not apply
        Assert.assertFalse(ruleResults2.get(0).getRuleApplies());
    }
}
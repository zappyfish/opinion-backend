package opinion.rules;

import opinion.rules.impls.ShouldRule;
import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;
import proto.RuleResultOuterClass;

import java.util.List;


public class ShouldRuleTest {

    private RuleEngine ruleEngine = new RuleEngine(getTestRuleList());
    private SentenceRule rule = RuleFactory.getRule("should");

    proto.RuleListOuterClass.RuleList getTestRuleList() {
        proto.RuleListOuterClass.Rule testRule = proto.RuleListOuterClass.Rule.newBuilder()
                .setRuleName("should")
                .build();
        proto.RuleListOuterClass.RuleList ruleList = proto.RuleListOuterClass.RuleList.newBuilder()
                .addRules(testRule)
                .build();
        return ruleList;
    }

    @Test
    public void testGetRuleName() {
        proto.RuleListOuterClass.Rule shouldRule = proto.RuleListOuterClass.Rule.newBuilder()
                .setRuleName("should")
                .build();

        Assert.assertEquals(shouldRule.getRuleName(), "should");
    }

    @Test
    public void testGetRuleExplanation() {
        Assert.assertEquals(rule.getRuleExplanation(), "this rule says that a sentence is opinionated if it contains the word \"should\"");
    }

    @Test
    public void testGetRuleType() {
        Assert.assertEquals(rule.getRuleType(), RuleResultOuterClass.RuleDescription.RuleType.OPINION);
    }

    @Test
    public void testRuleApplies() {

        Sentence mTestSentence1 = new Sentence("We should do this.");
        Sentence mTestSentence2 = new Sentence("They shouldn't go to the park today.");
        Sentence mTestSentence3 = new Sentence("He should've played for Chelsea instead.");
        Sentence mTestSentence4 = new Sentence("Should.");
        Sentence mTestSentence5 = new Sentence("I like grapes.");
        Sentence mTestSentence6 = new Sentence("Seltzer is my favorite drink.");

        List<RuleResultOuterClass.RuleResult> ruleResults1 = ruleEngine.applyRules(mTestSentence1);
        List<RuleResultOuterClass.RuleResult> ruleResults2 = ruleEngine.applyRules(mTestSentence2);
        List<RuleResultOuterClass.RuleResult> ruleResults3 = ruleEngine.applyRules(mTestSentence3);
        List<RuleResultOuterClass.RuleResult> ruleResults4 = ruleEngine.applyRules(mTestSentence4);
        List<RuleResultOuterClass.RuleResult> ruleResults5 = ruleEngine.applyRules(mTestSentence5);
        List<RuleResultOuterClass.RuleResult> ruleResults6 = ruleEngine.applyRules(mTestSentence6);

        Assert.assertTrue(ruleResults1.get(0).getRuleApplies());
        Assert.assertTrue(ruleResults2.get(0).getRuleApplies());
        Assert.assertTrue(ruleResults3.get(0).getRuleApplies());
        Assert.assertTrue(ruleResults4.get(0).getRuleApplies());

        Assert.assertFalse(ruleResults5.get(0).getRuleApplies());
        Assert.assertFalse(ruleResults6.get(0).getRuleApplies());
    }

}
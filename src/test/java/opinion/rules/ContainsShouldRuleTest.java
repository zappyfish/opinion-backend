package opinion.rules;

import opinion.rules.impls.ContainsShouldRule;
import opinion.sentences.Sentence;
import org.junit.Assert;
import org.junit.Test;

public class ContainsShouldRuleTest {

    @Test
    public void testGetRuleExplanation() {
        ContainsShouldRule shouldRule = new ContainsShouldRule();
        Assert.assertEquals(shouldRule.getRuleExplanation(), "this rule says that a sentence is opinionated if it contains the word \"should\"");
    }

    @Test
    public void testGetRuleType() {
        ContainsShouldRule shouldRule = new ContainsShouldRule();
        Assert.assertEquals(shouldRule.getRuleType(), RuleResult.RuleType.OPINION);
    }

    @Test
    public void testRuleApplies() {
        ContainsShouldRule shouldRule = new ContainsShouldRule();

        Sentence mTestSentence1 = new Sentence("We should do this.");
        Sentence mTestSentence2 = new Sentence("They shouldn't go to the park today.");
        Sentence mTestSentence3 = new Sentence("He should've played for Chelsea instead.");
        Sentence mTestSentence4 = new Sentence("Should.");
        Sentence mTestSentence5 = new Sentence("I like grapes.");
        Sentence mTestSentence6 = new Sentence("Seltzer is my favorite drink.");

        Assert.assertTrue(shouldRule.ruleApplies(mTestSentence1));
        Assert.assertTrue(shouldRule.ruleApplies(mTestSentence2));
        Assert.assertTrue(shouldRule.ruleApplies(mTestSentence3));
        Assert.assertTrue(shouldRule.ruleApplies(mTestSentence4));

        Assert.assertFalse(shouldRule.ruleApplies(mTestSentence5));
        Assert.assertFalse(shouldRule.ruleApplies(mTestSentence6));
    }

}
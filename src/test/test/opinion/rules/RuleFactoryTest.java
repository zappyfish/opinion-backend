package opinion.rules;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RuleFactoryTest {

    @Test
    public void testGetRule() {
        String testRuleName = "for_test";
        SentenceRule rule = RuleFactory.getRule(testRuleName);
        Assert.assertEquals(rule.getRuleExplanation(), "this rule says that a sentence is factual if it contains the word \"fact\"");
    }

    @Test
    public void testAllRulesAddedCorrectly() {
        Set<Class<? extends SentenceRule>> ruleTypes = null;
        try {
            ruleTypes = RuleFactory.getRuleTypes();
        } catch (ClassNotFoundException e) {
            Assert.fail(); // If this happens, you probably added your new rule to the factory incorrectly
        }
        for (String ruleName : RuleFactory.sRuleNames) {
            SentenceRule rule = RuleFactory.getRule(ruleName);
            Assert.assertTrue(ruleTypes.contains(rule.getClass()));
            ruleTypes.remove(rule.getClass());
        }
        // We should have seen every rule type
        Assert.assertTrue(ruleTypes.isEmpty());
    }
}
package opinion.rules;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleFactoryTest {

    @Test
    public void testGetRule() {
        String testRuleName = "for_test";
        SentenceRule rule = RuleFactory.getRule(testRuleName);
        Assert.assertEquals(rule.getRuleName(), testRuleName);
    }
}
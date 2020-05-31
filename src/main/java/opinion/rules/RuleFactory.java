package opinion.rules;

import opinion.rules.impls.SentenceRuleForTest;
import opinion.rules.impls.ShouldRule;
import org.reflections.Reflections;

import java.util.Set;

/**
 * A Factory to get the rule corresponding to a string rule name
 */
public class RuleFactory {

    // Add your new rule name here:
    public static final String[] sRuleNames = {
            "for_test",
            "should",
    };

    /**
     *
     * @return - the SentenceRule which corresponds to ruleName
     */
    public static SentenceRule getRule(String ruleName) {
        // Add your new rule name + type mapping here:
        if (ruleName.equals("for_test")) {
            return new SentenceRuleForTest();
        }
        if (ruleName.equals("should")) {
            return new ShouldRule();
        }
        return null;
    }

    public static Set<Class<? extends SentenceRule>> getRuleTypes() throws ClassNotFoundException {
        Reflections reflections = new Reflections(RuleFactory.class.getPackage().getName());
        Set<Class<? extends SentenceRule>> classNames = reflections.getSubTypesOf(SentenceRule.class);
        return classNames;
    }
}

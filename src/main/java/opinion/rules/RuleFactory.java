package opinion.rules;

/**
 * A Factor to get the rule corresponding to a string rule name
 */
public class RuleFactory {

    /**
     *
     * @return - the SentenceRule which corresponds to ruleName
     */
    public static SentenceRule getRule(String ruleName) {
        // Add your new rule name/type here
        if (ruleName.equals("for_test")) {
            return new SentenceRuleForTest();
        }
        return null;
    }
}

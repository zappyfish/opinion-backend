package opinion.rules;

public class RuleFactory {

    public static SentenceRule getRule(String rule) {
        // Add your new rule name/type here
        if (rule.equals("for_test")) {
            return new SentenceRuleForTest();
        }
        return null;
    }
}

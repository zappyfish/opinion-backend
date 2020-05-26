package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleResultOuterClass;

public interface SentenceRule {

    /**
     *
     * @return the result of applying this rule to a sentence
     */
    RuleResultOuterClass.RuleResult applyRule(Sentence sentence);

    /**
     *
     * @return the descriptive string name of this rule
     */
    String getRuleName();
}
package opinion.rules;

import opinion.sentences.Sentence;
import proto.RuleResultOuterClass;

public interface SentenceRule {

    RuleResultOuterClass.RuleResult applyRule(Sentence sentence);

    String getRuleName();
}
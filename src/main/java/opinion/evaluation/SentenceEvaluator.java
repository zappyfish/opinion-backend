package opinion.evaluation;

import opinion.sentences.Sentence;
import proto.RuleResultOuterClass;

import java.util.List;

public interface SentenceEvaluator {

    List<RuleResultOuterClass.RuleResult> isOpinion(Sentence sentence);

}
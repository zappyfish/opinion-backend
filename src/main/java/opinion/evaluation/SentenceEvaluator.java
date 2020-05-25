package opinion.evaluation;

import opinion.sentences.Sentence;

public interface SentenceEvaluator {

    boolean isOpinion(Sentence sentence);

}
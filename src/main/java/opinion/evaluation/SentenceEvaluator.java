package opinion.evaluation;

import main.java.opinion.sentences.Sentence;

public interface SentenceEvaluator {

    boolean isOpinion(Sentence sentence);

}
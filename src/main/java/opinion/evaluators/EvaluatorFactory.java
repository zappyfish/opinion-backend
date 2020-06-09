package opinion.evaluators;

import opinion.evaluators.impls.SentenceEvaluatorForTest;
import opinion.evaluators.impls.ContainsShouldEvaluator;
import org.reflections.Reflections;

import java.util.Set;

/**
 * A Factory to get the evaluator corresponding to a string evaluator name
 */
public class EvaluatorFactory {

    // Add your new evaluator name here:
    public static final String[] sEvaluatorNames = {
            "for_test",
            "contains_should",
    };

    /**
     *
     * @return - the SentenceEvaluator which corresponds to evaluatorName
     */
    public static SentenceEvaluator getEvaluator(String evaluatorName) {
        // Add your new evaluator here:
        if (evaluatorName.equals("for_test")) {
            return new SentenceEvaluatorForTest();
        }
        if (evaluatorName.equals("contains_should")) {
            return new ContainsShouldEvaluator();
        }
        return null;
    }

    public static Set<Class<? extends SentenceEvaluator>> getEvaluatorNames() throws ClassNotFoundException {
        Reflections reflections = new Reflections(EvaluatorFactory.class.getPackage().getName());
        Set<Class<? extends SentenceEvaluator>> classNames = reflections.getSubTypesOf(SentenceEvaluator.class);
        return classNames;
    }
}

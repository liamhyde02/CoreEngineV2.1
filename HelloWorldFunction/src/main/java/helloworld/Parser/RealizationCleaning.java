package helloworld.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class RealizationCleaning extends CleaningChainLink{
    public RealizationCleaning(CleaningChain next) {
        super(next);
    }
    public void clean(JavaEntity entity, ArrayList<String> classNames) {
        JavaClass javaClass = (JavaClass) entity;
        javaClass.getRealizations().removeIf(realization -> !classNames.contains(realization));
        Set<String> entitySet = new HashSet<>(javaClass.getRealizations());
        javaClass.getRealizations().clear();
        javaClass.getRealizations().addAll(entitySet);
        next.clean(entity, classNames);
    }
}

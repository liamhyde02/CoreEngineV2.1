package helloworld.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompositionCleaning extends CleaningChainLink{
    public CompositionCleaning(CleaningChain next) { super(next); }
    @Override
    public void clean(JavaEntity entity, ArrayList<String> classNames) {
        JavaClass javaClass = (JavaClass) entity;
        javaClass.getCompositions().removeIf(composition -> !classNames.contains(composition));
        Set<String> compositionSet = new HashSet<String>(javaClass.getCompositions());
        javaClass.getCompositions().clear();
        javaClass.getCompositions().addAll(compositionSet);
        next.clean(entity, classNames);
    }
}

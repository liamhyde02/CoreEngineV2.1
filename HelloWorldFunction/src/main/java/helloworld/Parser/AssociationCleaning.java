package helloworld.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AssociationCleaning extends CleaningChainLink {
    public AssociationCleaning(CleaningChain next) { super(next); }
    @Override
    public void clean(JavaEntity entity, ArrayList<String> classNames) {
        JavaClass javaClass = (JavaClass) entity;
        javaClass.getAssociations().removeIf(association -> !classNames.contains(association));
        Set<String> entitySet = new HashSet<>(javaClass.getAssociations());
        javaClass.getAssociations().clear();
        javaClass.getAssociations().addAll(entitySet);
        next.clean(entity, classNames);
    }
}

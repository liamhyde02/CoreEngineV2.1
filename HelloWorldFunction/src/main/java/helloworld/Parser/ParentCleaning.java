package helloworld.Parser;

import java.util.ArrayList;

public class ParentCleaning extends CleaningChainLink {
    public ParentCleaning(CleaningChain next) { super(next); }
    @Override
    public void clean(JavaEntity entity, ArrayList<String> classNames) {
        JavaClass javaClass = (JavaClass) entity;
        if (!classNames.contains(javaClass.getParent()))
            javaClass.setParent(null);
        next.clean(entity, classNames);
    }
}

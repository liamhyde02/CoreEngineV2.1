package helloworld.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DependencyCleaning extends CleaningChainEnd{
    @Override
    public void clean(JavaEntity entity, ArrayList<String> classNames) {
        entity.getDependencies().removeIf(dependency -> !classNames.contains(dependency));
        Set<String> entitySet = new HashSet<>(entity.getDependencies());
        entity.getDependencies().clear();
        entity.getDependencies().addAll(entitySet);
        }
    }


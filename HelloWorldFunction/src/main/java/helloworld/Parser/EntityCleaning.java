package helloworld.Parser;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EntityCleaning {
    CleaningChain chain;
    public EntityCleaning() {
    }
    public void clean(ArrayList<JavaEntity> entities) {
        ArrayList<String> classNames = (ArrayList<String>) entities.stream().map(JavaEntity::getName).collect(Collectors.toList());
        for (JavaEntity entity : entities) {
            if (entity.getType() == JavaEntityType.JAVA_BASE_CLASS || entity.getType() == JavaEntityType.JAVA_ABSTRACT_CLASS) {
                chain = new AssociationCleaning(
                            new RealizationCleaning(
                                    new CompositionCleaning(
                                            new ParentCleaning(
                                                    new DependencyCleaning()))));
            }
            else {
                chain = new DependencyCleaning();
            }
            chain.clean(entity, classNames);
        }
    }
}

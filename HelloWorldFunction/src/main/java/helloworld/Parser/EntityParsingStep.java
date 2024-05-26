package helloworld.Parser;

import com.github.javaparser.ast.CompilationUnit;

public abstract class EntityParsingStep implements EntityParsingChain {
    EntityParsingChain next;

    public EntityParsingStep(EntityParsingChain next) {
        this.next = next;
    }

    public abstract JavaEntity construct(EntityBuilder builder, CompilationUnit declaration);
}

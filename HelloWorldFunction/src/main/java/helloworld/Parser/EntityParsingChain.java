package helloworld.Parser;

import com.github.javaparser.ast.CompilationUnit;

public interface EntityParsingChain {
    JavaEntity construct(EntityBuilder builder, CompilationUnit unit);
}

package helloworld.Parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class NameParsingStep extends EntityParsingStep {
    public NameParsingStep(EntityParsingChain next) {
        super(next);
    }

    @Override
    public JavaEntity construct(EntityBuilder builder, CompilationUnit cu) {
        String packageName = cu.getPackageDeclaration().isPresent()
                ? cu.getPackageDeclaration().get().getNameAsString() : "";
        ClassCreatorCollector visitor = new ClassCreatorCollector(packageName);
        visitor.visit(cu, builder);
        if (this.next != null) {
            return this.next.construct(builder, cu);
        }
        return builder.build();
    }

    private static class ClassCreatorCollector extends VoidVisitorAdapter<EntityBuilder>
    {
        private final String packageName;

        public ClassCreatorCollector(String packageName) {
            super();
            this.packageName = packageName;
        }

        @Override
        public void visit(ClassOrInterfaceDeclaration n, EntityBuilder builder)
        {
            super.visit(n, builder);
            // Ignore inner classes, so hypothetically this will only be called once unless the file is malformed
            if (!n.isInnerClass()) {
                String name = n.getNameAsString();
                builder.name(name);
                if (this.packageName.equals("")) {
                    builder.fullyQualifiedName(name);
                }
                else {
                    builder.fullyQualifiedName(this.packageName + "." + name);
                }
            }
        }
    }
}
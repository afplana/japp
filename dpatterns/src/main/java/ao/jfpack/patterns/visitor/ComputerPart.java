package ao.jfpack.patterns.visitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

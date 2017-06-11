package pl.edu.agh.tkk17.sample;

public class NodeBracket extends Node{

    private Node node;

    public NodeBracket(Node node) {
        this.node = node;
    }

    public void accept(NodeVisitor visitor)
    {
        if (node instanceof NodeAdd) {
            visitor.visit((NodeAdd) node);
        }
        else if (node instanceof NodeMul) {
            visitor.visit((NodeMul) node);
        }
        else if (node instanceof NodeNumber) {
            visitor.visit((NodeNumber) node);
        }
        else if (node instanceof NodeDiv) {
            visitor.visit((NodeDiv) node);
        }
        else if (node instanceof NodeSub) {
            visitor.visit((NodeSub) node);
        }
        else if (node instanceof NodeBracket) {
            visitor.visit((NodeBracket) node);
        }
    }

}

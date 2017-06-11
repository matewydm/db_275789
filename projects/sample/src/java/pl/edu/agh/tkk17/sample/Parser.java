package pl.edu.agh.tkk17.sample;

import java.util.Arrays;
import java.util.Iterator;

public class Parser
{
    private Iterator<Token> tokens;
    private Token ctoken;

    public Parser(Iterable<Token> tokens)
    {
        this.tokens = tokens.iterator();
        this.forward();
    }

    private void forward()
    {
        this.ctoken = this.tokens.next();
    }

    private String value()
    {
        return this.ctoken.getValue();
    }

    private boolean check(TokenType type)
    {
        return this.ctoken.getType() == type;
    }

    private void expect(TokenType type)
    {
        if (!this.check(type)) {
            throw new UnexpectedTokenException(this.ctoken, type);
        }
    }

    private Node parseNumber()
    {
        StringBuilder multiNumeric = new StringBuilder();
        while(check(TokenType.NUM)) {
            multiNumeric.append(this.value());
            this.forward();
        }
        return new NodeNumber(multiNumeric.toString());
    }

    private Node parseTerm()
    {
        if (this.check(TokenType.LBR)) {
            return parseBrackets();
        } else {
            Node left = this.parseNumber();
            if (this.check(TokenType.MUL)) {
                this.forward();
                Node right = this.parseTerm();
                return new NodeMul(left, right);
            } else if (this.check(TokenType.DIV)) {
                this.forward();
                Node right = this.parseTerm();
                return new NodeDiv(left, right);
            } else {
                return left;
            }
        }
    }

    private Node parseExpression()
    {
        if (this.check(TokenType.LBR)) {
            return parseBrackets();
        } else {
            Node left = this.parseTerm();
            return buildNode(left);
        }
    }

    private Node parseBrackets() {

        this.forward();
        Node left = this.parseExpression();
        NodeBracket bracket = new NodeBracket(left);
        this.expect(TokenType.RBR);
        this.forward();
        return buildNode(bracket);
    }

    private Node parseProgram()
    {
        Node root = this.parseExpression();
        this.expect(TokenType.END);
        return root;
    }

    public static Node parse(Iterable<Token> tokens)
    {
        Parser parser = new Parser(tokens);
        Node root = parser.parseProgram();
        return root;
    }

    private Node buildNode(Node left) {
        switch (this.ctoken.getType()) {
            case ADD: {
                this.forward();
                Node right = this.parseExpression();
                return new NodeAdd(left,right);
            }
            case DIV: {
                this.forward();
                Node right = this.parseExpression();
                return new NodeDiv(left, right);
            }
            case SUB: {
                this.forward();
                Node right = this.parseExpression();
                return new NodeSub(left, right);
            }
            case MUL: {
                this.forward();
                Node right = this.parseExpression();
                return new NodeMul(left, right);
            }
            default: return left;
        }
    }
}

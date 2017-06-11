package pl.edu.agh.tkk17.sample;

public enum TokenType
{
    END("END"),
    NUM("NUM"),
    ADD("ADD"),
    MUL("MUL"),
    DIV("DIV"),
    SUB("SUB"),
    LBR("LBR"),
    RBR("RBR");

    private final String name;

    TokenType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}

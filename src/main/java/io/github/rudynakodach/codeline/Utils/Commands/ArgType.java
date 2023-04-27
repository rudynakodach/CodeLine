package io.github.rudynakodach.codeline.Utils.Commands;

public enum ArgType {
    INTEGER(0),
    STRING(1);

    private int value;

    ArgType(int i) {}

    public int getValue() {
        return value;
    }

}

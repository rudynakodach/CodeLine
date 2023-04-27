package io.github.rudynakodach.codeline.Utils.Commands;

import io.github.rudynakodach.codeline.Utils.Drawer;
import org.jetbrains.annotations.Nullable;

public record Command(Drawer drawer, String[] args) {

    public Command(@Nullable Drawer drawer, String[] args) {
        this.drawer = drawer;
        this.args = args;
    }
}

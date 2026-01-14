package fr.vahelnir.testplugin.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import fr.vahelnir.testplugin.gui.IncrementerGui;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.CompletableFuture;

public class TestCommand extends AbstractCommand {
    public TestCommand() {
        super("test", "just a test command");
    }

    @NullableDecl
    @Override
    protected CompletableFuture<Void> execute(@NonNullDecl CommandContext commandContext) {
        var sender = commandContext.sender();
        if (sender instanceof Player player) {
            var playerReference = player.getReference();
            if (playerReference == null) {
                return null;
            }

            var store = playerReference.getStore();
            var world = store.getExternalData().getWorld();

            return CompletableFuture.runAsync(() -> {
                var playerRefComponent = store.getComponent(playerReference, PlayerRef.getComponentType());
                if (playerRefComponent == null) {
                    return;
                }

                player.getPageManager().openCustomPage(playerReference, store, new IncrementerGui(playerRefComponent));
            }, world);
        }

        commandContext.sendMessage(Message.raw("This command can only be executed by a player."));
        return null;
    }
}

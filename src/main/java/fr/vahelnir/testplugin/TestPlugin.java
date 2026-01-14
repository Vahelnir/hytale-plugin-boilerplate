package fr.vahelnir.testplugin;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import fr.vahelnir.testplugin.commands.TestCommand;

public class TestPlugin extends JavaPlugin {

    public TestPlugin(JavaPluginInit init) {
        super(init);
    }

    @Override
    public void setup() {
        getLogger().atInfo().log("TestPlugin is setting up!");
    }

    @Override
    public void start() {
        getLogger().atInfo().log("TestPlugin has started!");
        getCommandRegistry().registerCommand(new TestCommand());
    }

    @Override
    public void shutdown() {
        getLogger().atInfo().log("TestPlugin is shutting down!");
    }
}

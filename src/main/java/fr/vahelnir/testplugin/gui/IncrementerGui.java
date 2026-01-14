package fr.vahelnir.testplugin.gui;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.EventData;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class IncrementerGui extends InteractiveCustomUIPage<IncrementerGui.IncrementerEventData> {
    private int count = 0;

    public IncrementerGui(@NonNullDecl PlayerRef playerRef) {
        super(playerRef, CustomPageLifetime.CanDismiss, IncrementerEventData.CODEC);
    }

    @Override
    public void build(@NonNullDecl Ref<EntityStore> ref, @NonNullDecl UICommandBuilder uiCommandBuilder, @NonNullDecl UIEventBuilder uiEventBuilder, @NonNullDecl Store<EntityStore> store) {
        uiCommandBuilder.append("Pages/Vahelnir_TestPlugin_Incrementer.ui");
        uiCommandBuilder.set("#IncrementedValue.Text", count + "");
        uiEventBuilder.addEventBinding(
            CustomUIEventBindingType.Activating,
            "#IncrementButton",
            (new EventData()).append("Type", "IncrementButton"),
            false
        );
    }

    @Override
    public void handleDataEvent(@NonNullDecl Ref<EntityStore> ref, @NonNullDecl Store<EntityStore> store, @NonNullDecl IncrementerEventData data) {
        if (data.type.equals("IncrementButton")) {
            count++;
            this.rebuild();
        }
    }


    public static class IncrementerEventData {
        static final String KEY_TYPE = "Type";
        public static final BuilderCodec<IncrementerEventData> CODEC = BuilderCodec.builder(IncrementerEventData.class, IncrementerEventData::new)
            .append(
                new KeyedCodec<String>(KEY_TYPE, BuilderCodec.STRING),
                (data, value, extraInfo) -> data.type = value,
                (data, extraInfo) -> data.type
            )
            .add()
            .build();

        private String type;
    }
}

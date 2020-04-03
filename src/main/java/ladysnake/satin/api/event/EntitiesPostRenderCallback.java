package ladysnake.satin.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Frustum;

@FunctionalInterface
public interface EntitiesPostRenderCallback {
    /**
     * Fired after Minecraft has rendered all entities and before it renders block entities.
     */
    Event<EntitiesPostRenderCallback> EVENT = EventFactory.createArrayBacked(EntitiesPostRenderCallback.class,
            (listeners) -> (camera, frustum, tickDelta) -> {
                for (EntitiesPostRenderCallback handler : listeners) {
                    handler.onEntitiesRendered(camera, frustum, tickDelta);
                }
            });

    void onEntitiesRendered(Camera camera, Frustum frustum, float tickDelta);
}

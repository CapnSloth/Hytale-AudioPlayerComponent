package com.capnsloth.systems;

import com.capnsloth.components.AudioPlayerComponent;
import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class AudioPlayerSystem extends EntityTickingSystem<EntityStore> {
    @Override
    public void tick(float deltaTime, int index, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {

       AudioPlayerComponent apc = store.getComponent(archetypeChunk.getReferenceTo(index), AudioPlayerComponent.COMPONENT_TYPE);
        // Run audio components set to auto-play.
        if(apc.autoplayAsRandom){
            apc.doLoopAll(true, store);
        }else if(apc.autoplay){
            apc.doLoopAll(false, store);
        }

    }

    @Override
    public @Nullable Query<EntityStore> getQuery() {
        return AudioPlayerComponent.COMPONENT_TYPE;
    }
}

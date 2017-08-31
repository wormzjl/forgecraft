package nmd.primal.forgecraft.renders.items;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

import java.util.Collection;

/**
 * Created by mminaie on 3/8/17.
 */
public class ModelPickaxe implements IModel
{
    public static final IModel MODEL = new ModelPickaxe();
    //private final ResourceLocation resourceHead;
    //private final ResourceLocation resourceHandle;

    @Override
    public IModel process(ImmutableMap<String, String> customData) {
        return null;
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return null;
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        return null;
    }

    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, java.util.function.Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        return null;
    }

    @Override
    public IModelState getDefaultState() {
        return null;
    }
}

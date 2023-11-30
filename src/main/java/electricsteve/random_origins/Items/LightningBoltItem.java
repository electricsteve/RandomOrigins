package electricsteve.random_origins.Items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningBoltItem extends Item {

    public LightningBoltItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Vec3d blockPos = context.getBlockPos().toCenterPos().add(0,1,0);
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, context.getWorld());
        lightning.setPosition(blockPos);
        context.getWorld().spawnEntity(lightning);
        return ActionResult.SUCCESS;
    }
}

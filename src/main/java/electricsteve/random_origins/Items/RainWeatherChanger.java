package electricsteve.random_origins.Items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RainWeatherChanger extends Item {
    public RainWeatherChanger(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.setWeather(0, 12000, true, false);
        }
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}

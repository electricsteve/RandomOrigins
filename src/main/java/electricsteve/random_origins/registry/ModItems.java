package electricsteve.random_origins.registry;

import electricsteve.random_origins.Items.BlankWeatherChangerItem;
import electricsteve.random_origins.Items.LightningBoltItem;
import electricsteve.random_origins.RandomOrigins;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item LIGHTNING_BOLT = register(new LightningBoltItem(new FabricItemSettings().maxCount(16)), "lightning_bolt");
    public static ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LIGHTNING_BOLT))
            .displayName(Text.translatable("itemGroup.randomorigins.item_group"))
            .entries((context, entries) -> {
                entries.add(LIGHTNING_BOLT);
            })
            .build();

    public static void register() {

        register(new BlankWeatherChangerItem(new FabricItemSettings().maxCount(1)), "blank_weather_changer");
    }

    private static Item register(Item item, String itemId) {
        return (Item) Registry.register(Registries.ITEM, RandomOrigins.identifier(itemId), item);
    }

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("tutorial", "test_group"), ITEM_GROUP);
    }
}

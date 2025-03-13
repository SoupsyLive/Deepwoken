package live.soupsy.item.custom;

import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
import live.soupsy.component.components.WeaponComponent;
import live.soupsy.mantra.Mantra;
import live.soupsy.weapon.Weapon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class WeaponItem extends Item {
    public WeaponItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)){
            // Add mantra to player mantras

            Weapon weapon = new Weapon(itemStack);

                user.sendMessage(Text.literal("Aquired: "+itemStack.getName()));


            user.getItemCooldownManager().set(this, 10);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if(!user.getAbilities().creativeMode)
            itemStack.decrement(1);

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (stack.contains(ModDataComponentTypes.WEAPON)) {
                WeaponComponent mtra = stack.get(ModDataComponentTypes.WEAPON);
                tooltip.add(Text.literal(mtra.name()).formatted(Formatting.GOLD));
                tooltip.add(Text.literal(String.valueOf(mtra.baseDamage())).formatted(Formatting.BLUE));
            }
        super.appendTooltip(stack, context, tooltip, type);
    }

}

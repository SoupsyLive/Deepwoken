package live.soupsy.item.custom;

import live.soupsy.component.ModDataComponentTypes;
import live.soupsy.component.components.MantraComponent;
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

public class MantraItem extends Item {
    public MantraItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)){
            // Add mantra to player mantras

            user.getItemCooldownManager().set(this, 10);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if(!user.getAbilities().creativeMode)
            itemStack.decrement(1);

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (stack.contains(ModDataComponentTypes.MANTRA)) {
                MantraComponent mtra = stack.get(ModDataComponentTypes.MANTRA);
                tooltip.add(Text.literal(mtra.name()).formatted(Formatting.GOLD));
            }
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getAbilities().creativeMode)
            return super.useOnEntity(stack, user, entity, hand);
            // If not in creative, ignore

        // Add Mantra to ENTITY of player
        user.getItemCooldownManager().set(this, 10);



        return super.useOnEntity(stack, user, entity, hand);
    }
}

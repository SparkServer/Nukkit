package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityDropper;
import cn.nukkit.dispenser.DispenseBehavior;
import cn.nukkit.dispenser.DropperDispenseBehavior;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemTool;

import javax.annotation.Nonnull;

@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockDropper extends BlockDispenser {

    public BlockDropper() {
        this(0);
    }

    public BlockDropper(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Dropper";
    }

    @Override
    public int getId() {
        return DROPPER;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public Class<? extends BlockEntityDropper> getBlockEntityClass() {
        return BlockEntityDropper.class;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public String getBlockEntityType() {
        return BlockEntity.DROPPER;
    }

    @Override
    public void dispense() {
        super.dispense();
    }

    @PowerNukkitDifference(info = "Spend items in container, the dropper faces to (if there is one).", since = "1.4.0.0-PN")
    @Override
    protected DispenseBehavior getDispenseBehavior(Item item) {
        return new DropperDispenseBehavior();
    }

    @Override
    public double getResistance() {
        return 3.5;
    }

    @Override
    public double getHardness() {
        return 3.5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }
}

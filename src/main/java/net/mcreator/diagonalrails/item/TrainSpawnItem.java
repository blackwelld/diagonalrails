package net.mcreator.diagonalrails.item;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.mcreator.diagonalrails.entity.TrainEntity;
import net.mcreator.diagonalrails.DiagonalRails;
import net.mcreator.diagonalrails.creativetab.TabDiagonalRails;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailBase.EnumRailDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class TrainSpawnItem extends Item {
    public TrainSpawnItem() {
        setUnlocalizedName("trainSpawnItem");
        setRegistryName("trainSpawnItem");
        setCreativeTab(TabDiagonalRails.tab);
        // Set more properties as needed
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            RayTraceResult rayTraceResult = rayTrace(world, player, false);

            if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos hitPos = rayTraceResult.getBlockPos();
                TrainEntity trainEntity = new TrainEntity(world);

                // Check if the block is a rail
                if (world.getBlockState(hitPos).getBlock() instanceof BlockRailBase) {
                    IBlockState railState = world.getBlockState(hitPos);
                    BlockRailBase rail = (BlockRailBase) railState.getBlock();
                    EnumRailDirection railDirection = rail.getRailDirection(world, hitPos, railState, trainEntity);
                    DiagonalRails.LOGGER.info("Rail direction: " + railDirection);

                    float rotation = 0.0f;
                    switch (railDirection) {
                        case NORTH_SOUTH:
                            rotation = 0.0f;
                            break;
                        case EAST_WEST:
                            rotation = 90.0f;
                            break;
                        // Add other cases for different rail directions
                    }

                    trainEntity.setPosition(hitPos.getX() + 0.5, hitPos.getY(), hitPos.getZ() + 0.5);
                    trainEntity.rotationYaw = rotation;
                } else {
                    trainEntity.setPosition(hitPos.getX() + 0.5, hitPos.getY() + 1, hitPos.getZ() + 0.5);
                }

                boolean spawnResult = world.spawnEntity(trainEntity);
                DiagonalRails.LOGGER.info("Spawned TrainEntity: " + spawnResult);
                DiagonalRails.LOGGER.info("TrainEntity position: X=" + trainEntity.posX + ", Y=" + trainEntity.posY + ", Z=" + trainEntity.posZ);
            }
        } else {
            DiagonalRails.LOGGER.info("Right-click action on client side, ignored.");
        }

        ItemStack stack = player.getHeldItem(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }








    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, 
            new ModelResourceLocation(new ResourceLocation("diagonalrails", "trainSpawnItem"), "inventory"));
    }

}

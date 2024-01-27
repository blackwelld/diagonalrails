package net.mcreator.diagonalrails.block;
import net.minecraft.block.BlockRail;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.BlockRailBase.EnumRailDirection;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.Block;

import net.mcreator.diagonalrails.creativetab.TabDiagonalRails;
import net.mcreator.diagonalrails.ElementsDiagonalRails;

import java.util.List;
import net.minecraft.item.EnumRarity;

@ElementsDiagonalRails.ModElement.Tag
public class BlockDiagonalRail extends ElementsDiagonalRails.ModElement {
	@GameRegistry.ObjectHolder("diagonalrails:diagonalrail")
	public static final Block block = null;
	public BlockDiagonalRail(ElementsDiagonalRails instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("diagonalrail"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("diagonalrails:diagonalrail", "inventory"));
	}
	public static class BlockCustom extends BlockRail {

// Import necessary Minecraft classes
// ... [Other parts of the existing code]

// Overriding a method to change the minecart's direction on the rail


// ... [Rest of the existing code]

		public static final PropertyEnum<EnumRailDirection> SHAPE = PropertyEnum.create("shape", EnumRailDirection.class);

		public BlockCustom() {
			super();
			setUnlocalizedName("diagonalrail");
			setSoundType(SoundType.WOOD);
			setHardness(1F);
			setResistance(2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabDiagonalRails.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumRailDirection.NORTH_SOUTH));

		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

		@Override
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    EnumRailDirection dir = state.getValue(SHAPE);
    switch (dir) {
        case ASCENDING_EAST:
        case ASCENDING_WEST:
        case ASCENDING_NORTH:
        case ASCENDING_SOUTH:
            // Define bounding boxes for ascending directions if needed
            return FULL_BLOCK_AABB; // Placeholder, update as needed
        case NORTH_SOUTH:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // North-South
        case EAST_WEST:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // East-West
        case NORTH_WEST:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // NORTH-West
        case NORTH_EAST:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // NORTH-EAst
        case SOUTH_WEST:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // SOUTH-West 
        case SOUTH_EAST:
            return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.0625D, 1D); // South-East  
        default:
            return FULL_BLOCK_AABB; // Default bounding box
    }
}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{SHAPE});
		}
/*
		@Override
		public IBlockState withRotation(IBlockState state, Rotation rot) {
			return state.withProperty(SHAPE, rot.rotate((EnumRailDirection) state.getValue(SHAPE)));
		}

		@Override
		public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
			return state.withRotation(mirrorIn.toRotation((EnumRailDirection) state.getValue(SHAPE)));
		}
*/
@Override
public IBlockState getStateFromMeta(int meta) {
    EnumRailDirection direction;
    switch (meta) {
        case 0: direction = EnumRailDirection.NORTH_WEST; break;
        case 1: direction = EnumRailDirection.NORTH_EAST; break;
        case 2: direction = EnumRailDirection.SOUTH_EAST; break;
        case 3: direction = EnumRailDirection.SOUTH_WEST; break;
        // ... continue for other directions
        default: direction = EnumRailDirection.SOUTH_EAST;
    }
    System.out.println("getStateFromMeta: Meta = " + meta + ", Direction = " + direction);
    return this.getDefaultState().withProperty(SHAPE, direction);
}


@Override
public int getMetaFromState(IBlockState state) {
    EnumRailDirection direction = state.getValue(SHAPE);
    int meta;
    switch (direction) {
        case NORTH_WEST: meta = 0; break;
        case NORTH_EAST: meta = 1; break;
        case SOUTH_EAST: meta = 2; break;
        case SOUTH_WEST: meta = 3; break;
        // ... continue for other directions
        default: return 2; // Fallback to a default meta value
    }
    System.out.println("getMetaFromState: Direction = " + direction + ", Meta = " + meta);
    return meta;
}


		@Override
public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
    
        // Log at the start of the method to confirm it's being called
    System.out.println("getStateForPlacement called - Player Facing: " + placer.getHorizontalFacing() + ", Sneaking: " + placer.isSneaking());

    EnumFacing playerFacing = placer.getHorizontalFacing();
    EnumRailDirection railDirection = EnumRailDirection.SOUTH_EAST; // Default value

  switch (playerFacing) {
        case NORTH:
            railDirection = placer.isSneaking() ? EnumRailDirection.NORTH_WEST : EnumRailDirection.NORTH_EAST;
            break;
        case SOUTH:
            railDirection = placer.isSneaking() ? EnumRailDirection.SOUTH_WEST : EnumRailDirection.SOUTH_EAST;
            break;
        case EAST:
            railDirection = placer.isSneaking() ? EnumRailDirection.NORTH_EAST : EnumRailDirection.SOUTH_EAST;
            break;
        case WEST:
            railDirection = placer.isSneaking() ? EnumRailDirection.SOUTH_WEST : EnumRailDirection.NORTH_WEST;
            break;
    }

      // Log the determined direction
    System.out.println("getStateForPlacement - Final Rail Direction: " + railDirection);

    return this.getDefaultState().withProperty(SHAPE, railDirection);
}



		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		
		public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumRailDirection side) {
			return true;
		}


			public void interactWithMinecarts(World world, BlockPos pos) {
    List<EntityMinecart> minecarts = world.getEntitiesWithinAABB(EntityMinecart.class, new AxisAlignedBB(pos));
    for (EntityMinecart cart : minecarts) {
        EnumRailDirection railDirection = world.getBlockState(pos).getValue(SHAPE);
        double speed = Math.sqrt(cart.motionX * cart.motionX + cart.motionZ * cart.motionZ);
        
        switch (railDirection) {
            case SOUTH_EAST:
                if (isCartMovingWest(cart)) {
                    cart.setVelocity(-speed, cart.motionY, cart.motionZ);
                } else if (isCartMovingEast(cart)) {
                    cart.setVelocity(cart.motionX, cart.motionY, -speed);
                }
                break;
            case NORTH_EAST:
                if (isCartMovingWest(cart)) {
                    cart.setVelocity(cart.motionX, cart.motionY, speed);
                } else if (isCartMovingEast(cart)) {
                    cart.setVelocity(-speed, cart.motionY, cart.motionZ);
                }
                break;
            case SOUTH_WEST:
                if (isCartMovingEast(cart)) {
                    cart.setVelocity(cart.motionX, cart.motionY, -speed);
                } else if (isCartMovingWest(cart)) {
                    cart.setVelocity(speed, cart.motionY, cart.motionZ);
                }
                break;
            case NORTH_WEST:
                if (isCartMovingEast(cart)) {
                    cart.setVelocity(speed, cart.motionY, cart.motionZ);
                } else if (isCartMovingWest(cart)) {
                    cart.setVelocity(cart.motionX, cart.motionY, speed);
                }
                break;
        }
    }
}

private boolean isCartMovingEast(EntityMinecart cart) {
    return cart.motionX > 0;
}

private boolean isCartMovingWest(EntityMinecart cart) {
    return cart.motionX < 0;
}
	}



	
    public boolean canConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
        // Modify this method to control how your rail connects with other blocks
        return false; // Example: Do not connect to any block
    }

}

// Alternative method to interact with minecarts
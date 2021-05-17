package io.github.fallOut015.teleporters.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TeleporterBlock extends Block {
    private static final VoxelShape BASE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape EYE_A_SHAPE = Block.box(1.0D, 8.0D, 1.0D, 4.0D, 9.0D, 4.0D);
    private static final VoxelShape EYE_B_SHAPE = Block.box(1.0D, 8.0D, 12.0D, 4.0D, 9.0D, 15.0D);
    private static final VoxelShape EYE_C_SHAPE = Block.box(12.0D, 8.0D, 12.0D, 12.0D, 9.0D, 15.0D);
    private static final VoxelShape EYE_D_SHAPE = Block.box(12.0D, 8.0D, 1.0D, 12.0D, 9.0D, 15.0D);
    private static final VoxelShape EYES_SHAPE = VoxelShapes.or(EYE_A_SHAPE, EYE_B_SHAPE, EYE_C_SHAPE, EYE_D_SHAPE);
    private static final VoxelShape AABB = VoxelShapes.or(BASE_SHAPE, EYES_SHAPE);

    public TeleporterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return AABB;
    }
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(player.getItemInHand(handIn).getItem() == Items.ENDER_EYE) {
            player.getItemInHand(handIn).getOrCreateTag().putLong("pos", pos.above().asLong());
            // Set item tag?
            return ActionResultType.SUCCESS;
        }

        return super.use(state, worldIn, pos, player, handIn, hit);
    }
}
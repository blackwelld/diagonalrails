package net.mcreator.diagonalrails.entity;

import net.minecraft.entity.Entity;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class TrainEntity extends EntityMinecart {

    public TrainEntity(World world) {
        super(world);
    }

    @Override
    public EntityMinecart.Type getType() {
        // Customize your minecart type or use an existing one
        return EntityMinecart.Type.RIDEABLE;
    }
    
    // Method to set rotation explicitly
    public void setTrainRotation(float yaw) {
        this.rotationYaw = yaw % -90;
    }

    // Custom methods and overrides for your entity behavior
}

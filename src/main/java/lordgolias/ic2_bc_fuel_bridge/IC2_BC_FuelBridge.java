package lordgolias.ic2_bc_fuel_bridge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import ic2.api.recipe.Recipes;


@Mod(modid = IC2_BC_FuelBridge.MODID, name = IC2_BC_FuelBridge.NAME, version = IC2_BC_FuelBridge.VERSION, acceptableRemoteVersions = "*")
public class IC2_BC_FuelBridge {
    public static final String MODID = "ic2_bc_fuel_bridge";
    public static final String NAME = "IC2-BC fuel bridge";
    public static final String VERSION = "1.0";

    private void defaultValues() {
        // Correspondence kEU<->MJ from 1 B of Oil in semi-fluid generator <-> Stirling engine
        final int kEUPerBucketOil = 8;  // kEU of Oil
        final double MJPerBucketOil = 30.0;  // in a stirling engine
        final double kEUPerMJ = kEUPerBucketOil / MJPerBucketOil;

        // Names below are for cold liquids only. For others, use:
        // hot: oil_heat_1
        // searing: oil_heat_2
        // BuildCraft's engines only accept cold liquids.

        //Recipes.semiFluidGenerator.addFluid("oil", 1, 30 * kEUPerBucket_CrudeOil); already supported by ic2
        //Recipes.semiFluidGenerator.addFluid("oil_residue", 1, 0);  // residue cannot be burned
        /// these values are retrieved from the script https://bt.industrial-craft.net/file_download.php?file_id=885&type=bug
        Recipes.semiFluidGenerator.addFluid("oil_heavy", 1, 80 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("oil_dense", 1, 120 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("oil_distilled", 1, 30 * kEUPerMJ);

        Recipes.semiFluidGenerator.addFluid("fuel_gaseous", 1, 15 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("fuel_mixed_light", 1, 24 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("fuel_light", 1, 60 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("fuel_mixed_heavy", 1, 48 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("fuel_dense", 1, 120 * kEUPerMJ);
    }

    private void progressionValues() {
        // Correspondence kEU<->MJ from 1 B of Oil in semi-fluid generator <-> Stirling engine
        final int kEUPerBucketOil = 8;  // kEU of Oil
        final double MJPerBucketOil = 30.0;  // in a stirling engine
        final double kEUPerMJ = kEUPerBucketOil / MJPerBucketOil;

        // Names below are for cold liquids only. For others, use:
        // hot: oil_heat_1
        // searing: oil_heat_2
        // BuildCraft's engines only accept cold liquids.

        //Recipes.semiFluidGenerator.addFluid("oil", 1, 30 * kEUPerBucket_CrudeOil); already supported by ic2
        //Recipes.semiFluidGenerator.addFluid("oil_residue", 1, 0);  // residue cannot be burned

        Recipes.semiFluidGenerator.addFluid("oil_heavy", 1, 80 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("oil_dense", 1, 120 * kEUPerMJ);
        Recipes.semiFluidGenerator.addFluid("oil_distilled", 1, 30 * kEUPerMJ);

        /// these values are retrieved from https://github.com/BuildCraft/BuildCraft/issues/4460
        final double baseLine = 15 * kEUPerMJ;
        Recipes.semiFluidGenerator.addFluid("fuel_gaseous", 1, baseLine);
        Recipes.semiFluidGenerator.addFluid("fuel_mixed_light", 1, 2 * baseLine);
        Recipes.semiFluidGenerator.addFluid("fuel_light", 1, 6 * baseLine);
        Recipes.semiFluidGenerator.addFluid("fuel_mixed_heavy", 1, 9.6 * baseLine);
        Recipes.semiFluidGenerator.addFluid("fuel_dense", 1, 36 * baseLine);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        progressionValues();
    }
}
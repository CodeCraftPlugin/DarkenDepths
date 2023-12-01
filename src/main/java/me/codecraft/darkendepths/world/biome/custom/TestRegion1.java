/**
 * Copyright (C) Glitchfiend
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package me.codecraft.darkendepths.world.biome.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class TestRegion1 extends Region
{
    public TestRegion1(Identifier name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

//    @Override
//    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
//        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
//        // Overlap Vanilla's parameters with our own for our COLD_BLUE biome.
//        // The parameters for this biome are chosen arbitrarily.
//        new ParameterPointListBuilder()
//                .temperature(Temperature.span(Temperature.COOL, Temperature.FROZEN))
//                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
//                .continentalness(Continentalness.INLAND)
//                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
//                .depth(Depth.SURFACE, Depth.FLOOR)
//                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
//                .build().forEach(point -> builder.add(point, TestBiomes.COLD_BLUE));
//
//        // Add our points to the mapper
//        builder.build().forEach(mapper::accept);
//        super.addBiomes(registry, mapper);
//    }
}

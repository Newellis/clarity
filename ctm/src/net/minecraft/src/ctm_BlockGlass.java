// This is part of Connected Textures Mod for Minecraft
// Not recommended for watching to children, pregnant women and people with weak nerves.
// File generated by Ctrl+c Ctrl+v magic
// License: GPLv3
// Official thread: http://www.minecraftforum.net/index.php?showtopic=228862
// Author: morpheus
// Author email: morpheus(at)iname(dot)com
package net.minecraft.src;

import java.util.Random;

public class ctm_BlockGlass extends BlockGlass {

    public ctm_BlockGlass(int i, int j, Material material, boolean flag) {
        super(i, j, material, flag);
    }

    public int quantityDropped(Random random) {
        return (mod_ctm.isGlassHarvestable ? 1 : 0);
    }

    public int getRenderType() {
        return mod_ctm.renderType;
    }

    public int getBlockTextureFromSide(int i) {
        // If called not from CTM - call parent's method
        boolean isFromCtm = false;
        for (StackTraceElement e : (new Throwable()).getStackTrace())
            if (e.getClassName() == "mod_ctm") {
                isFromCtm = true;
                break;
            }
        if (!isFromCtm)
            return super.getBlockTextureFromSide(i);
        // New code:
        return 0;
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int x, int y, int z,
            int dir) {
        // If called not from CTM - call parent's method
        boolean isFromCtm = false;
        for (StackTraceElement e : (new Throwable()).getStackTrace())
            if (e.getClassName() == "mod_ctm") {
                isFromCtm = true;
                break;
            }
        if (!isFromCtm)
            return super.getBlockTexture(iblockaccess, x, y, z, dir);
        // New code:
        boolean west = false, east = false, north = false, south = false;
        if (dir <= 1) {
            west = isShouldBeConnected(iblockaccess, x - 1, y, z, dir);
            east = isShouldBeConnected(iblockaccess, x + 1, y, z, dir);
            north = isShouldBeConnected(iblockaccess, x, y, z + 1, dir);
            south = isShouldBeConnected(iblockaccess, x, y, z - 1, dir);
        } else if (dir == 2) {
            west = isShouldBeConnected(iblockaccess, x + 1, y, z, dir);
            east = isShouldBeConnected(iblockaccess, x - 1, y, z, dir);
            north = isShouldBeConnected(iblockaccess, x, y - 1, z, dir);
            south = isShouldBeConnected(iblockaccess, x, y + 1, z, dir);
        } else if (dir == 3) {
            west = isShouldBeConnected(iblockaccess, x - 1, y, z, dir);
            east = isShouldBeConnected(iblockaccess, x + 1, y, z, dir);
            north = isShouldBeConnected(iblockaccess, x, y - 1, z, dir);
            south = isShouldBeConnected(iblockaccess, x, y + 1, z, dir);
        } else if (dir == 4) {
            west = isShouldBeConnected(iblockaccess, x, y, z - 1, dir);
            east = isShouldBeConnected(iblockaccess, x, y, z + 1, dir);
            north = isShouldBeConnected(iblockaccess, x, y - 1, z, dir);
            south = isShouldBeConnected(iblockaccess, x, y + 1, z, dir);
        } else if (dir == 5) {
            west = isShouldBeConnected(iblockaccess, x, y, z + 1, dir);
            east = isShouldBeConnected(iblockaccess, x, y, z - 1, dir);
            north = isShouldBeConnected(iblockaccess, x, y - 1, z, dir);
            south = isShouldBeConnected(iblockaccess, x, y + 1, z, dir);
        }
        int texture = 0;
        if (west && !east && !north && !south)
            texture = 3;
        else if (!west && east && !north && !south)
            texture = 1;
        else if (!west && !east && north && !south)
            texture = 16;
        else if (!west && !east && !north && south)
            texture = 48;
        else if (west && east && !north && !south)
            texture = 2;
        else if (!west && !east && north && south)
            texture = 32;
        else if (west && !east && north && !south)
            texture = 19;
        else if (west && !east && !north && south)
            texture = 51;
        else if (!west && east && north && !south)
            texture = 17;
        else if (!west && east && !north && south)
            texture = 49;
        else if (!west && east && north && south)
            texture = 33;
        else if (west && !east && north && south)
            texture = 35;
        else if (west && east && !north && south)
            texture = 50;
        else if (west && east && north && !south)
            texture = 18;
        else if (west && east && north && south)
            texture = 34;

        if (mod_ctm.fastGraphics)
            return texture;

        boolean ne = false;
        boolean nw = false;
        boolean se = false;
        boolean sw = false;
        if (dir <= 1) {
            ne = !isShouldBeConnected(iblockaccess, x + 1, y, z + 1, dir);
            nw = !isShouldBeConnected(iblockaccess, x - 1, y, z + 1, dir);
            se = !isShouldBeConnected(iblockaccess, x + 1, y, z - 1, dir);
            sw = !isShouldBeConnected(iblockaccess, x - 1, y, z - 1, dir);
        } else if (dir == 2) {
            ne = !isShouldBeConnected(iblockaccess, x - 1, y - 1, z, dir);
            nw = !isShouldBeConnected(iblockaccess, x + 1, y - 1, z, dir);
            se = !isShouldBeConnected(iblockaccess, x - 1, y + 1, z, dir);
            sw = !isShouldBeConnected(iblockaccess, x + 1, y + 1, z, dir);
        } else if (dir == 3) {
            ne = !isShouldBeConnected(iblockaccess, x + 1, y - 1, z, dir);
            nw = !isShouldBeConnected(iblockaccess, x - 1, y - 1, z, dir);
            se = !isShouldBeConnected(iblockaccess, x + 1, y + 1, z, dir);
            sw = !isShouldBeConnected(iblockaccess, x - 1, y + 1, z, dir);
        } else if (dir == 4) {
            ne = !isShouldBeConnected(iblockaccess, x, y - 1, z + 1, dir);
            nw = !isShouldBeConnected(iblockaccess, x, y - 1, z - 1, dir);
            se = !isShouldBeConnected(iblockaccess, x, y + 1, z + 1, dir);
            sw = !isShouldBeConnected(iblockaccess, x, y + 1, z - 1, dir);
        } else if (dir == 5) {
            ne = !isShouldBeConnected(iblockaccess, x, y - 1, z - 1, dir);
            nw = !isShouldBeConnected(iblockaccess, x, y - 1, z + 1, dir);
            se = !isShouldBeConnected(iblockaccess, x, y + 1, z - 1, dir);
            sw = !isShouldBeConnected(iblockaccess, x, y + 1, z + 1, dir);
        }

        if (texture == 17 && ne)
            texture = 4;
        if (texture == 19 && nw)
            texture = 5;
        if (texture == 49 && se)
            texture = 20;
        if (texture == 51 && sw)
            texture = 21;

        if (texture == 18 && ne && nw)
            texture = 7;
        if (texture == 33 && ne && se)
            texture = 6;
        if (texture == 35 && sw && nw)
            texture = 23;
        if (texture == 50 && sw && se)
            texture = 22;

        if (texture == 18 && !ne && nw)
            texture = 39;
        if (texture == 33 && ne && !se)
            texture = 38;
        if (texture == 35 && !sw && nw)
            texture = 53;
        if (texture == 50 && sw && !se)
            texture = 52;

        if (texture == 18 && ne && !nw)
            texture = 37;
        if (texture == 33 && !ne && se)
            texture = 36;
        if (texture == 35 && sw && !nw)
            texture = 55;
        if (texture == 50 && !sw && se)
            texture = 54;

        if (texture == 34 && ne && nw && se && sw)
            texture = 58;

        if (texture == 34 && !ne && nw && se && sw)
            texture = 9;
        if (texture == 34 && ne && !nw && se && sw)
            texture = 25;
        if (texture == 34 && ne && nw && !se && sw)
            texture = 8;
        if (texture == 34 && ne && nw && se && !sw)
            texture = 24;

        if (texture == 34 && ne && nw && !se && !sw)
            texture = 11;
        if (texture == 34 && !ne && !nw && se && sw)
            texture = 26;
        if (texture == 34 && !ne && nw && !se && sw)
            texture = 27;
        if (texture == 34 && ne && !nw && se && !sw)
            texture = 10;

        if (texture == 34 && ne && !nw && !se && sw)
            texture = 42;
        if (texture == 34 && !ne && nw && se && !sw)
            texture = 43;

        if (texture == 34 && ne && !nw && !se && !sw)
            texture = 40;
        if (texture == 34 && !ne && nw && !se && !sw)
            texture = 41;
        if (texture == 34 && !ne && !nw && se && !sw)
            texture = 56;
        if (texture == 34 && !ne && !nw && !se && sw)
            texture = 57;
        return texture;
    }

    private boolean isShouldBeConnected(IBlockAccess iblockaccess, int x, int y,
            int z, int i) {
        int x2 = x;
        int y2 = y;
        int z2 = z;
        if (i == 0)
            y2--;
        else if (i == 1)
            y2++;
        else if (i == 2)
            z2--;
        else if (i == 3)
            z2++;
        else if (i == 4)
            x2--;
        else if (i == 5)
            x2++;
        return (iblockaccess.getBlockId(x, y, z) == blockID) &&
                !iblockaccess.isBlockOpaqueCube(x2, y2, z2) &&
                (iblockaccess.getBlockId(x2, y2, z2) != blockID);
    }
}
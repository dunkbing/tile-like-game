package com.dangbinh.rain.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    private final int width;
    private final int height;
    public int[] pixels;

    public static final int TILE_SIZE = 64;
    public static final int TILE_SIZE_MASK = TILE_SIZE - 1;
    public int[] tiles = new int[TILE_SIZE * TILE_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < TILE_SIZE * TILE_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void render(int xOffset, int yOffset) {
        for (int y = 0; y < height; y++) {
            int yy = y + yOffset;
            for (int x = 0; x < width; x++) {
                int xx = x + xOffset;
                // int tileIndex = (x / 16) + (y / 16) * tile_size;
                int tileIndex = ((xx >> 4) & TILE_SIZE_MASK) + ((yy >> 4) & TILE_SIZE_MASK) * TILE_SIZE;
                pixels[x+y*width] = tiles[tileIndex]; // color code in hex
            }
        }
    }
}

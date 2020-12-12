package com.dangbinh.rain.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    private final int width;
    private final int height;
    public int[] pixels;

    public static int tile_size = 64;
    public int[] tiles = new int[tile_size*tile_size];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < 64*64; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // int tileIndex = (x / 16) + (y / 16) * tile_size;
                int tileIndex = (x >> 4) + (y >> 4) * tile_size;
                pixels[x+y*width] = tiles[tileIndex]; // color code in hex
            }
        }
    }
}

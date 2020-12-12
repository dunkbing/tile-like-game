package com.dangbinh.rain.graphics;

public class Screen {
    private final int width;
    private final int height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x+y*width] = 0xff00ff; // color code in hex
            }
        }
    }
}

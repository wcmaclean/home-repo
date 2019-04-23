package com.tattooorbit.spiderbubblesproto.chase;


import java.util.Random;

public class World {
    static final int WORLD_WIDTH = 10;
    static final int WORLD_HEIGHT = 13;
    static final int SCORE_INCREMENT = 10;
    static final float TICK_INITIAL = 0.05f;
    static final float TICK_DECREMENT = 0.005f;


    public boolean gameOver = false;;
    public int score = 0;
    
    public Mermaid mermaid;
    public Spidergirl spidergirl;
    public Eyefrown eyefrown;
    public Vortexmouth vortexmouth;
    
    boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random();
    float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
        placeCharacters();
    }
    
    private void placeCharacters() {
        mermaid = new Mermaid(4, 6);
        spidergirl = new Spidergirl(random.nextInt(320), random.nextInt(480));
        eyefrown = new Eyefrown(random.nextInt(320), random.nextInt(480));
        vortexmouth = new Vortexmouth(random.nextInt(320), random.nextInt(480));
    }
    





    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;


/*
            if (head.x == stain.x && head.y == stain.y) {
                score += SCORE_INCREMENT;
                snake.eat();
                if (snake.parts.size() == WORLD_WIDTH * WORLD_HEIGHT) {
                    gameOver = true;
                    return;
                } else {
                    //placeStain();
                }
*/       

                if (score % 100 == 0 && tick - TICK_DECREMENT > 0) {
                    tick -= TICK_DECREMENT;
                }
            //}
        }
    }
}

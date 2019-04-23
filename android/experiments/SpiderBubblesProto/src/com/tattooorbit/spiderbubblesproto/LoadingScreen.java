package com.tattooorbit.spiderbubblesproto;


import com.tattooorbit.framework.Game;
import com.tattooorbit.framework.Graphics;
import com.tattooorbit.framework.Screen;
import com.tattooorbit.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background2-blue.png", PixmapFormat.RGB565);
        Assets.mermaid = g.newPixmap("mermaid-red.png", PixmapFormat.ARGB4444);
        Assets.spidergirl = g.newPixmap("spidergirl-green.png", PixmapFormat.ARGB4444);
        Assets.eyefrown = g.newPixmap("eyefrown-purple.png", PixmapFormat.ARGB4444);
        Assets.vortexmouth = g.newPixmap("vortexmouth-orange.png", PixmapFormat.ARGB4444);

        
        
        //Assets.click = game.getAudio().newSound("click.ogg");
        //Assets.eat = game.getAudio().newSound("eat.ogg");
        //Assets.bitten = game.getAudio().newSound("bitten.ogg");
        //Settings.load(game.getFileIO());
        //game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
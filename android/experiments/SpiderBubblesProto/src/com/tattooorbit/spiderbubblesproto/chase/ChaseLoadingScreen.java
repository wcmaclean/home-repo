package com.tattooorbit.spiderbubblesproto.chase;

//import com.badlogic.androidgames.mrnom.MainMenuScreen;
//import com.badlogic.androidgames.mrnom.Settings;
import com.tattooorbit.framework.Game;
import com.tattooorbit.spiderbubblesproto.*;

public class ChaseLoadingScreen extends LoadingScreen{

    public ChaseLoadingScreen(Game game) {
        super(game);
        
        //Settings.load(game.getFileIO());
        game.setScreen(new GameScreen(game));
    }
	
}

package com.tattooorbit.framework;

import com.tattooorbit.framework.Audio;
import com.tattooorbit.framework.FileIO;
import com.tattooorbit.framework.Graphics;
import com.tattooorbit.framework.Input;
import com.tattooorbit.framework.Screen;

public interface Game {
    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();
}
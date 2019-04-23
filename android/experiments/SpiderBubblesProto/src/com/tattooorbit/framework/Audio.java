package com.tattooorbit.framework;

import com.tattooorbit.framework.Music;
import com.tattooorbit.framework.Sound;

public interface Audio {
    public Music newMusic(String filename);

    public Sound newSound(String filename);
}

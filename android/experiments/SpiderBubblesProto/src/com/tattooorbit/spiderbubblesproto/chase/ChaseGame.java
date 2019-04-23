package com.tattooorbit.spiderbubblesproto.chase;

import com.tattooorbit.framework.Game;
import com.tattooorbit.framework.*;
import com.tattooorbit.framework.impl.*;

public class ChaseGame extends AndroidGame {

	
	@Override
    public Screen getStartScreen() {
        return new ChaseLoadingScreen(this); 
    }
}

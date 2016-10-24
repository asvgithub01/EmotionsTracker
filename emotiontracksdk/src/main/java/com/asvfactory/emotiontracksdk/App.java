package com.asvfactory.emotiontracksdk;

import android.app.Application;
import android.os.Handler;

/**
 * Created by nubor on 21/10/2016.
 */
public class App extends Application {
    //todo esto sobra la emulacion ya lo hace
    static Handler mHandler;
    //todo esta variable se actualiza desde la app integradora para
// segmentar por su contenido en pantalla
    static int mEventId = 0;
}

package com.johns.Delay;

import com.johns.log.Log;

public class Delay {
    static public void delay(int time){

        try {
            Thread.sleep (time);
        } catch (InterruptedException ex) {
            Log.gravar("Delay: erro ao tentar pausar");
        }
    }
}

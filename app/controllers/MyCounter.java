package controllers;

import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.Monitor;

/**
 * Created by Mr. Skip.
 */

@Monitor
public class MyCounter {
    @Count(category = "play is work")
    public void resize(){

    };
}

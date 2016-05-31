package controllers;

import net.anotheria.moskito.aop.annotation.Monitor;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Mr. Skip.
 */

@Monitor
public class ControllerAPI extends Controller {

    private MyCounter myCounter = new MyCounter();

    public Result runMSK() {
        return ok();
    }

    public Result counter() {
        System.out.println("Append count");
        myCounter.resize();
        return ok();
    }

}

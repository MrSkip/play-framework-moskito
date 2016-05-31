package controllers

import net.anotheria.moskito.webui.embedded.{MoSKitoInspectStartException, StartMoSKitoInspectBackendForRemote}
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    try {
      System.out.println("Try to start")
      StartMoSKitoInspectBackendForRemote.startMoSKitoInspectBackend()
      System.out.println("Start")
    }
    catch {
      case e: MoSKitoInspectStartException => {
        System.out.println("Bad start")
        e.printStackTrace()
      }
    }
    Ok(views.html.index("Your new application is ready."))
  }

}
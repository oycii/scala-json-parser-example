package factory

import service.{DecoderCirceService, DecoderJson4sService, DecoderService}

object DecodeFactory {
  def getDecoder(t: String): DecoderService = {
    t match {
      case "circe" => new DecoderCirceService
      case "json4s" => new DecoderJson4sService
      case _ =>  throw new RuntimeException(s"Not found json lib with name: $t")
    }
  }
}

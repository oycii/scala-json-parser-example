import config.{AppConfig, AppConfigParser}
import dao.CountryDaoImpl
import factory.DecodeFactory
import service.{CountryService, DecoderService}

import scala.language.implicitConversions

object Main {

  def main(args: Array[String]): Unit = {
    try {
      val argsParser = AppConfigParser.parser()
      val appConfig = argsParser.parse(args, AppConfig())

      appConfig match {
        case Some(cfg) =>
          implicit val decoder: DecoderService = DecodeFactory.getDecoder(cfg.jsonLib)
          implicit  val c = new CountryDaoImpl()

          val countries = CountryService.find(cfg)
          CountryService.save(countries, cfg.filePathOut)

        case None =>
          System.exit(1)
      }
    } catch {
      case e: Throwable => e match {
        case _ =>
          e.printStackTrace()
          System.exit(1)
      }
    }
  }
}
package service

import entity.Country
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

import scala.util.Try

class DecoderJson4sService extends DecoderService  {

  override def extraction(src: String): Either[Throwable, List[Country]] = {
    implicit val formats: Formats = DefaultFormats // Brings in default date formats etc.
    val json = parse(src.mkString)
    Try((json).extract[List[Country]]).toEither
  }

}

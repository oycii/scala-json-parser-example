package service
import entity.Country

import io.circe
import io.circe.generic.auto._
import io.circe.parser.decode
import utils.Utils

class DecoderCirceService extends DecoderService  {
  override def extraction(src: String): Either[Throwable, List[Country]] = {
    decode[List[Country]](src.mkString)
  }
}

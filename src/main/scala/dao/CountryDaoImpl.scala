package dao

import io.circe.syntax._
import scala.language.implicitConversions
import io.circe.generic.auto._

import dto.CountryDto
import utils.Utils

import java.io.{File, PrintWriter}

class CountryDaoImpl extends CountryDao {

  def save(countries: List[CountryDto], filePath: String): Unit = {
    Utils.printToFile(new File(filePath)) { p: PrintWriter =>
      p.println(countries.asJson)
    }
  }
}

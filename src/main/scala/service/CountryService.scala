package service

import config.AppConfig
import dao.CountryDao
import dto.CountryDto
import entity.Country
import utils.Utils

object CountryService {
  def find(cfg: AppConfig)(implicit decoderService: DecoderService): List[CountryDto] = {
    Utils.withCloseable(scala.io.Source.fromFile(cfg.filePathIn)) { src =>
      val decoded: Either[Throwable, List[Country]] = decoderService.extraction(src.mkString)

      val countries = decoded match {
        case Right(value) =>
          value
            .filter(_.region == cfg.region)
            .sortBy(_.area)(Ordering[Double].reverse)
            .slice(0, cfg.count)
            .map(CountryDto.createDto)

        case Left(value) => throw new RuntimeException(s"Parsing problems: $value")
      }
      countries.toList
    }
  }

  def save(countries: List[CountryDto], fileOutPath: String)(implicit countryDao: CountryDao): Unit = {
    countryDao.save(countries, fileOutPath)
  }

}


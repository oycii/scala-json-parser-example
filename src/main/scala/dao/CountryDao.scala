package dao

import dto.CountryDto

trait CountryDao {
  def save(countries: List[CountryDto], filePath: String): Unit
}

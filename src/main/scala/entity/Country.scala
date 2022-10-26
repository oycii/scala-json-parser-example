package entity

case class Name(common: String)

case class Country(
                    name: Name,
                    capital: List[String],
                    area: Double,
                    region: String)

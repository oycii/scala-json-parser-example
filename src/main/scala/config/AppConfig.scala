package config

case class AppConfig(filePathIn: String = null, filePathOut: String = null, region: String = null, count: Int = -1,
                     jsonLib: String = null)

object AppConfigParser {
  def parser(): scopt.OptionParser[AppConfig] = {
    new scopt.OptionParser[AppConfig]("States") {

      opt[String]('i', "file_path_in").valueName("<String>").action((x, c) =>
        c.copy(filePathIn = x: String)).text("file_path_in - Путь к входящему json-файлу с данными")

      opt[String]('o', "file_path_out").valueName("<String>").action((x, c) =>
        c.copy(filePathOut = x: String)).text("file_path_out - Путь к исходящему json-файлу с результатом вычислений")

      opt[String]('r', "region").valueName("<String>").action((x, c) =>
        c.copy(region = x: String)).text("region - Регион для расчёта наибольшей площади")

      opt[Int]('c', "count").valueName("<Int>").action((x, c) =>
        c.copy(count = x: Int)).text("count - Количество в указанном регион стран с наибольшей площади для сохранения в файл")

      opt[String]('l', "json_lib").valueName("<String>").action((x, c) =>
        c.copy(jsonLib = x: String)).text("json_lib - Библиотека для работы с json: circe или json4s")

    }
  }
}



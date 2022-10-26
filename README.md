# scala-json-parser-example
Example of parser json with using circe or json4s

Run application with options:
-i input json file (use countries https://raw.githubusercontent.com/mledoze/countries/master/countries.json)
-o output file with result of parsing and filter
-r region for filter
-c count in result
-l  lib of parse json: circe or json4s

-i ./src/main/resourses/countries.json -o out.json -r Africa -l circe -c 10
package service

import entity.Country

trait DecoderService {
  def extraction(src: String): Either[Throwable, List[Country]]
}

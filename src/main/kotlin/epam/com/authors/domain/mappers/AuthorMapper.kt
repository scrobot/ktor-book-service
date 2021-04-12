package epam.com.authors.domain.mappers

import epam.com.authors.data.Author
import epam.com.authors.domain.models.AuthorDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

/**
 *
 *
 * @author Aleksei Scrobot
 */
@Mapper
interface AuthorMapper {

  @Mapping(source = "name", target = "firstName")
  fun convertToDto(author: Author): AuthorDto

}
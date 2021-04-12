package epam.com.authors.domain.models

/**
 *
 *
 * @author Aleksei Scrobot
 */
data class AuthorDto(
  val firstName: String,
  val lastName: String,
  val middleName: String?
) {

  val shortName: String = "${firstName.firstOrNull()}. ${middleName?.let { "${it.firstOrNull()}. " }}$lastName"
  val fullName: String = "$firstName ${middleName ?: ""} $lastName"

}
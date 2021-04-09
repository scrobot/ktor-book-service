package epam.com.config
import kotlinx.serialization.*
/**
 *
 *
 * @author Aleksei Scrobot
 */
@Serializable
data class Datasource(
  val host: String,
  val port: String,
  val db: String,
  val username: String,
  val password: String
) {

  fun toJdbcString() = "jdbc:postgresql://$host:$port/$db"

}
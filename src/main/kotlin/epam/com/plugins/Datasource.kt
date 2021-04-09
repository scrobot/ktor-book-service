package epam.com.plugins

import com.github.uharaqo.hocon.mapper.load
import com.typesafe.config.ConfigFactory
import epam.com.config.Datasource
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

/**
 *
 *
 * @author Aleksei Scrobot
 */
fun Application.configurePersistenceLayer() {
  val data = with(environment.config.config("ktor.datasource")) {
    Datasource(
      property("host").getString(),
      property("port").getString(),
      property("db").getString(),
      property("username").getString(),
      property("password").getString()
    )
  }

  Database.connect(data.toJdbcString(), driver = "org.postgresql.Driver",
    user = data.username, password = data.password)
}
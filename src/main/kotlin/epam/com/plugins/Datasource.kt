package epam.com.plugins

import epam.com.authors.data.Authors
import epam.com.books.data.Books
import epam.com.genres.data.Genres
import epam.com.config.Datasource
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

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

  Database.connect(
    data.toJdbcString(), driver = "org.postgresql.Driver",
    user = data.username, password = data.password
  )

  transaction {
    // print sql to std-out
    addLogger(StdOutSqlLogger)

    SchemaUtils.create(Books, Authors, Genres)
  }
}
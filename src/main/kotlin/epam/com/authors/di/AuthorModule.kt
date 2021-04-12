package epam.com.authors.di

import epam.com.authors.data.AuthorDao
import epam.com.authors.data.AuthorRepository
import epam.com.authors.domain.AuthorService
import epam.com.authors.domain.AuthorServiceContract
import epam.com.authors.domain.mappers.AuthorMapper
import org.koin.dsl.module
import org.mapstruct.factory.Mappers

/**
 *
 *
 * @author Aleksei Scrobot
 */

val authorsModule = module {
  single<AuthorServiceContract> { AuthorService(get(), get()) }
  single<AuthorRepository> { AuthorDao() }
  single<AuthorMapper> {  Mappers.getMapper(AuthorMapper::class.java) }
}
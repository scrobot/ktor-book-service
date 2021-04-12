package epam.com.genres.di

import epam.com.genres.data.GenreDao
import epam.com.genres.data.GenreRepository
import epam.com.genres.domain.GenreService
import epam.com.genres.domain.GenreServiceContract
import org.koin.dsl.module

/**
 *
 *
 * @author Aleksei Scrobot
 */

val genresModule = module {
  single<GenreServiceContract> { GenreService(get()) }
  single<GenreRepository> { GenreDao() }
}
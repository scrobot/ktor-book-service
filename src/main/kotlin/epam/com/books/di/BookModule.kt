package epam.com.books.di

import epam.com.books.data.repositories.*
import epam.com.books.domain.BookContract
import epam.com.books.domain.BookService
import org.koin.dsl.module

/**
 *
 *
 * @author Aleksei Scrobot
 */

val bookModule = module {
  single<BookContract> { BookService(get(), get(), get()) }
  single<BookRepository> { BookDao() }
  single<GenreRepository> { GenreDao() }
  single<AuthorRepository> { AuthorDao() }
}
package epam.com.books.di

import epam.com.books.data.BookDao
import epam.com.books.data.BookRepository
import epam.com.books.domain.BookServiceContract
import epam.com.books.domain.BookService
import org.koin.dsl.module

/**
 *
 *
 * @author Aleksei Scrobot
 */

val bookModule = module {
  single<BookServiceContract> { BookService(get()) }
  single<BookRepository> { BookDao() }
}
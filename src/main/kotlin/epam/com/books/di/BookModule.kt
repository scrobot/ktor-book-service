package epam.com.books.di

import epam.com.books.BookContract
import epam.com.books.BookService
import org.koin.dsl.module

/**
 *
 *
 * @author Aleksei Scrobot
 */

val bookModule = module {
  single<BookContract> { BookService() } // get() Will resolve HelloRepository
//  single { HelloRepository() }
}
package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

        public class Main {
            public static void main(String[] args) {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Kütüphane");
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                EntityTransaction transaction = entityManager.getTransaction();

                transaction.begin();

                Author author = new Author();
                author.setName("Justin Cronin");
                author.setCountry("England");
                author.setBirthYear(LocalDate.of(1962,02,06));
                entityManager.persist(author);

                Publisher publisher = new Publisher();
                publisher.setName("PrintForUs");
                publisher.setAddress("İstanbul");
                publisher.setEstablishmentYear(1999);
                entityManager.persist(publisher);

                Book book = new Book();
                book.setName("The Passage");
                book.setStock(13);
                book.setPublicationYear(2010);
                book.setAuthor(author);
                book.setPublisher(publisher);
                entityManager.persist(book);

                Category category = new Category();
                category.setName("Bilim Kurgu");
                category.setDescription("Roman");
                entityManager.persist(category);

                BookBorrowing bookBorrowing = new BookBorrowing();
                bookBorrowing.setBorrowerName("Bera");
                bookBorrowing.setBook(book);
                bookBorrowing.setBorrowingDate(LocalDate.now());
                bookBorrowing.setReturnDate(null);
                bookBorrowing.setBook(book);
                entityManager.persist(bookBorrowing);


                Book bookcat = entityManager.find(Book.class, book.getId());
                List<Category> categories = new ArrayList<>();
                categories.add(category);
                book.setCategories(categories);

                transaction.commit();

            }
        }
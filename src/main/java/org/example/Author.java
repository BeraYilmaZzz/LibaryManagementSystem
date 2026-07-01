package org.example;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="birth_year",nullable = false)
    private LocalDate birthYear;

    @Column(name = "country",nullable = false)
    private String country;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> bookList; // bir yazarın birden fazla kitabı olabileceği için list kullandık

}


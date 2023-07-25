package com.example.library.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;



@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ITEMS")
public class Item {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Enumerated
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public Item(Book book) {
        this.book = book;
        this.status = Status.AVAILABLE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
package com.example.library.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BORROWINGS")
public class Borrowing {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "BORROWED_FROM")
    private Date borrowedFrom;

    @Column(name = "BORROWED_TO")
    private Date borrowedTo;

    @Column(name = "PAID_FOR_DAMAGED")
    private boolean isPaidForDamaged;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Borrowing(Item item, Reader reader) {
        this.item = item;
        this.reader = reader;
        this.borrowedFrom = new Date();
        this.borrowedTo = null;
        this.isPaidForDamaged = false;
    }
}
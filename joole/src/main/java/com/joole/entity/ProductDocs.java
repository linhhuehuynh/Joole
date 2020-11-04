package com.joole.entity;

import javax.persistence.*;

@Entity
public class ProductDocs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String docName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="model_id", nullable = false)
    private Model model;
}

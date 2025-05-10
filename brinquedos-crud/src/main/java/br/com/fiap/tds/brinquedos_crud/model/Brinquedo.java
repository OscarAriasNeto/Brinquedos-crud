package br.com.fiap.tds.brinquedos_crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(name = "idade_maxima")
    private Integer idadeMaxima;

    // getters e setters ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getIdadeMaxima() { return idadeMaxima; }
    public void setIdadeMaxima(Integer idadeMaxima) { this.idadeMaxima = idadeMaxima; }
}

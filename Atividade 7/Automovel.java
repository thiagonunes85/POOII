import javax.persistence.*;

@Entity
@Table(name = "automovel")

public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "anofabricacao")
    private int anoFabricacao;

    @Column(name = "anoModelo")
    private int anoModelo;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "preco")
    private float preco;

    @Column(name = "kilometrage")
    private int kilometrage;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

}

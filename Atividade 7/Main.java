public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Marca marca = new Marca();
        marca.setNome("Fiat");

        Modelo modelo = new Modelo();
        modelo.setDescricao("Uno");
        modelo.setPotencia(75);
        modelo.setMarca(marca);

        Automovel automovel = new Automovel();
        automovel.setAnoFabricacao(2022);
        automovel.setAnoModelo(2023);
        automovel.setObservacoes("Novo");
        automovel.setPreco(40000);
        automovel.setKilometrage(0);
        automovel.setModelo(modelo);

        session.save(marca);
        session.save(modelo);
        session.save(automovel);

        session.getTransaction().commit();
        session.close();
    }
}

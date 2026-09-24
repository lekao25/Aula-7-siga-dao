package siga;

public class BancoSimulado {

    private static final AlunoDAO alunoDAO = new AlunoDAOMemoria();

    private BancoSimulado() {
    }

    public static AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }
}

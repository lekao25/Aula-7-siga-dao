package siga;

public class ServicoMatricula {

    private final AlunoDAO alunoDAO;

    public ServicoMatricula(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void matricular(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do aluno não pode estar vazio.");
        }

        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException(
                    "Média inválida. A média deve estar entre 0 e 10."
            );
        }

        alunoDAO.salvar(aluno);
    }

    public Aluno buscarPorMatricula(int matricula) {
        return alunoDAO.buscarPorMatricula(matricula);
    }
}

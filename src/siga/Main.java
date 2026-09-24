package siga;

public class Main {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = BancoSimulado.getAlunoDAO();
        ServicoMatricula servicoMatricula = new ServicoMatricula(alunoDAO);

        Aluno aluno1 = new Aluno("João Souza", 6.0);
        Aluno aluno2 = new Aluno("Maria Silva", 8.5);

        servicoMatricula.matricular(aluno1);
        servicoMatricula.matricular(aluno2);

        System.out.println();
        System.out.println("=== Relatório de Alunos ===");

        for (Aluno aluno : alunoDAO.listarTodos()) {
            System.out.println(aluno);
        }

        System.out.println();
        System.out.println("=== Teste de média inválida ===");

        try {
            Aluno alunoInvalido = new Aluno("Carlos Oliveira", 12.0);
            servicoMatricula.matricular(alunoInvalido);
        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }

        System.out.println();
        System.out.println("=== Teste de busca por matrícula ===");

        int matriculaBusca = 1;
        Aluno alunoEncontrado = servicoMatricula.buscarPorMatricula(matriculaBusca);

        if (alunoEncontrado != null) {
            System.out.println(
                    "Aluno encontrado: " +
                    alunoEncontrado +
                    " | Matrícula: " +
                    alunoEncontrado.getMatricula()
            );
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}

package siga;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAOMemoria implements AlunoDAO {

    private final List<Aluno> alunos;
    private int proximaMatricula;

    public AlunoDAOMemoria() {
        alunos = new ArrayList<>();
        proximaMatricula = 1;
    }

    @Override
    public void salvar(Aluno aluno) {
        aluno.setMatricula(proximaMatricula);
        proximaMatricula++;

        alunos.add(aluno);

        System.out.println("Aluno matriculado com sucesso!");
    }

    @Override
    public Aluno buscarPorMatricula(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }

        return null;
    }

    @Override
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }
}

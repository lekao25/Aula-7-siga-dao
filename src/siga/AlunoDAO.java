package siga;

import java.util.List;

public interface AlunoDAO {

    void salvar(Aluno aluno);

    Aluno buscarPorMatricula(int matricula);

    List<Aluno> listarTodos();
}
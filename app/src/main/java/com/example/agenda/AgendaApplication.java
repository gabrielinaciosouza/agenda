package com.example.agenda;

import android.app.Application;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Gabriel", "999999999", "gabriel@user.com"));
        dao.salva(new Aluno("João", "999999999", "joao@user.com"));
    }
}

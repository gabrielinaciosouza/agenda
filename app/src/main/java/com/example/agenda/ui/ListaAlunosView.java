package com.example.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.database.AgendaDatabase;
import com.example.agenda.database.dao.RoomAlunoDAO;
import com.example.agenda.model.Aluno;
import com.example.agenda.ui.activity.ListaAlunosActivity;
import com.example.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {


    private final ListaAlunosAdapter adapter;
    private final RoomAlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(context);
        AgendaDatabase database = AgendaDatabase.getInstance(context);
        this.dao = database.getRoomAlunoDAO();
    }

    public void confirmaRemocao(@NonNull MenuItem item) {

        new AlertDialog.Builder(context).
                setTitle("Removendo Aluno").
                setMessage("Tem certeza?").
                setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                }).
                setNegativeButton("Não", null).show();
    }


    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }
    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}

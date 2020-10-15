package com.example.agenda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {}

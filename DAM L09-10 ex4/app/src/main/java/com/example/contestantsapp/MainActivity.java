package com.example.contestantsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contestantsapp.model.Participant;
import com.example.contestantsapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, surnameInput, scoreInput;
    private Button addButton, sortByScoreButton, sortByNameButton;
    private ListView participantsList;
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayAdapter<Participant> adapter;
    private boolean sortScoreAscending = true;
    private boolean sortNameAscending = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        surnameInput = findViewById(R.id.surnameInput);
        scoreInput = findViewById(R.id.scoreInput);
        addButton = findViewById(R.id.addButton);
        sortByScoreButton = findViewById(R.id.sortByScoreButton);
        sortByNameButton = findViewById(R.id.sortByNameButton);
        participantsList = findViewById(R.id.participantsList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participants);
        participantsList.setAdapter(adapter);

        addButton.setOnClickListener(v -> addParticipant());
        sortByScoreButton.setOnClickListener(v -> sortByScore());
        sortByNameButton.setOnClickListener(v -> sortByName());

        participantsList.setOnItemClickListener((parent, view, position, id) -> updateParticipant(position));
        participantsList.setOnItemLongClickListener((parent, view, position, id) -> {
            deleteParticipant(position);
            return true;
        });
    }

    private void addParticipant() {
        String name = nameInput.getText().toString().trim();
        String surname = surnameInput.getText().toString().trim();
        String scoreStr = scoreInput.getText().toString().trim();

        if (name.isEmpty() || surname.isEmpty() || scoreStr.isEmpty()) {
            Toast.makeText(this, "Completeaza toate campurile", Toast.LENGTH_SHORT).show();
            return;
        }

        int score = Integer.parseInt(scoreStr);
        if (score < 0 || score > 100) {
            Toast.makeText(this, "Scor invalid", Toast.LENGTH_SHORT).show();
            return;
        }

        participants.add(new Participant(name, surname, score));
        adapter.notifyDataSetChanged();
        nameInput.setText("");
        surnameInput.setText("");
        scoreInput.setText("");
    }

    private void updateParticipant(int position) {
        Participant p = participants.get(position);
        nameInput.setText(p.getNume());
        surnameInput.setText(p.getPrenume());
        scoreInput.setText(String.valueOf(p.getScor()));

        addButton.setText("Actualizeaza");
        addButton.setOnClickListener(v -> {
            p.setScor(Integer.parseInt(scoreInput.getText().toString().trim()));
            adapter.notifyDataSetChanged();
            addButton.setText("Adauga participant");
            addButton.setOnClickListener(view -> addParticipant());
        });
    }

    private void deleteParticipant(int position) {
        participants.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Participant sters", Toast.LENGTH_SHORT).show();
    }

    private void sortByScore() {
        if (sortScoreAscending) {
            Collections.sort(participants, Comparator.comparingInt(Participant::getScor));
            sortByScoreButton.setText("Sortare dupa scor descrescator");
        } else {
            Collections.sort(participants, (p1, p2) -> p2.getScor() - p1.getScor());
            sortByScoreButton.setText("Sortare dupa scor crescator");
        }
        sortScoreAscending = !sortScoreAscending;
        adapter.notifyDataSetChanged();
    }

    private void sortByName() {
        if (sortNameAscending) {
            Collections.sort(participants, Comparator.comparing(Participant::getNume));
            sortByNameButton.setText("Sortare dupa nume alfabetic");
        } else {
            Collections.sort(participants, (p1, p2) -> p2.getNume().compareTo(p1.getNume()));
            sortByNameButton.setText("Sortare dupa nume invers alfabetic");
        }
        sortNameAscending = !sortNameAscending;
        adapter.notifyDataSetChanged();
    }
}

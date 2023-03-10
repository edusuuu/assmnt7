package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView editId;
        EditText tvfName, tvSection, tvCourse, tvMt, tvFinals,tvGrade;

        Button btnEdit = findViewById(R.id.editBtn);
        editId = findViewById(R.id.editID);
        tvfName = findViewById(R.id.tvfName);
        tvSection = findViewById(R.id.tvSection);
        tvCourse = findViewById(R.id.tvCourse);
        tvMt = findViewById(R.id.tvMt);
        tvFinals = findViewById(R.id.tvFinals);
        tvGrade = findViewById(R.id.tvGrade);


        final DataManager dm = new DataManager(this);
        Intent intent = getIntent();
        editId.setText(intent.getStringExtra("IDnum"));
        tvfName.setText("Name: " +(intent.getStringExtra("name")));
        tvCourse.setText("Course: " + (intent.getStringExtra("course")));
        tvSection.setText("Section: " + (intent.getStringExtra("section")));
        tvMt.setText("Midterm Grade: " + (intent.getStringExtra("midterm")));
        tvFinals.setText("Finals Grade: " + (intent.getStringExtra("finals")));
        tvGrade.setText("GWA: " + (intent.getStringExtra("fgrade")));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.update(editId.getText().toString(),tvfName.getText().toString(), tvSection.getText().toString(),
                        tvCourse.getText().toString(), tvMt.getText().toString(), tvFinals.getText().toString(),tvGrade.getText().toString());
                Toast.makeText(MainActivity2.this,  editId.getText().toString() + "has been updated!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
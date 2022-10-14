package com.example.pr1819_antuh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Создаём массив разделов:
    private String titles[] = {
            "00. История тхекводо",
            "01. Белый пояс",
            "02. Жёлтый пояс",
            "03. Зелёный пояс",
            "04. Синий пояс",
            "05. Красный пояс",
            "06. Чёрный пояс",
            "07. Путь к успеху",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);

                intent.putExtra("title", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
}
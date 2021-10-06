package com.example.phuonglvd00631;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName, edtQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        edtName = findViewById(R.id.edt_name);
        edtQuantity = findViewById(R.id.edt_quantity);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_view).setOnClickListener(this);

        App.getInstance().getDatabase().queryData("CREATE TABLE IF NOT EXISTS Product (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name VARCHAR(200)," +
                "Quantity INTEGER" +
                ")");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            String name = edtName.getText().toString();
            int quantity = Integer.parseInt(edtQuantity.getText().toString());

            App.getInstance().getDatabase().queryData("INSERT INTO Product " +
                    "VALUES" +
                    "(null, " +
                    "'" + name + "'," +
                     quantity +
                    ")");
        } else if (view.getId() == R.id.btn_view) {
            Intent intent = new Intent(this, ListProductActivity.class);
            startActivity(intent);
        }
    }
}
package com.adiyusuf.pertemuan1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import com.adiyusuf.pertemuan1.listener.OnBeliListener;
import com.adiyusuf.pertemuan1.pojo.Honda;

public class MainActivity extends AppCompatActivity implements OnBeliListener, View.OnClickListener {

    EditText edt;
    TextView tv;
    Honda dataHonda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);
        edt = findViewById(R.id.edt);
        tv = findViewById(R.id.tv);
        dataHonda = new Honda();
    }

    @Override
    public void onDenda(int bulan) {
        double hitungDenda = 0;
        if (Integer.parseInt(edt.getText().toString()) > dataHonda.getBatasWaktu()) {
            hitungDenda = dataHonda.getHargaSewa() - (dataHonda.getHargaSewa() * 0.2);
        }

        String stringTampilkan = "denda kamu sebesar : " + hitungDenda;
        tv.setText(stringTampilkan);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            PerhitunganDenda.hitung(Integer.parseInt(edt.getText().toString()), this);
        }
    }
}
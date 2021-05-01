package com.adiyusuf.pertemuan1;

import com.adiyusuf.pertemuan1.listener.OnBeliListener;

public abstract class PerhitunganDenda {

    public static void hitung(int bulan, OnBeliListener listener) {
        listener.onDenda(bulan);
    }
}

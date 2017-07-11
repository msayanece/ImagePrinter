package com.example.admin.imageprinter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void doPhotoPrint() {
        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.image);
        photoPrinter.printBitmap("image.png_test_print", bitmap, new PrintHelper.OnPrintFinishCallback() {
            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Thank you!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        doPhotoPrint();
    }
}

package sg.edu.rp.c346.id20014063.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dbs, ocbc, uob;
    String clicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.DBS);
        ocbc = findViewById(R.id.OCBC);
        uob = findViewById(R.id.UOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,0,0,"Toggle");
        menu.add(0,1,1,"Website");
        menu.add(0,2,2,"Contact");

        if(v == dbs){
            clicked = "dbs";
        }
        else if(v == ocbc){
            clicked = "ocbc";
        }
        else if(v == uob){
            clicked = "uob";
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(clicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            } else if (item.getItemId() == 2) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(i);
            } else if (item.getItemId() == 0) {
                if(dbs.getCurrentTextColor() == Color.BLACK){
                    dbs.setTextColor(Color.RED);
                }
                else{
                    dbs.setTextColor(Color.BLACK);
                }
            }


        } else if (clicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            } else if (item.getItemId() == 2) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            } else if (item.getItemId() == 0) {
                if(ocbc.getCurrentTextColor() == Color.BLACK){
                    ocbc.setTextColor(Color.RED);
                }
                else{
                    ocbc.setTextColor(Color.BLACK);
                }
            }


        } else if (clicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            } else if (item.getItemId() == 2) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(i);
            } else if (item.getItemId() == 0) {
                if(uob.getCurrentTextColor() == Color.BLACK){
                    uob.setTextColor(Color.RED);
                }
                else{
                    uob.setTextColor(Color.BLACK);
                }
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.English){
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
        }
        else if(item.getItemId() == R.id.Chinese){
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
        }


        return super.onOptionsItemSelected(item);
    }
}
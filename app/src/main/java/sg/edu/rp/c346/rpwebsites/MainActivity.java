package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.button);


        //update entries of the spinner(same as listview)
        final ArrayList<String>alCat;
        final ArrayAdapter<String>aaCat;

        //initialise the arrayList
        alCat = new ArrayList<>();

        //Create an array adapter using the default spinner layout and the arraylist
        aaCat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCat);

        //bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaCat);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                //int pos = spn1.getSelectedItemPosition();
                alCat.clear();

                if(pos == 0){
                    String[] strCat = getResources().getStringArray(R.array.sub_cat1);
                    alCat.addAll(Arrays.asList(strCat));
                }
                else if(pos == 1){
                    String[] strCat = getResources().getStringArray(R.array.sub_cat2);
                    alCat.addAll(Arrays.asList(strCat));
                }
                    aaCat.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";

                if(spn1.getSelectedItemPosition() == 0){
                    if(spn2.getSelectedItemPosition() == 0){
                        url = "https://www.rp.edu.sg/";
                    }
                    else if(spn2.getSelectedItemPosition() == 1){

                        url = "https://www.rp.edu.sg/student-life";
                    }
                }
                else if(spn1.getSelectedItemPosition() == 1){

                    if(spn2.getSelectedItemPosition() == 0){
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else if(spn2.getSelectedItemPosition() == 1){

                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }

                }





                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("url",url );
                startActivity(intent);
            }
        });


    }
}

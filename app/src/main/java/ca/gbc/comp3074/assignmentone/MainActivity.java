package ca.gbc.comp3074.assignmentone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText numHours;
    private EditText hourlyRate;
    private TextView totalPayTxt;
    private TextView taxTxt;
    private TextView totalPayLabel;
    private TextView taxLabel;
    private Button resetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.calculateBtn);
        hourlyRate = findViewById(R.id.hourly_rate);
        numHours = findViewById(R.id.no_of_hours);
        totalPayTxt = findViewById(R.id.ouputPayTxt);
        taxTxt = findViewById(R.id.outputTaxTxt);
        totalPayLabel = findViewById(R.id.output1Txt);
        taxLabel = findViewById(R.id.output2Txt);
        resetBtn = findViewById(R.id.resetBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                String hours = numHours.getText().toString();
                String rate = hourlyRate.getText().toString();
                double totalPay = 0;
                double tax;
                if(hours.trim().length() != 0 && rate.trim().length() != 0){
                    double dHours = Double.parseDouble(hours);
                    double dRate = Double.parseDouble(rate);

                    if(dHours <= 40){
                        totalPay = dHours * dRate;
                    }else {
                        totalPay = (dHours - 40) * dRate * 1.5 + 40 * dRate;
                    }
                    tax = totalPay * 0.18;
                    setDisplayOutputs(totalPay, tax);
                }else{
                    Toast.makeText(getApplicationContext(), "Cannot leave fields blank", Toast.LENGTH_LONG).show();
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hourlyRate.setText("");
                numHours.setText("");
                recreate();
            }
        });

    }

    public void setDisplayOutputs(double totalPay, double tax){

        totalPayTxt.setText(String.format(Locale.CANADA, "%s%.2f" ,"$", totalPay));
        taxTxt.setText(String.format(Locale.CANADA, "%s%.2f" ,"$",tax));
        totalPayTxt.setVisibility(View.VISIBLE);
        taxTxt.setVisibility(View.VISIBLE);
        totalPayLabel.setVisibility(View.VISIBLE);
        taxLabel.setVisibility(View.VISIBLE);
        resetBtn.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_about) {
            openActivityAbout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openActivityAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
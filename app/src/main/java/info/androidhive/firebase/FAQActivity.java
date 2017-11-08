package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FAQActivity extends AppCompatActivity {

    private TextView faq1;
    private TextView faq2;
    private TextView faq3;
    private TextView faq4;
    private TextView faq5;
    private TextView faq6;
    private TextView faq7;
    private TextView faq8;
  int f2 =0,f4=0,f6=0,f8=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        faq1= (TextView)findViewById(R.id.faq1);
        faq2= (TextView)findViewById(R.id.faq2);
        faq3= (TextView)findViewById(R.id.faq3);
        faq4= (TextView)findViewById(R.id.faq4);
        faq5= (TextView)findViewById(R.id.faq5);
        faq6= (TextView)findViewById(R.id.faq6);
        faq7= (TextView)findViewById(R.id.faq7);
        faq8= (TextView)findViewById(R.id.faq8);


        faq1.setText("What is Fixed Deposit?");
        faq2.setText("Fixed deposit is a type of investment instrument that is offered by banks as well as \n non-banking financial companies (NBFCs)");
        faq3.setText("What is Interst Rate?");
        faq4.setText("The interest rate is the percent of principal charged by the lender for the use of its money.\n" +
                "The principal is the amount of money lent. Banks pay you an interest rate on deposits because they borrow that money from you");
         faq5.setText("What is Demand Draft?");
         faq6.setText("A demand draft is a method used by an individual for making a transfer payment from one bank account to another.\n Demand drafts differ from normal checks in that they do not require signatures to be cashed.\n" );
         faq7.setText("What is Mututal Fund?");
         faq8.setText("an investment programme funded by shareholders that trades in diversified holdings and is professionally managed.");



         faq2.setVisibility(View.GONE);
        faq4.setVisibility(View.GONE);
        faq6.setVisibility(View.GONE);
        faq8.setVisibility(View.GONE);

        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f2==0) {
                    faq2.setVisibility(View.VISIBLE);
                    f2=1;
                }else{
                    f2=0;
                    faq2.setVisibility(View.GONE);

                }

            }
        });

        faq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f4==0) {
                    faq4.setVisibility(View.VISIBLE);
                    f4=1;
                }else{
                    f4=0;
                    faq4.setVisibility(View.GONE);

                }

            }
        });


        faq5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f6==0) {
                    faq6.setVisibility(View.VISIBLE);
                    f6=1;
                }else{
                    f6=0;
                    faq6.setVisibility(View.GONE);

                }

            }
        });


        faq7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f8==0) {
                    faq8.setVisibility(View.VISIBLE);
                    f8=1;
                }else{
                    f8=0;
                    faq8.setVisibility(View.GONE);

                }


            }
        });






    }
}

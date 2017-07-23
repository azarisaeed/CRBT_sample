package ir.saeedazari.crbtsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.electrocom.crbt2.CRBT;

public class MainActivity extends AppCompatActivity {
    private static final int CRBT_PERMISSION_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*******************crbtpermission************************
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            CRBT.initializeWithDelay(this, 3, 1000); //start with your own delay (context,your app id,delay in ms)


            //CRBT.initialize(this,3);//start with our default (context,your app id)


            //int score =CRBT.getUserScore(this);//get user score (context)


            //CRBT.startCrbtProfileActivity(this);//show profile page (context)
        }
        else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                    CRBT_PERMISSION_REQUEST);
        }
        //*******************crbtpermission************************

        LinearLayout la = (LinearLayout) findViewById(R.id.click);
        la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://saeedazari.ir");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
    //*******************crbtpermission************************
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CRBT_PERMISSION_REQUEST){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                CRBT.initializeWithDelay(this, 3, 1000); //start with your own delay (context,your app id,delay in ms)

                //CRBT.initialize(this,3);//start with our default (context,your app id)


                //int score =CRBT.getUserScore(this);//get user score (context)


                //CRBT.startCrbtProfileActivity(this);//show profile page (context)
            }
            else {
                //CRBT cannot run without this permission, You can warn user that this permissions are necessary to start app
                //and request permissions again
            }
        }
    }
    //*******************crbtpermission************************

}

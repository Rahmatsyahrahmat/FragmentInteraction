package com.rahmat.fragmentinteraction;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnInteraction {

    public String _dataFromFrg;
    public boolean _isTwoPane = false;
    FragmentManager _FM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _FM = getSupportFragmentManager();


        if(findViewById(R.id.frameContainer2)!=null )
        {

            Toast.makeText(this,"ada2",Toast.LENGTH_LONG).show();
            _isTwoPane = true;

            AngkaFragment FrRandom = AngkaFragment.newInstance("0","0");
            _FM.beginTransaction()
                    .replace(R.id.frameContainer, FrRandom)
                    .commit();

            ResultFragment FrResult = ResultFragment.newInstance("0","0");
            _FM.beginTransaction()
                    .replace(R.id.frameContainer2, FrResult)
                    .commit();


        }
        else
        {
            _isTwoPane = false;
            AngkaFragment FrRandom = AngkaFragment.newInstance("0","0");
            _FM.beginTransaction()
                    .replace(R.id.frameContainer, FrRandom)
                    .commit();
        }

    }

    @Override
    public void onFragmentIntercation(String Data) {
        _dataFromFrg = Data;
        if(_isTwoPane)
        { ResultFragment FrResult = ResultFragment.newInstance(Data,"0");
            _FM.beginTransaction()
                    .replace(R.id.frameContainer2, FrResult)
                    .commit();}
        else
        {
            ResultFragment FrResult = ResultFragment.newInstance(Data,"0");
            _FM.beginTransaction()
                    .replace(R.id.frameContainer, FrResult)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

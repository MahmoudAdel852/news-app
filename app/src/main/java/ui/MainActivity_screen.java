package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pojo.MyModel;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.my_news_app.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_screen extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    MyViewModel myViewModel;
    MyAdapter adapter;
    ArrayList<String> myList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //......................................................
        // steps to use view model
        // 1- make abject from view model with new provider( activity) .get (view model .class)
        // 2- with this  object call mutable data by observer
        //......................................................
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        toolbar = findViewById( R.id.main_toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( " News App" );
        recyclerView = findViewById( R.id.recycler );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        myViewModel = new ViewModelProvider( this ).get( MyViewModel.class );
        myViewModel.getData();
        myViewModel.mutableLiveData.observe( this, new Observer<MyModel>() {
            @Override
            public void onChanged(MyModel myModel) {
                adapter = new MyAdapter( MainActivity_screen.this, myModel.getArticles() );
                recyclerView.setAdapter( adapter );

                for (int i = 0; i < myModel.getArticles().size(); i++) {
                    myList.add( myModel.getArticles().get( i ).getTitle() );
                }

            }
        } );
    }


}

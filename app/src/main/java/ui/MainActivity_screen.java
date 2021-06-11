package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pojo.MyModel;
import android.os.Bundle;
import android.view.Menu;

import com.example.my_news_app.R;

public class MainActivity_screen extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    MyViewModel myViewModel;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        toolbar=findViewById( R.id.main_toolbar );
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
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu( menu );
        getMenuInflater().inflate( R.menu.main_menu,menu );
        return true;
    }
}

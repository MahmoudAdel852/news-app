package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.my_news_app.R;

public class details_screen extends AppCompatActivity {
    ImageView imageView;
    TextView title,Author,description,time;
    Units u =new Units();
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

        String tv_title= getIntent().getStringExtra("title");
        title= findViewById( R.id.title_details );
        title.setText( tv_title );

        String tv_author= getIntent().getStringExtra("Author");
        Author=findViewById( R.id.author_details );
        Author.setText( tv_author );


        String Details= getIntent().getStringExtra("description");
        description= findViewById( R.id.details );
        description.setText( Details );

        String tv_time= getIntent().getStringExtra("time");
        time= findViewById( R.id.time_published_details );
        time.setText( u.getDateTime( tv_time ) );


        String tv_imageView= getIntent().getStringExtra("imgUrl");
        imageView= findViewById( R.id.image );
        Glide.with( this ).load( tv_imageView ).into( imageView );

        String tv_web= getIntent().getStringExtra("getUrl");
        webView= findViewById( R.id.web );
        if (tv_web != null) {
            webView.loadUrl( tv_web );
        }

    }
}

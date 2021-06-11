package ui;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.my_news_app.R;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import pojo.articles;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context1;
    List<articles> myList;
    Units units=new Units();
    MyAdapter (Context context, List<articles> list){
        this.context1=context;
        myList= list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from( context1 );
        View view = inflater.inflate( R.layout.row_items,parent,false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.title.setText( myList.get( position ).getTitle() );
        Glide.with( context1 ).load( myList.get( position ).getUrlToImage() ).into( holder.imageView );
        holder.author.setText( myList.get( position ).getAuthor() );
        holder.time.setText( units.getDateTime( myList.get( position ).getPublishedAt() ) );
        holder.time_years.setText( Units.getDatePerYear(myList.get( position ).getPublishedAt() ) );
        holder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( context1, details_screen.class );
                intent.putExtra( "Author",myList.get( position ).getAuthor() );
                intent.putExtra( "getUrl",myList.get( position ).getUrl() );
                intent.putExtra( "content",myList.get( position ).getContent() );
                intent.putExtra( "title",myList.get( position ).getTitle() );
                intent.putExtra( "description",myList.get( position ).getDescription() );
                intent.putExtra( "time",myList.get( position ).getPublishedAt() );
                intent.putExtra( "imgUrl",myList.get( position ).getUrlToImage() );

                context1.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return myList.size() ;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView title;
        ImageView imageView;
        TextView author;
        TextView time_years;
        CardView cardView;
        MyViewHolder(@NonNull View itemView) {
            super( itemView );
            author=itemView.findViewById( R.id.author_row );
           title=itemView.findViewById( R.id.title );
            time=itemView.findViewById( R.id.time_published);
            imageView=itemView.findViewById( R.id.image_row );
            time_years=itemView.findViewById( R.id. time_years );
            cardView=itemView.findViewById( R.id.card_row );
  }
    }
}

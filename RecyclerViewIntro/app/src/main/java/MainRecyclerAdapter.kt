import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewintro.R
import com.example.recyclerviewintro.customItemListener
import com.squareup.picasso.Picasso

class MainRecyclerAdapter(private val mDataSet: List<String>?, val clickAction: customItemListener) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return MainViewHolder(v)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet?.get(position)
        data?.let {
            holder.bindItems(it)
            holder.itemView.setOnClickListener{
                Log.v("tryme","He pulsado el elemento $data")
                clickAction.onItemClick(data, position)
            }

        }
    }
    override fun getItemCount(): Int {
        return mDataSet?.size ?: 0
    }
    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val text1 = v.findViewById(R.id.mytexto) as TextView
        private val miImagen1 = v.findViewById<ImageView>(R.id.miImagen)
        fun bindItems(data: String) {
            text1.text = data
            val url = "https://images.unsplash.com/photo-1587297470629-62d4fdeeb600?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80"
            Picasso.get().load(url).into(miImagen1)
        }
    }
}
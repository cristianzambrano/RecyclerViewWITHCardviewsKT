package uteq.solutions.recyclerviewconcardviewskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class RecyclerAdapter (val userList: ArrayList<Usuario>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lyitemusrcard, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNombre.text = userList[position].nombres
        holder.txtCorreo.text = userList[position].email
        holder.txtAvatar.text = userList[position].urlavatar

        Picasso.get().load(userList[position].urlavatar).into(holder.itemImage);
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var txtNombre: TextView
        var txtCorreo: TextView
        var txtAvatar: TextView

        init {
            txtNombre = itemView.findViewById(R.id.txtName)
            txtCorreo = itemView.findViewById(R.id.txtMail)
            txtAvatar = itemView.findViewById(R.id.txtAvatar)
            itemImage = itemView.findViewById(R.id.imgAvatar)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Item Selecccionado $position",
                    Snackbar.LENGTH_LONG).setAction("Actción", null).show()
            }
        }
    }
}
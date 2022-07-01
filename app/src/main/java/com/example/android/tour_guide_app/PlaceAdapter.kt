package com.example.android.tour_guide_app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.tour_guide_app.databinding.PlaceItemBinding

class PlaceAdapter: RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    private val placeList = ArrayList<Place>()

    class PlaceHolder(item: View): RecyclerView.ViewHolder(item){

        private val binding = PlaceItemBinding.bind(item)
        fun bind(place: Place) = with(binding){
            var collapsed = true
            Title.text = place.title
            ShortDesc.text = place.info
            InfoLong.text = place.longInfo
            Address.text = place.address
            Address2.text = place.address
            OpenUntil.text = place.openUntil
            OpenUntil2.text = place.openUntil
            Avg.text = place.average
            Call.text = place.phone
            Glide.with(imageView.context).load(place.imageId).into(imageView)



            //открывает звонилку
            Call.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${place.phone}")
                }
                Call.context.startActivity(intent)
            }

            //открывает карту
            Address2.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo:0,0?q=" + Uri.encode(place.address))
                }
                Address2.context.startActivity(intent)
            }

            //сворачивает и разворачивает элементы списка
            item.setOnClickListener {
                if(collapsed) {
                    Title.textSize = 30F
                    ShortDesc.textSize = 20F
                    Address.visibility = View.GONE
                    OpenUntil.visibility = View.GONE
                    OpenUntilLabel.visibility = View.GONE
                    ExpandableGroup.visibility = View.VISIBLE
                    Glide.with(Arrow.context).load(R.drawable.up).into(Arrow)
                    collapsed = false

                }else{
                    Title.textSize = 16F
                    ShortDesc.textSize = 14F
                    Address.visibility = View.VISIBLE
                    OpenUntil.visibility = View.VISIBLE
                    OpenUntilLabel.visibility = View.VISIBLE
                    ExpandableGroup.visibility = View.GONE
                    Glide.with(Arrow.context).load(R.drawable.down).into(Arrow)
                    collapsed = true
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.bind(placeList[position])
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    fun addPlaces(list: List<Place>){
        placeList.addAll(list)
        notifyDataSetChanged()
    }

}

package com.example.android.tour_guide_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.tour_guide_app.databinding.PlaceItemBinding

class PlaceAdapter: RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    private val placeList = ArrayList<Place>()

    class PlaceHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = PlaceItemBinding.bind(item)
        fun bind(place: Place) = with(binding){
            var collapsed = true
            imageView.setImageResource(place.imageId)
            Title.text = place.title
            ShortDesc.text = place.info
            Address.text = place.address
            Address2.text = place.address
            OpenUntil.text = place.openUntil
            OpenUntil2.text = place.openUntil
            Avg.text = place.average
            item.setOnClickListener {
                if(collapsed) {
                    Title.textSize = 35F
                    ShortDesc.textSize = 20F
                    Address.visibility = View.GONE
                    OpenUntil.visibility = View.GONE
                    OpenUntilLabel.visibility = View.GONE
                    ExpandableGroup.visibility = View.VISIBLE
                    collapsed = false
                }else{
                    Title.textSize = 16F
                    ShortDesc.textSize = 14F
                    Address.visibility = View.VISIBLE
                    OpenUntil.visibility = View.VISIBLE
                    OpenUntilLabel.visibility = View.VISIBLE
                    ExpandableGroup.visibility = View.GONE
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
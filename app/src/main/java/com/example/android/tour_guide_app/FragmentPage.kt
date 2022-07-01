package com.example.android.tour_guide_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.tour_guide_app.databinding.FragmentPageBinding


const val ARG_OBJECT = "object"

class FragmentPage : Fragment() {
    private val adapter = PlaceAdapter()
    private lateinit var binding: FragmentPageBinding
    private var position = 0
    private val cafes: MutableList<Place> = mutableListOf(
        Place(R.drawable.kfc, "KFC","Fast food" , "ресторан быстрого обслуживания", "2:00", "Горького 130 Радищева 1", "900c","+996 550 880 197"),
        Place(R.drawable.dodo, "Dodo pizza", "Пиццерия", "ресторан быстрого обслуживания", "6:00", "Байтик баатыра 96", "500c", "+996 312 550 550"),
        Place(R.drawable.empire, "Империя пиццы", "Пиццерия", "ресторан быстрого обслуживания", "4:00", "Горького 27,1", "350c","+996 772 554 090"),
    )
    private val places: MutableList<Place> = mutableListOf(
        Place(R.drawable.baku, "Огни баку", "Шашлычная", "Ресторан / Кафе", "24:00", "Анарбека Бакаева, 53а", "600с","+996 551 165 135"),
        Place(R.drawable.no1, "Шашлычная №1", "Шашлычная", "Ресторан / Кафе", "01:00", "Cаякбая Каралаева, 1а", "700c","+996 551 706 080"),
        Place(R.drawable.karabah, "Карабах", "Шашлычная", "Ресторан / Кафе", "03:00", "Московская, 15/1", "700c","+996 997 223 321"),
    )
    private val cinemas: MutableList<Place> = mutableListOf(
        Place(R.drawable.rossia, "Россия", "Кинотеатр", "Кинотеатр", "24:00", "проспект Чуй 213", "250с","+996 312 660 960"),
        Place(R.drawable.ala_too, "Ала-Тоо", "Кинотеатр", "Кинотеатр", "24:00", "проспект Чуй 187", "400c", "+996 312 661 957"),
        Place(R.drawable.tsum, "ЦУМ Cinema", "Лазерный кинотеатр", "Кинотеатр", "24:00", "Шопокова 91","380c", "+996 500 000 005"),
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentPageBinding.inflate(layoutInflater)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            position = getInt(ARG_OBJECT)
        }
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
            when(position){
                0 -> adapter.addPlaces(cafes)
                1 -> adapter.addPlaces(places)
                else -> adapter.addPlaces(cinemas)
            }
        }
    }
}

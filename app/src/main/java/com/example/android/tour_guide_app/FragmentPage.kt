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
    private val cinemas: MutableList<Place> = mutableListOf(
        Place(R.drawable.place1, "Россия", "Кинотеатр", "Кинотеатр", "24:00", "проспект Чуй, 213", "geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Ала-Тоо", "Кинотеатр", "Кинотеатр", "24:00", "проспект Чуй, 187","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "ЦУМ Cinema", "Лазерный кинотеатр", "Кинотеатр", "24:00", "Шопокова, 91","geo:42.87672, 74.596946", "400c"),
    )
    private val cafes: MutableList<Place> = mutableListOf(
        Place(R.drawable.place1, "KFC","Fast food" , "ресторан быстрого обслуживания", "2:00", "улица Максима Горького, 130","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Dodo pizza", "Пиццерия", "ресторан быстрого обслуживания", "6:00", "улица Максима Горького, 124","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Империя пиццы", "Пиццерия", "ресторан быстрого обслуживания", "4:00", "Байтик Баатыра, 98","geo:42.87672, 74.596946", "400c"),
    )
    private val places: MutableList<Place> = mutableListOf(
        Place(R.drawable.place1, "Место", "Инфо", "Описание", "X:YY", "Улица 1а","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Место", "Инфо", "Описание", "X:YY", "Улица 1а","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Место", "Инфо", "Описание", "X:YY", "Улица 1а","geo:42.87672, 74.596946", "400c"),
        Place(R.drawable.place1, "Место", "Инфо", "Описание", "X:YY", "Улица 1а","geo:42.87672, 74.596946", "400c"),
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

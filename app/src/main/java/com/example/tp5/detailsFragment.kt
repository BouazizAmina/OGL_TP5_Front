package com.example.tp5

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.tp5.viewmodel.MyModel


class detailsFragment : Fragment() {


//    private lateinit var binding = FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vm = ViewModelProvider(requireActivity()).get(MyModel::class.java)

        val list = vm.data
        var pos = requireArguments().getInt("position")

//        list[pos].image.let { requireActivity().findViewById<ImageView>(R.id.imageParking).setImageResource(it).toString() }
//        requireActivity().findViewById<TextView>(R.id.nom1).setText(list[pos].nom)
//        requireActivity().findViewById<TextView>(R.id.nom2).setText(list[pos].nom)
//        requireActivity().findViewById<TextView>(R.id.emplacement).setText(list[pos].commune)
//        requireActivity().findViewById<TextView>(R.id.state).setText(list[pos].etat)
//        if(list[pos].etat == "Fermé"){
//            requireActivity().findViewById<TextView>(R.id.state).setTextColor(Color.RED)
//        }
//        else{
//            requireActivity().findViewById<TextView>(R.id.state).setTextColor(Color.GREEN)
//        }
//        requireActivity().findViewById<TextView>(R.id.pourcentage).setText(list[pos].taux.toString()+"%")
//        requireActivity().findViewById<TextView>(R.id.dist).setText(list[pos].distance.toString()+" km")
//        requireActivity().findViewById<TextView>(R.id.jour).setText("Dimanche")
//        requireActivity().findViewById<TextView>(R.id.tempsdispo).setText(list[pos].tempsOuv.toString()+":00 à "+list[pos].tempsFerm.toString()+":00")
//        requireActivity().findViewById<TextView>(R.id.nbh).setText(list[pos].unitPrice.toString())
//        requireActivity().findViewById<TextView>(R.id.price).setText(list[pos].prix.toString())
//        requireActivity().findViewById<TextView>(R.id.time).setText(list[pos].duree.toString()+" min")

    }
}
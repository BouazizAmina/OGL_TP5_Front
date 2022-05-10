package com.example.tp5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.adapter.MyAdapter
import com.example.tp5.viewmodel.MyModel


class mainFragment : Fragment() {

//    private lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(requireActivity()).get(MyModel::class.java)
        // Récupération de la liste modifé dans le premier fragment
        val list = vm.data

        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MyAdapter({position -> onClickDevice(position)},requireActivity())

    }

    private fun onClickDevice(position: Int) {
        var bundle = bundleOf("position" to position)
//        var bundle = Bundle()
//        bundle.putInt("position",position)
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_detailsFragment,bundle)
    }
}
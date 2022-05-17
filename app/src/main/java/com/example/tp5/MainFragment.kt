package com.example.tp5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp5.adapter.MyAdapter
import com.example.tp5.viewmodel.MyModel


class mainFragment : Fragment() {

//    private lateinit var binding : FragmentMainBinding
    lateinit var adapter:MyAdapter
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
        vm.loadParkings()

        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
        adapter = MyAdapter({position -> onClickDevice(position)},requireActivity())
        recyclerView.adapter = adapter
        vm.loading.observe(requireActivity(), Observer {  loading->
            if(loading) {
                //binding.progressBar.visibility = View.VISIBLE
                val pr = view.findViewById(R.id.progressBar) as ProgressBar
                pr.setVisibility(View.VISIBLE)
            }
            else {
                //binding.progressBar.visibility = View.GONE
                val pr = view.findViewById(R.id.progressBar) as ProgressBar
                pr.setVisibility(View.GONE)
            }


        })
        // Error message observer
        vm.errorMessage.observe(requireActivity(), Observer {  message ->
            Toast.makeText(requireContext(),"Une erreur s'est produite",Toast.LENGTH_SHORT).show()
            //Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()

        })


        // List movies observer
        vm.data.observe(requireActivity(), Observer {  data ->
            adapter.setParkings(data)

        })
    }

    private fun onClickDevice(position: Int) {
        var bundle = bundleOf("position" to position)
//        var bundle = Bundle()
//        bundle.putInt("position",position)
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_detailsFragment,bundle)
    }
}
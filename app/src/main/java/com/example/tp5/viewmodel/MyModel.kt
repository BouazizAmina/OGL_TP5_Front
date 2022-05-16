package com.example.tp5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp5.retrofit.Endpoint
import com.example.tp5.entity.Parking
import kotlinx.coroutines.*

class MyModel: ViewModel() {
    // Les données à partager entre les fragments
    var data = MutableLiveData<List<Parking>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError(throwable.localizedMessage)
    }


    fun loadParkings() {
        if(data.value==null) {
            CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                val response = Endpoint.createInstance().getAllParkings()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body() != null) {
                        loading.value = false
                        data.postValue(response.body())

                    } else {
                        onError(response.message())
                    }
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
//    var data = mutableListOf<Parking>()
//    init {
//        data.add(Parking(R.drawable.parking2,"Ouvert",66,"Parking Jardin d'essai","Alger",8.86,14,3,9,1,60.2 ))
//        data.add(Parking(R.drawable.parking2,"Fermé",30,"Parking Said Hamdine","Alger",12.95,17,4,6,6,70.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",95,"parking Val d'hydra","Alger",12.95,17,6,7,4,50.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",95,"parking Val d'hydra","Alger",12.95,17,8,9,3,80.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",66,"Parking Jardin d'essai","Alger",8.86,14,1,2,2,50.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",30,"Parking Said Hamdine","Alger",12.95,17,5,6,1,60.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",95,"parking Val d'hydra","Alger",12.95,17,6,7,2,100.0))
//        data.add(Parking(R.drawable.parking2,"Fermé",95,"parking Val d'hydra","Alger",12.95,17,5,8,1,50.0))
//
//    }

}
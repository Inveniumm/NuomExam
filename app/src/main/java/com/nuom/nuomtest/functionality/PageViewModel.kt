package com.nuom.nuomtest.functionality

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.google.gson.JsonElement
import com.nuom.nuomtest.data.ApiInterface
import com.nuom.nuomtest.data.ApiRequestProvider
import com.nuom.nuomtest.functionality.enums.TAB_TITLES

import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

class PageViewModel(application: Application) : AndroidViewModel(application), Observable {

    private val apiInterface: ApiInterface = ApiRequestProvider.getRetrofitInstance()

    private val _index = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        _index.value = index
    }

    @Bindable
    val text: LiveData<String> = Transformations.map(_index) {
//        "Hello world from section: $it"
        when (it) {
            1 -> ""
            else -> ""
        }

    }

    @Bindable
    val requestResponse = MutableLiveData<String>()

    @Bindable
    val buttonText: LiveData<String> = Transformations.map(_index) {
        "Execute ${application.resources.getString(TAB_TITLES[_index.value!! - 1])} request"
    }

    /**
     * Execute a request, depending on the current active tab
     */
    fun executeRequest() = viewModelScope.launch {
        requestResponse.value = "Requesting..."

        val response: Response<JsonElement> = when (_index.value) {
            1 -> apiInterface.getPosts()

            else -> apiInterface.getPosts()
        }
        requestResponse.value = (JSONObject(response.body().toString()).getString("value"))
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
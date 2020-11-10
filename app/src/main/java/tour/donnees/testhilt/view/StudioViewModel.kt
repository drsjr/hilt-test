package tour.donnees.testhilt.view

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import tour.donnees.testhilt.model.Movie
import tour.donnees.testhilt.repository.StudioRepository
import tour.donnees.testhilt.util.DataState

class StudioViewModel
@ViewModelInject
constructor(
    private val repository: StudioRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Movie>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Movie>>>
        get() = _dataState


    fun setStateEvent(studioStateEvent: StudioStateEvent) {
        viewModelScope.launch {
            when (studioStateEvent) {

                is StudioStateEvent.GetStudioEvents -> {
                    repository.getMovie().onEach { dataState ->
                        _dataState.value = dataState
                    }.launchIn(viewModelScope)
                }

                is StudioStateEvent.None -> {
                    //who cares
                }
            }
        }
    }

}

sealed class StudioStateEvent {

    object GetStudioEvents: StudioStateEvent()

    object None: StudioStateEvent()
}
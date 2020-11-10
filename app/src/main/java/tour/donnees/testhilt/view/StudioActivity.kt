package tour.donnees.testhilt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_studio.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import tour.donnees.testhilt.R
import tour.donnees.testhilt.model.Movie
import tour.donnees.testhilt.util.DataState
import tour.donnees.testhilt.util.hide
import tour.donnees.testhilt.util.show
import java.lang.StringBuilder

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class StudioActivity : AppCompatActivity() {

    private val viewModel: StudioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studio)
        subscribeObservers()
        viewModel.setStateEvent(StudioStateEvent.GetStudioEvents)
    }

    private fun subscribeObservers() {

        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Movie>> -> {
                    progress_bar.hide()
                    showAllMoviesNames(dataState.data)
                }

                is DataState.Loading -> {
                    progress_bar.show()
                }

                is DataState.Error -> {
                    progress_bar.hide()
                }
            }
        })
    }

    private fun showAllMoviesNames(movies: List<Movie>) {
        var _text = StringBuilder()

        movies.onEach {
            _text.append(it.title + "\n")
        }

        text.text = _text.toString()
    }


}


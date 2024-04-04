import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.viewmodeldemo.data.AppRepository

// (1)
//class HomePageViewModel {
// (2)
//class HomePageViewModel : ViewModel() {
// (3)
class HomePageViewModel(private val repository: AppRepository) : ViewModel() {

  var luckyNumber by mutableStateOf(-1)
    private set

  fun getLuckyNumber() {
    // (2)
//    luckyNumber = (0..100).random()
//    Log.i(javaClass.simpleName, "ViewModel.getLuckyNumber")

    // (3)
    luckyNumber = repository.getLuckyNumber()
  }

  // (3)
  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        HomePageViewModel(AppRepository())
      }
    }
  }
}
package data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

class BorrowedListViewModel(application: Application) : AndroidViewModel(application) {
    val itemAndPersonList: LiveData<List<BorrowModel>>
    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getDatabase(this.getApplication<Application>());
        itemAndPersonList = appDatabase.itemAndPersonModel().allBorrowedItems
    }

    fun deleteItem(borrowModel: BorrowModel) {
        deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private class deleteAsyncTask internal constructor(private val db: AppDatabase) : AsyncTask<BorrowModel, Void, Void>() {
        override fun doInBackground(vararg params: BorrowModel): Void? {
            db.itemAndPersonModel().deleteBorrow(params[0])
            return null
        }
    }
}

package data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

class BorrowViewModel(application: Application) : AndroidViewModel(application) {
    val itemAndPersonList: LiveData<List<BorrowModel>>
    private val appDatabase: AppDatabase

    init {
        appDatabase = AppDatabase.getDatabase(application);
        itemAndPersonList = appDatabase.itemAndPersonModel().allBorrowedItems
    }

    fun addItem(borrowModel: BorrowModel) {
        addAsyncTask(appDatabase).execute(borrowModel)
    }

    private class addAsyncTask internal constructor(private val db: AppDatabase) : AsyncTask<BorrowModel, Void, Void>() {
        override fun doInBackground(vararg params: BorrowModel): Void? {
            db.itemAndPersonModel().addBorrow(params[0])
            return null
        }
    }
}

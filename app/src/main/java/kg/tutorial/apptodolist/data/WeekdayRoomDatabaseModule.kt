package kg.tutorial.apptodolist.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.tutorial.apptodolist.dao.WeekdayDao
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class WeekdayRoomDatabaseModule {
    @Provides
    fun provideChannelDao(weekdayRoomDatabase: WeekdayRoomDatabase): WeekdayDao {
        return weekdayRoomDatabase.weekdayDao()
    }
    //provides kak singleton propisat fun getDatabase


    @InternalCoroutinesApi
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): WeekdayRoomDatabase {
        return WeekdayRoomDatabase.getDatabase(context)
    }

}


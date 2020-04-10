package com.prography.android_6th_study.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prography.android_6th_study.BaseViewModel
import com.prography.android_6th_study.adapters.PopularsAdapter
import com.prography.android_6th_study.adapters.ThemeAdapter
import com.prography.android_6th_study.models.PopularsMyTrip
import com.prography.android_6th_study.models.ThemesMyTrip

class MyTripViewModel : BaseViewModel() {

    var pAdapter: PopularsAdapter = PopularsAdapter(this)
    var tAdapter: ThemeAdapter = ThemeAdapter()

    var popularsMyTripList: LiveData<List<PopularsMyTrip>> = MutableLiveData(
        listOf(
            PopularsMyTrip(no = 1, title = "서울", imgUrl = "https://bit.ly/2yQFIUR"),
            PopularsMyTrip(no = 2, title = "제주", imgUrl = "https://bit.ly/34pZguV"),
            PopularsMyTrip(no = 3, title = "부산", imgUrl = "https://bit.ly/3eb0TRI"),
            PopularsMyTrip(no = 4, title = "도쿄", imgUrl = "https://bit.ly/2UXd0Km"),
            PopularsMyTrip(no = 5, title = "방콕", imgUrl = "https://bit.ly/34odYTh"),
            PopularsMyTrip(no = 6, title = "다낭", imgUrl = "https://bit.ly/3ed5N0D")
        )
    )
    var themeList: LiveData<List<ThemesMyTrip>> = MutableLiveData(listOf())
}
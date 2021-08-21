package com.example.myvoozkotlin.notification.domain

import com.example.homelibrary.model.Notification
import com.example.myvoozkotlin.models.news.News
import com.example.myvoozkotlin.helpers.Event
import com.example.myvoozkotlin.models.SearchItem
import kotlinx.coroutines.flow.Flow

interface UniversityNotificationListUseCase {
    operator fun invoke(idUniversity: Int): Flow<Event<List<Notification>>>
}
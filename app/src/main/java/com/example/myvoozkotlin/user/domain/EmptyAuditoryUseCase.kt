package com.example.myvoozkotlin.user.domain

import com.example.homelibrary.model.AuthUser
import com.example.homelibrary.model.Lesson
import com.example.myvoozkotlin.models.news.News
import com.example.myvoozkotlin.helpers.Event
import com.example.myvoozkotlin.searchEmptyAuditory.model.Classroom
import kotlinx.coroutines.flow.Flow

interface EmptyAuditoryUseCase {
    operator fun invoke(date: String, idCorpus: Int, lowNumber: Int, upperNumber: Int, idUniversity: Int): Flow<Event<List<List<Classroom>>>>
}
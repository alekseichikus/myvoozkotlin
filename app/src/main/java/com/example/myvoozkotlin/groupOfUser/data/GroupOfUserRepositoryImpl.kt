package com.example.myvoozkotlin.groupOfUser.data

import com.example.homelibrary.model.EntryLink
import com.example.homelibrary.model.InviteData
import com.example.homelibrary.model.UserShort
import com.example.myvoozkotlin.data.api.GroupOfUserApi
import com.example.myvoozkotlin.models.news.News
import com.example.myvoozkotlin.data.api.NewsApi
import com.example.myvoozkotlin.data.db.DbUtils
import com.example.myvoozkotlin.groupOfUser.domain.GroupOfUserRepository
import com.example.myvoozkotlin.helpers.Event
import com.example.myvoozkotlin.home.domain.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GroupOfUserRepositoryImpl @Inject constructor(
    private val groupOfUserApi: GroupOfUserApi,
    private val dbUtils: DbUtils,
) : GroupOfUserRepository {

    override fun createGroupOfUser(
        accessToken: String,
        idUser: Int,
        name: String,
        idGroup: Int
    ): Flow<Event<InviteData>>  =
        flow<Event<InviteData>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.createGroupOfUser(accessToken, idUser, name, idGroup)

            if (apiResponse.isSuccessful && apiResponse.body() != null)
                emit(Event.success(apiResponse.body()!!))
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun inviteGroupOfUser(
        accessToken: String,
        idUser: Int,
        text: String
    ): Flow<Event<InviteData>> =
        flow<Event<InviteData>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.inviteGroupOfUser(accessToken, idUser, text)

            if (apiResponse.isSuccessful && apiResponse.body() != null)
                emit(Event.success(apiResponse.body()!!))
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun logoutGroupOfUser(accessToken: String, idUser: Int): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.logoutGroupOfUser(accessToken, idUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                val authUserModel = dbUtils.getCurrentAuthUser()
                authUserModel!!.idGroupOfUser = 0
                dbUtils.setCurrentAuthUser(authUserModel)
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun changeIdGroup(
        accessToken: String,
        idUser: Int,
        idGroup: Int
    ): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.changeGroup(accessToken, idUser, idGroup)

            if (apiResponse.isSuccessful && apiResponse.body() != null)
                emit(Event.success(apiResponse.body()!!))
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun changeName(accessToken: String, idUser: Int, text: String): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.changeName(accessToken, idUser, text)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                val authUserModel = dbUtils.getCurrentAuthUser()
                authUserModel!!.groupOfUser!!.name = text
                dbUtils.setCurrentAuthUser(authUserModel)
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun getUserList(accessToken: String, idUser: Int): Flow<Event<List<UserShort>>> =
        flow<Event<List<UserShort>>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.getUserList(accessToken, idUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun getEntryLink(accessToken: String, idUser: Int): Flow<Event<EntryLink>> =
        flow<Event<EntryLink>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.getEntryLink(accessToken, idUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun updateEntryLink(accessToken: String, idUser: Int): Flow<Event<EntryLink>> =
        flow<Event<EntryLink>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.updateEntryLink(accessToken, idUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun lockEntryLink(accessToken: String, idUser: Int, state: Int): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.lockEntryLink(accessToken, idUser, state)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun makeHead(accessToken: String, idUser: Int, idSelUser: Int): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.makeUserHead(accessToken, idUser, idSelUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }

    override fun removeUser(
        accessToken: String,
        idUser: Int,
        idSelUser: Int
    ): Flow<Event<Boolean>> =
        flow<Event<Boolean>> {
            emit(Event.loading())
            val apiResponse = groupOfUserApi.removeUser(accessToken, idUser, idSelUser)

            if (apiResponse.isSuccessful && apiResponse.body() != null){
                emit(Event.success(apiResponse.body()!!))
            }
            else{
                emit(Event.error("lol"))
            }
        }.catch { e ->
            emit(Event.error("lol2"))
            e.printStackTrace()
        }
}
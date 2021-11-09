package com.example.lessononerx.impl

import com.example.lessononerx.domain.City
import com.example.lessononerx.domain.UserProfile
import com.example.lessononerx.domain.UserStorage
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class UserRoomStorageImpl: UserStorage {
    private val currentUserList: MutableList<UserProfile> = mutableListOf()
    private val behaviorSubject = BehaviorSubject.createDefault<List<UserProfile>>(currentUserList)

    override val users: Observable<List<UserProfile>>
        //генерация одного события
        //get() = Observable.just(listOf(UserProfile("test",0, 0, City("city"),"","", "", "")))
        //периодическая генерация элементов
        /*get() = Observable
            .interval(2, TimeUnit.SECONDS)
            .map {
                //listOf(UserProfile("test",0, 0, City("city"),"","", "", ""))
                currentUserList
              }*/
       get() = behaviorSubject

    override fun saveUser(user: UserProfile) {
        currentUserList.add(user.copy(id = UUID.randomUUID().toString()))
        behaviorSubject.onNext(currentUserList)
    }

    override fun getUsers(): List<UserProfile> {
        return ArrayList(currentUserList)
    }
}
package com.example.lessononerx.domain

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class EventBus {
    open class Event
    private val busMap = HashMap<String, PublishSubject<Event>>()
    //private val bus =  BehaviorSubject.create<Event>()
    //private val bus =  PublishSubject.create<Event>()

    /*fun post(event: Event) {
        bus.onNext(event)
    }*/
    fun post(busKey: String, event: Event) {
        getBus(busKey).onNext(event)
    }

    private fun getBus(busKey: String): PublishSubject<Event> {
        //val bus = busMap[busKey]
        if(!busMap.containsKey(busKey)) {
            busMap.put(busKey, PublishSubject.create<Event>())
        }
        return busMap[busKey]!!
    }

    //fun get(): Observable<Event> = bus
    //fun get(busKey: String): Observable<Event>? = busMap[busKey]
    fun get(busKey: String): Observable<Event> = getBus(busKey)
}
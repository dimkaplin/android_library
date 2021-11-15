package com.example.lessononerx.domain

val MANUAL_COUNTER_BUS = "manual_counter_bus"
val AUTO_COUNTER_BUS = "auto_counter_bus"

class RegisterEvent: EventBus.Event() {
}

class LoginEvent: EventBus.Event() {
}

class ForgetEvent: EventBus.Event() {
}
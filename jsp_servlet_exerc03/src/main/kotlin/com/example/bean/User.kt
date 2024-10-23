package com.example.bean

import java.io.Serializable

/**
 * @author uncle_yumo
 * @fileName User
 * @createDate 2024/10/23 October
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class User(
    private var id: Int?,
    private var username: String?,
    private var gender: String?,
    private var age: Int?,
    private var member: Boolean?
): Serializable {
    constructor(): this(null, "", "", null, null)

    fun getId() = id
    fun getUsername() = username
    fun getGender() = gender
    fun getAge() = age
    fun getMember() = member
    fun setId(id: Int) {
        this.id = id
    }
    fun setUsername(username: String) {
        this.username = username
    }
    fun setGender(gender: String) {
        this.gender = gender
    }
    fun setAge(age: Int) {
        this.age = age
    }
    fun setMember(member: Boolean) {
        this.member = member
    }
}
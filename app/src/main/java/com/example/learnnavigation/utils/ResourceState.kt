package com.example.learnnavigation.utils

class ResourceState(val status:ResourceStatus, val data: Any?, val message : String? ) {

    companion object {
        fun success(data: Any?) = ResourceState(ResourceStatus.SUCCESS, data = data, message = null)

        fun fail(message: String?) = ResourceState(ResourceStatus.FAIL, data = null, message = message)

        fun loading() = ResourceState(ResourceStatus.LOADING, data = null, message = null)
    }
}